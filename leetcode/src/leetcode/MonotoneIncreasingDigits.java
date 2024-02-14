package leetcode;

/**
 * @Author:zxp
 * @Description:当且仅当每个相邻位数上的数字 x 和 y 满足 x <= y 时，我们称这个整数是单调递增的。
 *
 * 给定一个整数 n ，返回 小于或等于 n 的最大数字，且数字呈 单调递增 。
 *
 *
 *
 * 示例 1:
 *
 * 输入: n = 10
 * 输出: 9
 * 示例 2:
 *
 * 输入: n = 1234
 * 输出: 1234
 * 示例 3:
 *
 * 输入: n = 332
 * 输出: 299
 *
 *
 * 提示:
 *
 * 0 <= n <= 109
 * @Date:14:04 2023/10/27
 */
public class MonotoneIncreasingDigits {
    public static void main(String[] args) {
        MonotoneIncreasingDigits monotoneIncreasingDigits = new MonotoneIncreasingDigits();
        System.out.println(monotoneIncreasingDigits.monotoneIncreasingDigitsⅡ(882930776));
    }
    public int monotoneIncreasingDigits(int n){
        boolean flag=false;
        int num=n;
        for(int i=n;;i--){
            if(isIncrease(i))
                return i;
        }
//        return 0;
    }
    public boolean isIncrease(int num){
        int origin=num;
        if(origin/10==0)
            return true;
        while ((origin/10)>0){
            int right=origin%10;
            origin/=10;
            int left=origin%10;
            if(right<left)
                return false;
        }
        return true;
    }
    public int monotoneIncreasingDigitsⅡ(int n){
        String str=Integer.toString(n);
//        System.out.println(str);
        char[] chars = new char[str.length()];
        for(int i=0;i< chars.length;i++){
            chars[i]=str.charAt(i);
        }
//        System.out.println(chars);
        boolean f=false;
        for(int i=1;i< chars.length;i++){
            if(!f&&chars[i-1]>chars[i]){
                f=true;
                chars[i-1]--;
            }
//            System.out.println(chars);
            if(f)chars[i]='9';
        }
        for(int i= chars.length-1;i>=1;i--){
            if(chars[i-1]>chars[i]){
                chars[i]='9';
                if(chars[i-1]>'0')
                    chars[i-1]--;
            }
        }
//        System.out.println(chars);
        String s = new String(chars);
//        System.out.println(chars);
//        System.out.println(s);
        int result=Integer.parseInt(s);
        return result;
    }
}
