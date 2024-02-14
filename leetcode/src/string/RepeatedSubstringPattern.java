package string;

/**
 * @Author:zxp
 * @Description:给定一个非空的字符串 s ，检查是否可以通过由它的一个子串重复多次构成。
 *
 *
 *
 * 示例 1:
 *
 * 输入: s = "abab"
 * 输出: true
 * 解释: 可由子串 "ab" 重复两次构成。
 * 示例 2:
 *
 * 输入: s = "aba"
 * 输出: false
 * 示例 3:
 *
 * 输入: s = "abcabcabcabc"
 * 输出: true
 * 解释: 可由子串 "abc" 重复四次构成。 (或子串 "abcabc" 重复两次构成。)
 *
 *
 * 提示：
 *
 * 1 <= s.length <= 104
 * s 由小写英文字母组成
 * @Date:18:07 2024/1/27
 */
public class RepeatedSubstringPattern {
    public static void main(String[] args) {
        RepeatedSubstringPattern repeatedSubstringPattern = new RepeatedSubstringPattern();
        System.out.println(repeatedSubstringPattern.repeatedSubstringPattern("abac"));
        RepeatedSubstringPatternⅡ repeatedSubstringPatternⅡ = new RepeatedSubstringPatternⅡ();
        System.out.println(repeatedSubstringPatternⅡ.repeatedSubstringPattern("abac"));
//        System.out.println(repeatedSubstringPattern.repeatedSubstringPatternⅡ("abac"));
    }
    public boolean repeatedSubstringPattern(String s){
        for(int i=0;i<s.length()/2;i++){
            String substring = s.substring(0, i + 1);
            String mainString=s.substring(i+1,s.length());
            if(Match(mainString,substring))
                return true;
        }
        return false;
    }
    public boolean Match(String s,String subString){
        if(s.length()%subString.length()!=0)
            return false;
        int index=0;
        while (index<s.length())
        {
            for(int i=0;i<subString.length();i++){
                if(subString.charAt(i)==s.charAt(index)){
                    index++;
                }
                else return false;
            }
        }
        return true;
    }
}
class RepeatedSubstringPatternⅡ{
    public boolean repeatedSubstringPattern(String s){
        //准备获取next数组
        int[] next= new int[s.length()];
        int j=0;//指前缀的末尾
        next[0]=0;
        for(int i=1;i<s.length();i++){
            while (j>0&&s.charAt(i)!=s.charAt(j))
                j=next[j-1];
            if(s.charAt(i)==s.charAt(j))
                j++;
            next[i]=j;
        }
        if(next[s.length()-1]>0&&s.length()%(s.length()-next[s.length()-1])==0)
            return true;
        return false;
    }
}
