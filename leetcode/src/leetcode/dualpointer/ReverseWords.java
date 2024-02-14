package leetcode.dualpointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author:zxp
 * @Description:给你一个字符串 s ，请你反转字符串中 单词 的顺序。
 *
 * 单词 是由非空格字符组成的字符串。s 中使用至少一个空格将字符串中的 单词 分隔开。
 *
 * 返回 单词 顺序颠倒且 单词 之间用单个空格连接的结果字符串。
 *
 * 注意：输入字符串 s中可能会存在前导空格、尾随空格或者单词间的多个空格。返回的结果字符串中，单词间应当仅用单个空格分隔，且不包含任何额外的空格。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "the sky is blue"
 * 输出："blue is sky the"
 * 示例 2：
 *
 * 输入：s = "  hello world  "
 * 输出："world hello"
 * 解释：反转后的字符串中不能存在前导空格和尾随空格。
 * 示例 3：
 *
 * 输入：s = "a good   example"
 * 输出："example good a"
 * 解释：如果两个单词间有多余的空格，反转后的字符串需要将单词间的空格减少到仅有一个。
 * @Date:16:55 2023/10/13
 */
public class ReverseWords {
    public static void main(String[] args) {
        String s="  hello world  ";
        ReverseWords reverseWords = new ReverseWords();
        System.out.println(reverseWords.reverseWords(s));
    }
    public String reverseWords(String s){
        char[] chars=new char[s.length()];
        for(int i=s.length()-1,j=0;i>=0;i--,j++){
            chars[j]=s.charAt(i);
        }
        int currentIndex=0;
        while (currentIndex< chars.length){
            if(chars[currentIndex]!=' '){
                int start=currentIndex;
                int end;
                for(int right=currentIndex;right< chars.length;right++){
                    if(chars[right]==' '||((right== chars.length-1)&&chars[right]!=' ')){
                        if(chars[right]==' ')
                            end=right-1;
                        else
                            end=right;
                        currentIndex=right;
//                        System.out.println(start);
                        while (start<end){
                            char c=chars[start];
                            chars[start]=chars[end];
                            chars[end]=c;
                            start++;
                            end--;
                        }
                        break;
                    }
                }

                }
            else
                currentIndex++;
            if(currentIndex== chars.length-1)
                break;
//            System.out.println(currentIndex);
//            System.out.println(chars);
            }
        List<Character> charList=new ArrayList<>();
        for(int i=0;i< chars.length;i++){
//            if(chars[i]!=' '||(chars[i]==' '&&i!=0&&chars[i-1]!=' '&&chars[i+1]!=' ')){
//                charList.add(chars[i]);
//            }
            if(chars[i]!=' ')
                charList.add(chars[i]);
            else if(chars[i]==' '&&i!=0){
                if(charList.size()>0&&charList.get(charList.size()-1)!=' '){
                    charList.add(chars[i]);
                }
            }
        }
        if(charList.get(charList.size()-1)==' ')
            charList.remove(charList.size()-1);
//        int i=0;
//        while (i<chars.length){
//            if(chars[i]!=' '){
//                charList.add(chars[i]);
//                i++;
//            }
//
//            else if(chars[i]==' '&&i==0){
//                i++;
//            }
//            else if(chars[i]==' '&&i!=0&&charList.size()==0){
//                i++;
//            }
//            else if(chars[i]==' '&&i!=0&&charList.size()!=0&&charList.get(charList.size()-1)!=' '){
//                charList.add(chars[i]);
//                i++;
//            }
//
//        }

//        System.out.println(charList);
        char[] resultChar = new char[charList.size()];
        for(int i=0;i<charList.size();i++){
            resultChar[i]=charList.get(i);
        }
        String result=new String(resultChar);
        return result;
        }
}
