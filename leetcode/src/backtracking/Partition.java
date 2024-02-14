package backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author:zxp
 * @Description:给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。
 *
 * 回文串 是正着读和反着读都一样的字符串。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "aab"
 * 输出：[["a","a","b"],["aa","b"]]
 * 示例 2：
 *
 * 输入：s = "a"
 * 输出：[["a"]]
 *
 *
 * 提示：
 *
 * 1 <= s.length <= 16
 * s 仅由小写英文字母组成
 * @Date:15:34 2024/1/6
 */
public class Partition {
    public static void main(String[] args) {
        Partition partition = new Partition();
        System.out.println(partition.partition(""));
    }
    public List<List<String>> partition(String s){
        List<List<String>> result=new ArrayList<>();
        List<String> subResult=new ArrayList<>();
        if(s.length()==0)
            return result;
        backtracking(s,0,result,subResult);
        return result;
    }
    public void backtracking(String s,int startIndex,List<List<String>> result,List<String> subResult){
        if(startIndex>=s.length()){
            result.add(new ArrayList<>(subResult));
            return;
        }
        for(int i=startIndex;i<s.length();i++){
            if(isPalidrome(s,startIndex,i)){
                subResult.add(partOfString(s,startIndex,i));
                backtracking(s,i+1,result,subResult);
                subResult.remove(subResult.size()-1);
            }
            else
                continue;
        }
    }
    public boolean isPalidrome(String s,int start,int end){
        for(int i=start,j=end;i<j;i++,j--){
            if(s.charAt(i)!=s.charAt(j))
                return false;
        }
        return true;
    }
    public String partOfString(String s,int start,int end){
        int length=end-start+1;
        char[] chars = new char[length];
        for(int i=start,j=0;i<=end;i++,j++)
            chars[j]=s.charAt(i);
        return new String(chars);
    }
}
