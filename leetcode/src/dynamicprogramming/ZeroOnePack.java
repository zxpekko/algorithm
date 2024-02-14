package dynamicprogramming;

/**
 * @Author:zxp
 * @Description:
 * @Date:13:46 2023/11/26
 */
public class ZeroOnePack {
    public int dynammic(int[] weights,int[] values,int maxWeight){//二维数组动态规划求解该问题。
        int n=weights.length;
        int[][] dp = new int[n][maxWeight+1];//dp[i][j]的值代表前i个物品放到容量为j的背包中的最大价值
        for(int i=0;i<n;i++){
            dp[i][0]=0;
        }
        for(int j=0;j<=maxWeight;j++){
            if(weights[0]<=j)
                dp[0][j]=values[0];
        }
        for(int i=1;i<n;i++){
            for(int j=1;j<=maxWeight;j++){
                if(weights[i]<=j){
                    dp[i][j]=Math.max(dp[i-1][j],dp[i-1][j-weights[i]]+values[i]);
                }
                else
                    dp[i][j]=dp[i-1][j];
            }
        }
        return dp[n-1][maxWeight];
    }
    public int dynammicⅡ(int[] weights,int[] values,int maxWeight){
        int[] dp = new int[maxWeight + 1];//dp[j]表示i个物品放在容量为j的背包中的最大价值。
        dp[0]=0;
        for(int j=1;j<=maxWeight;j++){
            if(weights[0]<=j)
                dp[j]=values[0];
        }//这边初始化成全0也可以，注意下面的代码其实走过一遍这个流程了。
        for(int i=0;i< values.length;i++)
        {
            for(int j=maxWeight;j>=weights[i];j--){
                dp[j]=Math.max(dp[j],dp[j-weights[i]]+values[i]);//注意此处必须要倒叙遍历
            }
        }
        return dp[maxWeight];
    }
}
