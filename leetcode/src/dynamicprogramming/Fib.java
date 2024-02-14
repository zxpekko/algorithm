package dynamicprogramming;

import java.util.Arrays;

/**
 * @Author:zxp
 * @Description:斐波那契数 （通常用 F(n) 表示）形成的序列称为 斐波那契数列 。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是：
 *
 * F(0) = 0，F(1) = 1
 * F(n) = F(n - 1) + F(n - 2)，其中 n > 1
 * 给定 n ，请计算 F(n) 。
 *
 * 答案需要取模 1e9+7(1000000007) ，如计算初始结果为：1000000008，请返回 1。
 *
 *
 *
 * 示例 1：
 *
 * 输入：n = 2
 * 输出：1
 * 解释：F(2) = F(1) + F(0) = 1 + 0 = 1
 * 示例 2：
 *
 * 输入：n = 3
 * 输出：2
 * 解释：F(3) = F(2) + F(1) = 1 + 1 = 2
 * 示例 3：
 *
 * 输入：n = 4
 * 输出：3
 * 解释：F(4) = F(3) + F(2) = 2 + 1 = 3
 * @Date:13:01 2023/11/24
 */
public class Fib {
    public static void main(String[] args) {
        Fib fib = new Fib();
        System.out.println(fib.fib(48));

    }
    public int fib(int n){
        final int MOD=1000000007;
        int[] dp = new int[n+1];
        for(int i=0;i<=n;i++){
            if(i==0)
                dp[i]=0;
            else if(i==1)
                dp[i]=1;
            else
                dp[i]=(dp[i-1]+dp[i-2])%MOD;
        }
//        System.out.println(Arrays.toString(dp));
        return dp[n]%MOD;
    }
    public int fibⅡ(int n){
        final int MOD=1000000007;
        if(n<2){
            return n;
        }
        int p=0,q=0,r=1;
        for(int i=2;i<=n;i++){
            p=q;
            q=r;
            r=(p+q)%MOD;
        }

        return r;
    }
}
