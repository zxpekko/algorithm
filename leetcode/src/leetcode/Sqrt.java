package leetcode;

/**
 * @Author:zxp
 * @Description:  69
 * 给你一个非负整数 x ，计算并返回 x 的 算术平方根 。
 *
 * 由于返回类型是整数，结果只保留 整数部分 ，小数部分将被 舍去 。
 *
 * 注意：不允许使用任何内置指数函数和算符，例如 pow(x, 0.5) 或者 x ** 0.5 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：x = 4
 * 输出：2
 * 示例 2：
 *
 * 输入：x = 8
 * 输出：2
 * 解释：8 的算术平方根是 2.82842..., 由于返回类型是整数，小数部分将被舍去。
 * @Date:20:49 2023/9/5
 */
public class Sqrt {
    public static void main(String[] args) {
        Sqrt sqrt = new Sqrt();
        System.out.println(sqrt.mySqrt(8));
//        Math.pow()
    }
//    public int mySqrt(int x){
//        int flag=0;
//        int i;
//        for(i=1;i<=x;i++){
//            if(i*i==x)
//                return i;
//            if(i*i>x){
////                flag=1;
//                break;
//            }
//        }
//
//        return i-1;
//
//    }
     public int mySqrt(int x){
        int left=1,right=x;
        int result=0;
        while (left<=right){
            int mid=(left+right)/2;
            if(mid*mid<=x){
                result=mid;
                left=mid+1;
            }
//                return mid;
//            else if(mid*mid<x)
//                left=mid+1;
            else
                right=mid-1;
        }
        return result;
     }

}
