package leetcode;

/**
 * @Author:zxp
 * @Description:给你一个整数数组 prices ，其中 prices[i] 表示某支股票第 i 天的价格。
 *
 * 在每一天，你可以决定是否购买和/或出售股票。你在任何时候 最多 只能持有 一股 股票。你也可以先购买，然后在 同一天 出售。
 *
 * 返回 你能获得的 最大 利润 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：prices = [7,1,5,3,6,4]
 * 输出：7
 * 解释：在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5 - 1 = 4 。
 *      随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6 - 3 = 3 。
 *      总利润为 4 + 3 = 7 。
 * 示例 2：
 *
 * 输入：prices = [1,2,3,4,5]
 * 输出：4
 * 解释：在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5 - 1 = 4 。
 *      总利润为 4 。
 * 示例 3：
 *
 * 输入：prices = [7,6,4,3,1]
 * 输出：0
 * 解释：在这种情况下, 交易无法获得正利润，所以不参与交易可以获得最大利润，最大利润为 0 。
 * @Date:11:45 2023/8/24
 */
public class MaxProfitⅡ {
    public static void main(String[] args) {
        int[] prices={1,9,6,9,1,7,1,1,5,9,9,9};
        MaxProfitⅡ maxProfitⅡ = new MaxProfitⅡ();
        System.out.println(maxProfitⅡ.maxProfit(prices));

    }
    public int maxProfit(int[] prices){
        if(prices.length==0)
            return 0;
        int totalProfit=0;
        int maxProfit=0;
        int minPrice=Integer.MAX_VALUE;
        int flag=0;
        for(int i=0;i<prices.length;i++){
            if(prices[i]<minPrice&&maxProfit>0){
                minPrice=prices[i];
                flag=1;
                totalProfit+=maxProfit;
                maxProfit=0;
            }
            else if(prices[i]<minPrice)
                minPrice=prices[i];

            else if(prices[i]-minPrice>=maxProfit&&i==prices.length-1){
                maxProfit=prices[i]-minPrice;
                totalProfit+=maxProfit;
            }

            else if(prices[i]-minPrice>maxProfit)
                maxProfit=prices[i]-minPrice;
            else if(prices[i]-minPrice<maxProfit){
                flag=1;
                totalProfit+=maxProfit;
                maxProfit=0;
                minPrice=prices[i];
            }
        }
        if(flag==0)
            return maxProfit;
        return totalProfit;
    }
}
