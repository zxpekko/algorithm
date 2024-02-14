package leetcode;

import org.junit.Test;

import javax.swing.plaf.PanelUI;

/**
 * @Author:zxp
 * @Description:如果在将所有大写字符转换为小写字符、并移除所有非字母数字字符之后，短语正着读和反着读都一样。则可以认为该短语是一个 回文串 。
 *
 * 字母和数字都属于字母数字字符。
 *
 * 给你一个字符串 s，如果它是 回文串 ，返回 true ；否则，返回 false 。
 *
 *
 *
 * 示例 1：
 *
 * 输入: s = "A man, a plan, a canal: Panama"
 * 输出：true
 * 解释："amanaplanacanalpanama" 是回文串。
 * 示例 2：
 *
 * 输入：s = "race a car"
 * 输出：false
 * 解释："raceacar" 不是回文串。
 * 示例 3：
 *
 * 输入：s = " "
 * 输出：true
 * 解释：在移除非字母数字字符之后，s 是一个空字符串 "" 。
 * 由于空字符串正着反着读都一样，所以是回文串。
 * @Date:12:44 2023/8/25
 */
public class JudgePalindrome {
    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        JudgePalindrome judgePalindrome = new JudgePalindrome();
        boolean palindrome = judgePalindrome.isPalindrome(s);
        System.out.println(palindrome);
    }
    public boolean isPalindrome(String s){
        StringBuilder stringBuilder = new StringBuilder();
        s=s.toLowerCase();
        for(int i=0;i<s.length();i++){
            if(Character.isLetterOrDigit(s.charAt(i)))
                stringBuilder.append(s.charAt(i));
        }
        int flag=0;
        for(int i=0,j=stringBuilder.length()-1;i<j;i++,j--){
            if(stringBuilder.charAt(i)!=stringBuilder.charAt(j)){
                flag=1;
                break;
            }
        }
        if(flag==1)
            return false;
        return true;
    }
    @Test
    public void test(){
        String s="123asAD";
        String s1 = s.toLowerCase();
        System.out.println(s1);
    }
}
