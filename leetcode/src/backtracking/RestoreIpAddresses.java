package backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author:zxp
 * @Description:有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。
 *
 * 例如："0.1.2.201" 和 "192.168.1.1" 是 有效 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 和 "192.168@1.1" 是 无效 IP 地址。
 * 给定一个只包含数字的字符串 s ，用以表示一个 IP 地址，返回所有可能的有效 IP 地址，这些地址可以通过在 s 中插入 '.' 来形成。你 不能 重新排序或删除 s 中的任何数字。你可以按 任何 顺序返回答案。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "25525511135"
 * 输出：["255.255.11.135","255.255.111.35"]
 * 示例 2：
 *
 * 输入：s = "0000"
 * 输出：["0.0.0.0"]
 * 示例 3：
 *
 * 输入：s = "101023"
 * 输出：["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
 *
 *
 * 提示：
 *
 * 1 <= s.length <= 20
 * s 仅由数字组成
 * @Date:15:07 2024/1/7
 */
public class RestoreIpAddresses {
    public static void main(String[] args) {
        RestoreIpAddresses restoreIpAddresses = new RestoreIpAddresses();
        RestoreIpAddressesⅡ restoreIpAddressesⅡ = new RestoreIpAddressesⅡ();
        System.out.println(restoreIpAddressesⅡ.restoreIpAddresses("25525511135"));
        System.out.println(restoreIpAddresses.restoreIpAddresses("25525511135"));
    }
    public List<String> restoreIpAddresses(String s){//个人感觉这里的一些地方还可以优化，稍后考虑。
        List<String> result=new ArrayList<>();
        List<String> subResult=new ArrayList<>();
        if(s.length()==0)
            return result;
        backtracking(0,s,result,subResult);
        return result;
    }
    public void backtracking(int startIndex,String s,List<String> result,List<String> subResult){
        if(startIndex>=s.length()&&subResult.size()==4){
            String string = getString(subResult);
            result.add(string);
            return;
        }
        for(int i=startIndex;i<s.length();i++){
//            if(i-startIndex+1>3)
//                break;
            if(isValid(s,startIndex,i)){
//                Character[] characters = new Character[i - startIndex + 1];
//                for(int j=startIndex,k=0;j<=i;j++,k++){
//                    characters[k]=s.charAt(j);
//                }
                String substring = s.substring(startIndex, i + 1);
                subResult.add(substring);

                backtracking(i+1,s,result,subResult);
                subResult.remove(subResult.size()-1);
            }
        }
    }
    public boolean isValid(String s,int start,int end){
//        char[] chars = new char[end - start + 1];
        if(end-start+1>3)
            return false;
        String substring = s.substring(start, end + 1);
        if(substring.charAt(0)=='0'&&substring.length()>1)
            return false;
        int i = Integer.parseInt(substring);
        if(i>=0&&i<=255)
            return true;
        return false;
    }
    public String getString(List<String> subResult){
        StringBuilder s = new StringBuilder();
        for(int i=0;i<subResult.size();i++){
            String s1 = subResult.get(i);
            s.append(s1);
            if(i!=subResult.size()-1){
                s.append(".");
            }
        }
        return s.toString();
    }
}
class RestoreIpAddressesⅡ{
    public List<String> restoreIpAddresses(String s){
        List<String> result=new ArrayList<>();
        List<String> subResult=new ArrayList<>();
        if(s.length()<3)
            return result;
        backtracking(s,0,result,subResult,0);
        return result;
    }
    public void backtracking(String s,int startIndex,List<String> result,List<String> subResult,int pointNum){
        if(startIndex==s.length())
            return;
        if(pointNum==3){
            String substring = s.substring(startIndex,s.length());
            if(isValid(substring)){
                subResult.add(substring);
                String string = getString(subResult);
                result.add(string);
                subResult.remove(subResult.size()-1);
            }
            return;
        }
        for(int i=startIndex;i<s.length();i++){
            if(isValid(s.substring(startIndex,i+1))){
                subResult.add(s.substring(startIndex,i+1));
                pointNum++;
                backtracking(s,i+1,result,subResult,pointNum);
                subResult.remove(subResult.size()-1);
                pointNum--;
            }
            else continue;
        }
    }
    public boolean isValid(String s){
        if(s.length()>1&&s.charAt(0)=='0')
            return false;
        if(s.length()>3)
            return false;
        int i = Integer.parseInt(s);
        if(i>=0&&i<=255)
            return true;
        return false;
    }
    public String getString(List<String> subResult){
        StringBuilder stringBuilder = new StringBuilder();
        for(int i=0;i<subResult.size();i++){
            stringBuilder.append(subResult.get(i));
            if(i!=subResult.size()-1)
                stringBuilder.append(".");
        }
        return stringBuilder.toString();
    }
}