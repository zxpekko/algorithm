package leetcode;

import java.util.EventListener;

/**
 * @Author:zxp
 * @Description: 50
 *
 * 实现 pow(x, n) ，即计算 x 的整数 n 次幂函数（即，xn ）。
 *
 *
 *
 * 示例 1：
 *
 * 输入：x = 2.00000, n = 10
 * 输出：1024.00000
 * 示例 2：
 *
 * 输入：x = 2.10000, n = 3
 * 输出：9.26100
 * 示例 3：
 *
 * 输入：x = 2.00000, n = -2
 * 输出：0.25000
 * 解释：2-2 = 1/22 = 1/4 = 0.25
 * @Date:11:58 2023/9/6
 */
public class MyPow {
    public static void main(String[] args) {
        MyPow myPow = new MyPow();
        System.out.println(myPow.myPow(2, -2));
    }
//    public double myPow(double x, int n){
//        if(n==0||x==1)
//            return 1;
//        else if(n>0){
//            double result=1;
//            for(int i=0;i<n;i++)
//                result*=x;
//            return result;
//        }
//        else {
//            double result=1;
//            if(n!=Integer.MIN_VALUE){
//                for(int i=0;i<-n;i++)
//                    result*=x;
//            }
//            else {
//                for(int i=0;i<~n;i++)
//                    result*=x;
//                result*=x;
//            }
//
////            System.out.println(-1*n);
//            return 1/result;
//        }
////        return 0;
//    }
      public double myPow(double x, int n){

        if(n==0)
            return 1;
        if(x==1)
            return x;
        if(x==-1){
            if(n%2==0)
                return 1;
            else
                return -1;
        }
        if(n>0){
            if(n%2==0)
                return myPow(x*x,n/2);
            else
                return myPow(x*x,n/2)*x;
        }
        else if(n<0&&n!=Integer.MIN_VALUE){
            n=-n;
            if(n%2==0)
                return 1/myPow(x*x,n/2);
            else
                return 1/(myPow(x*x,n/2)*x);
        }
        else {
            n=~n;
            if(n%2==0)
                return 1/myPow(x*x,n/2);
            else
                return 1/(myPow(x*x,n/2)*x);
        }

//        return 0;
      }
}
