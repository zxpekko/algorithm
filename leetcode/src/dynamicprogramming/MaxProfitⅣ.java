package dynamicprogramming;

/**
 * @Author:zxp
 * @Description:给你一个整数数组 prices 和一个整数 k ，其中 prices[i] 是某支给定的股票在第 i 天的价格。
 *
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 k 笔交易。也就是说，你最多可以买 k 次，卖 k 次。
 *
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 *
 *
 *
 * 示例 1：
 *
 * 输入：k = 2, prices = [2,4,1]
 * 输出：2
 * 解释：在第 1 天 (股票价格 = 2) 的时候买入，在第 2 天 (股票价格 = 4) 的时候卖出，这笔交易所能获得利润 = 4-2 = 2 。
 * 示例 2：
 *
 * 输入：k = 2, prices = [3,2,6,5,0,3]
 * 输出：7
 * 解释：在第 2 天 (股票价格 = 2) 的时候买入，在第 3 天 (股票价格 = 6) 的时候卖出, 这笔交易所能获得利润 = 6-2 = 4 。
 *      随后，在第 5 天 (股票价格 = 0) 的时候买入，在第 6 天 (股票价格 = 3) 的时候卖出, 这笔交易所能获得利润 = 3-0 = 3 。
 *
 * @Date:12:18 2023/12/10
 */
public class MaxProfitⅣ {
    public static void main(String[] args) {
        MaxProfitⅣ maxProfitⅣ = new MaxProfitⅣ();
        System.out.println(maxProfitⅣ.maxProfit(2, new int[]{3,2,6,5,0,3}));
    }
    public int maxProfit(int k, int[] prices){
        int n=prices.length;
        int[][] dp = new int[n][2 * k + 1];
        dp[0][0]=0;
        for(int m=0;m<=2*k;m++){
            if(m%2==0)
                dp[0][m]=0;
            else
                dp[0][m]=-prices[0];
        }
        for(int i=1;i<n;i++){
            for(int j=0;j<=2*k;j++){
                if(j==0)
                    dp[i][j]=dp[i-1][j];
                else if (j%2==1) {
                    dp[i][j]=Math.max(dp[i-1][j],dp[i-1][j-1]-prices[i]);
                }
                else {
                    dp[i][j]=Math.max(dp[i-1][j],dp[i-1][j-1]+prices[i]);
                }
            }
        }
        return dp[n-1][2*k];
    }
}
