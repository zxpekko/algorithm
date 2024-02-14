package dynamicprogramming;

/**
 * @Author:zxp
 * @Description:给定一个整数数组prices，其中第 prices[i] 表示第 i 天的股票价格 。​
 * <p>
 * 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
 * <p>
 * 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: prices = [1,2,3,0,2]
 * 输出: 3
 * 解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出]
 * 示例 2:
 * <p>
 * 输入: prices = [1]
 * 输出: 0
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= prices.length <= 5000
 * 0 <= prices[i] <= 1000
 * @Date:9:51 2023/12/11
 */
public class MaxProfitⅤ {
    public static void main(String[] args) {
        MaxProfitⅤ maxProfitⅤ = new MaxProfitⅤ();
        System.out.println(maxProfitⅤ.maxProfit(new int[]{1, 2, 3, 0, 2}));
    }

    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][4];//dp[i][0]表示持有这支股票，dp[i][1]表示保持卖出这支股票，dp[i][2]表示卖出这支股票当天的动作，dp[i][3]表示冷冻期
        dp[0][0] = -prices[0];
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(Math.max(dp[i - 1][0], dp[i - 1][1] - prices[i]), dp[i - 1][3] - prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][3]);
            dp[i][2] = dp[i - 1][0] + prices[i];
            dp[i][3] = dp[i - 1][2];
        }

        return Math.max(Math.max(dp[n - 1][0], dp[n - 1][1]), Math.max(dp[n - 1][2], dp[n - 1][3]));
    }
}
