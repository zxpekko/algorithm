package dynamicprogramming;

/**
 * @Author:zxp
 * @Description:完全背包问题
 * @Date:15:05 2023/6/14
 */
public class CompletePack {
    public static void main(String[] args) {
        int[] v = {1, 2, 3, 4};
        int[] w={2,4,4,5};
        int i=CompletePack.DynamicProgramming(v,w,4,5);
        System.out.println(i);
    }
    public static int DynamicProgramming(int[] v,int[] w,int totalNumber,int totalVolumn){
        int[][] dp = new int[totalNumber + 1][totalVolumn + 1];
        for(int i=1;i<=totalNumber;i++){
            for(int j=1;j<=totalVolumn;j++){
                if(v[i-1]>j)
                    dp[i][j]=dp[i-1][j];
                else{
//                    dp[i][j]=dp[i-1][j];
//                    for(int k=1;k*v[i-1]<=j;k++){
//                        dp[i][j]=Math.max(dp[i][j],dp[i-1][j-k*v[i-1]]+k*w[i-1]);
//                    }
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-v[i-1]]+w[i-1]);
                }
            }
        }


        return dp[totalNumber][totalVolumn];
    }
}
