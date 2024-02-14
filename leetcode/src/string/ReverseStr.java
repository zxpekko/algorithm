package string;

/**
 * @Author:zxp
 * @Description:给定一个字符串 s 和一个整数 k，从字符串开头算起，每计数至 2k 个字符，就反转这 2k 字符中的前 k 个字符。
 *
 * 如果剩余字符少于 k 个，则将剩余字符全部反转。
 * 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。
 *
 *
 * 示例 1：
 *
 * 输入：s = "abcdefg", k = 2
 * 输出："bacdfeg"
 * 示例 2：
 *
 * 输入：s = "abcd", k = 2
 * 输出："bacd"
 *
 *
 * 提示：
 *
 * 1 <= s.length <= 104
 * s 仅由小写英文组成
 * 1 <= k <= 104
 * @Date:16:57 2024/1/26
 */
public class ReverseStr {
    public static void main(String[] args) {
        ReverseStr reverseStr = new ReverseStr();
        System.out.println(reverseStr.reverseStr("abcdefdsf", 2));
    }
    public String reverseStr(String s, int k){
        int count=0,start=0,end=0;
        char[] chars = s.toCharArray();
        for(int i=0;i<s.length();i++,count++){
            if(count==k){
                 reverseSub(chars,start,i-1);
                 start=i;
                 start+=k;
                 count=0;
                 i=start;
            }
            if(i==s.length()-1&&count<k){
                reverseSub(chars,start,i);
            }
        }
        return new String(chars);
    }
    public void reverseSub(char[] chars,int start,int end){
//        char[] chars = s.toCharArray();
        for(int i=start,j=end;i<j;i++,j--){
            char temp=chars[i];
            chars[i]=chars[j];
            chars[j]=temp;
        }
//        return chars.toString();
    }
}
