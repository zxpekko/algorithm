package dynamicprogramming;

import java.util.Arrays;

/**
 * @Author:zxp
 * @Description:给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
 *
 * 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。
 *
 * 你可以认为每种硬币的数量是无限的。
 *
 *
 *
 * 示例 1：
 *
 * 输入：coins = [1, 2, 5], amount = 11
 * 输出：3
 * 解释：11 = 5 + 5 + 1
 * 示例 2：
 *
 * 输入：coins = [2], amount = 3
 * 输出：-1
 * 示例 3：
 *
 * 输入：coins = [1], amount = 0
 * 输出：0
 *
 *
 * 提示：
 *
 * 1 <= coins.length <= 12
 * 1 <= coins[i] <= 231 - 1
 * 0 <= amount <= 104
 * @Date:19:33 2023/12/4
 */
public class CoinChange {
    public static void main(String[] args) {
        CoinChange coinChange = new CoinChange();
        System.out.println(coinChange.coinChange(new int[]{2}, 3));
    }
    public int coinChange(int[] coins, int amount){
        int[] dp = new int[amount + 1];//dp[j]表示凑成j容量需要的最少的硬币数。
        int n=coins.length;
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0]=0;
        if(amount==0)
            return 0;
        for(int i=0;i<n;i++){
            for(int j=coins[i];j<=amount;j++){
                if(dp[j-coins[i]]!=Integer.MAX_VALUE){
                    dp[j]=Math.min(dp[j],dp[j-coins[i]]+1);
                }
            }
        }
        if(dp[amount]==Integer.MAX_VALUE)
            return -1;
        return dp[amount];
    }
}
