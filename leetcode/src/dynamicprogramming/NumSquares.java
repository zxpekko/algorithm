package dynamicprogramming;

import java.util.Arrays;

/**
 * @Author:zxp
 * @Description:给你一个整数 n ，返回 和为 n 的完全平方数的最少数量 。
 *
 * 完全平方数 是一个整数，其值等于另一个整数的平方；换句话说，其值等于一个整数自乘的积。例如，1、4、9 和 16 都是完全平方数，而 3 和 11 不是。
 *
 *
 *
 * 示例 1：
 *
 * 输入：n = 12
 * 输出：3
 * 解释：12 = 4 + 4 + 4
 * 示例 2：
 *
 * 输入：n = 13
 * 输出：2
 * 解释：13 = 4 + 9
 *
 * 提示：
 *
 * 1 <= n <= 104
 * @Date:14:39 2023/10/13
 */
public class NumSquares {
    public static void main(String[] args) {
        NumSquares numSquares = new NumSquares();
        System.out.println(numSquares.numSquaresⅡ(20));
    }
    public int numSquares(int n){
        int[] dp = new int[n + 1];
        for(int i=1;i<=n;i++){
            int minNums=Integer.MAX_VALUE;
            for(int j=1;j*j<=i;j++){
                minNums=Math.min(minNums,dp[i-j*j]);
            }
            dp[i]=minNums+1;
        }
        return dp[n];
    }

    public int numSquaresⅡ(int n){
        int[] dp = new int[n + 1];//dp[j]表示平方数加到j的最少的数的个数

        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0]=0;
        for(int i=1;i<=Math.sqrt(n);i++){
            for(int j=i*i;j<=n;j++){
                dp[j]=Math.min(dp[j],dp[j-i*i]+1);
            }
        }
        return dp[n];
    }
}
