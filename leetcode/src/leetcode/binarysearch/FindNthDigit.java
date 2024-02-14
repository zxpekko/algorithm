package leetcode.binarysearch;

/**
 * @Author:zxp
 * @Description:给你一个整数 n ，请你在无限的整数序列 [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ...] 中找出并返回第 n 位上的数字。
 *
 *
 *
 * 示例 1：
 *
 * 输入：n = 3
 * 输出：3
 * 示例 2：
 *
 * 输入：n = 11
 * 输出：0
 * 解释：第 11 位数字在序列 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ... 里是 0 ，它是 10 的一部分。
 *
 *
 * 提示：
 *
 * 1 <= n <= 2^31 - 1
 * @Date:20:05 2023/10/7
 */
public class FindNthDigit {
    public static void main(String[] args) {
        FindNthDigit findNthDigit = new FindNthDigit();
        System.out.println(findNthDigit.findNthDigit(1000000000));
    }
//    public int findNthDigit(int n){
//        int base=9,k=1;
//        int sum=0;
//        while (sum<n){
//            sum+=(base*k);
//            base*=10;
//            k++;
//        }
//        int     current=k-1;
//        int currentBase=base/10;
//        k-=1;
//        base/=10;
//        while (k-1>0){
//            n-=(k-1)*(base/=10);
//            k-=1;
//        }
//        int div=n/current;
//        int mod=n%current;
//        if(mod==0){
//            int digit=(int)Math.pow(10,current-1)+div-1;
//            return digit%10;
//        }
//        else {
//            int digit=(int)Math.pow(10,current-1)+div;
//            String strDigit=String.valueOf(digit);
//            char c=strDigit.charAt(mod-1);
////            System.out.println(mod-1);
////            System.out.println(digit);
////            System.out.println(current);
////            System.out.println(div);
//            String s = new String(new char[]{c});
//            int last=Integer.parseInt(s);
//            return last;
//        }
////        return 0;
//    }
    public int findNthDigit(int n){
        int base=9,k=1;
        while (n>(long)base*k){
            n-=base*k;
            k++;
            base*=10;
        }
        int index=k-1;
        int start=(int)Math.pow(10,index);
        int num=start+(n-1)/k;
        int digitNum=(n-1)%k;
        int digit=num/(int)Math.pow(10,k-1-digitNum)%10;
        return digit;
    }
}
