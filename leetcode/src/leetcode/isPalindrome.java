package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author:zxp
 * @Description:给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
 *
 * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 *
 * 例如，121 是回文，而 123 不是。
 *
 *
 * 示例 1：
 *
 * 输入：x = 121
 * 输出：true
 * 示例 2：
 *
 * 输入：x = -121
 * 输出：false
 * 解释：从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * 示例 3：
 *
 * 输入：x = 10
 * 输出：false
 * 解释：从右向左读, 为 01 。因此它不是一个回文数。
 * @Date:17:59 2023/9/1
 */
public class isPalindrome {
    public static void main(String[] args) {
        isPalindrome isPalindrome = new isPalindrome();
        System.out.println(isPalindrome.isPalindromeⅡ(12321));
    }
    public boolean isPalindrome(int x){
        if(x<0)
            return false;
        if(x==0)
            return true;
        List<Integer> list=new ArrayList<>();
        while (x>0){
            int lastNum=x%10;
            x/=10;
            list.add(lastNum);
        }
        int flag=0;
        for(int i=0,j=list.size()-1;i< j;i++,j--){
            if(list.get(i)!=list.get(j)){
                flag=1;
                break;
            }
        }
        if(flag==1)
            return false;
        return true;
    }
    public boolean isPalindromeⅡ(int x){
        String s = String.valueOf(x);
        int flag=0;
        for(int i=0,j=s.length()-1;i<j;i++,j--){
            if(s.charAt(i)!=s.charAt(j)){
                flag=1;
                break;
            }
        }
        if(flag==1)
            return false;
        return true;
    }
}
