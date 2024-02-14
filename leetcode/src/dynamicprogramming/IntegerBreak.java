package dynamicprogramming;

import leetcode.InsertInterval;

/**
 * @Author:zxp
 * @Description:给定一个正整数 n ，将其拆分为 k 个 正整数 的和（ k >= 2 ），并使这些整数的乘积最大化。
 *
 * 返回 你可以获得的最大乘积 。
 *
 *
 *
 * 示例 1:
 *
 * 输入: n = 2
 * 输出: 1
 * 解释: 2 = 1 + 1, 1 × 1 = 1。
 * 示例 2:
 *
 * 输入: n = 10
 * 输出: 36
 * 解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36。
 *
 *
 * 提示:
 *
 * 2 <= n <= 58
 * @Date:16:44 2023/11/24
 */
public class IntegerBreak {
    public static void main(String[] args) {
        IntegerBreak integerBreak = new IntegerBreak();
        System.out.println(integerBreak.integerBreak(10));
    }
    public int integerBreak(int n){//dp[i]表示将i分解成若干个数的成乘积最大值。dp[i]=max(j*(i-j),j*dp[i-j]),后者是分解成三个及三个以上的数。
        int[] dp = new int[n + 1];
        dp[0]=0;
        dp[1]=0;
        dp[2]=1;
        for(int i=3;i<=n;i++){
            for(int j=1;j<i;j++){
                dp[i]=getMax(dp[i],j*(i-j),j*dp[i-j]);//第一个传入的参数是上次迭代的最大值（也需要拿来做一个比较），第二个是分两个数的情况，
                // 第三个是分三个及三个以上的情况，仔细思考为什么是三个以上，因为dp[i-j]的情况在迭代他自己的时候也考虑过这个情况，只要进入dp[i-j]次数就会至少是3，
                // 进去再进去dp[i-j],又可以分裂，具体是什么是需要在计算的时候确定的。
            }
        }

        return dp[n];
    }
    public int getMax(int a,int b,int c){

        return Math.max(Math.max(a,b),c);
    }
}
