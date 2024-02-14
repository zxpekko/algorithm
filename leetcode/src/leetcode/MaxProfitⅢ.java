package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author:zxp
 * @Description:  P123
 *
 * 给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
 *
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 两笔 交易。
 *
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 *
 *
 *
 * 示例 1:
 *
 * 输入：prices = [3,3,5,0,0,3,1,4]
 * 输出：6
 * 解释：在第 4 天（股票价格 = 0）的时候买入，在第 6 天（股票价格 = 3）的时候卖出，这笔交易所能获得利润 = 3-0 = 3 。
 *      随后，在第 7 天（股票价格 = 1）的时候买入，在第 8 天 （股票价格 = 4）的时候卖出，这笔交易所能获得利润 = 4-1 = 3 。
 * 示例 2：
 *
 * 输入：prices = [1,2,3,4,5]
 * 输出：4
 * 解释：在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
 *      注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。
 *      因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
 * 示例 3：
 *
 * 输入：prices = [7,6,4,3,1]
 * 输出：0
 * 解释：在这个情况下, 没有交易完成, 所以最大利润为 0。
 * 示例 4：
 *
 * 输入：prices = [1]
 * 输出：0
 * @Date:13:18 2023/8/24
 */
public class MaxProfitⅢ {
    public static void main(String[] args) {
        int[] prices={1,2,4,2,5,7,2,4,9,0};
        MaxProfitⅢ maxProfitⅢ = new MaxProfitⅢ();
        System.out.println(maxProfitⅢ.maxProfitⅡ(prices));

    }
    public int maxProfit(int[] prices){//错误算法
        if(prices.length==0)
            return 0;
        int totalProfit=0;
        List<Integer> totalProfits=new ArrayList<>();
        int maxProfit=0;
        int minPrice=Integer.MAX_VALUE;
//        int flag=0;
        for(int i=0;i<prices.length;i++){
            if(prices[i]<minPrice&&maxProfit>0){
                minPrice=prices[i];
//                flag=1;
                totalProfit+=maxProfit;
                totalProfits.add(maxProfit);
                maxProfit=0;
            }
            else if(prices[i]<minPrice)
                minPrice=prices[i];

            else if(prices[i]-minPrice>=maxProfit&&i==prices.length-1){
                maxProfit=prices[i]-minPrice;
                totalProfit+=maxProfit;
                totalProfits.add(maxProfit);
            }

            else if(prices[i]-minPrice>maxProfit)
                maxProfit=prices[i]-minPrice;
            else if(prices[i]-minPrice<maxProfit){
//                flag=1;
                totalProfit+=maxProfit;
                totalProfits.add(maxProfit);
                maxProfit=0;
                minPrice=prices[i];
            }
        }
        if(totalProfits.size()==0)
            return 0;
//        if(flag==0)
//            return maxProfit;
        int max=totalProfits.get(0);
        int maxIndex=0;
        for(int i=0;i<totalProfits.size();i++){
            if(totalProfits.get(i)>max){
                max=totalProfits.get(i);
                maxIndex=i;
            }
        }
//        System.out.println(totalProfits);
        totalProfits.remove(maxIndex);
        if(totalProfits.size()>=1){
            int secondMax=Integer.MIN_VALUE;
            for(int i:totalProfits){
                if(i>secondMax)
                    secondMax=i;
            }
            return max+secondMax;
        }
        return max;
//        System.out.println(totalProfits);
    }
    public int maxProfitⅡ(int[] prices){
        int n=prices.length;
        int buy1=-prices[0],buy2=-prices[0];
        int sell1=0,sell2=0;
        for(int i=1;i<n;i++){
            buy1=Math.max(buy1,-prices[i]);
            sell1=Math.max(sell1,buy1+prices[i]);
            buy2=Math.max(buy2,sell1-prices[i]);
            sell2=Math.max(sell2,buy2+prices[i]);
        }
        return sell2;
    }
}
