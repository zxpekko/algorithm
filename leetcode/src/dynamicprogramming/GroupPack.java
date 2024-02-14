package dynamicprogramming;

/**
 * @Author:zxp
 * @Description:
 * @Date:11:04 2023/6/16
 */
public class GroupPack {
    public static void main(String[] args) {
        int[][] v = {{1, 2}, {3}, {4}};
        int[][] w={{2,4},{4},{5}};
        int[] groupNum={2,1,1};
        int i = GroupPack.DynamicProgramming(3, 5, v, w, groupNum);
        System.out.println(i);
    }
    public static int DynamicProgramming(int groupNumber,int totalVolumn,int[][] v,int[][] w,int[] groupNum){
//        int totalNumber=0;
//        for(int m=0;m<groupNum.length;m++){
//            totalNumber+=groupNum[m];
//        }
        long start=System.currentTimeMillis();
        int[][] dp = new int[groupNumber + 1][totalVolumn + 1];
        for(int i=1;i<=groupNumber;i++){
            for(int j=1;j<=totalVolumn;j++){
                dp[i][j]=dp[i-1][j];
                for(int k=0;k<groupNum[i-1];k++){
                    if(v[i-1][k]<=j)
                        dp[i][j]=Math.max(dp[i][j],dp[i-1][j-v[i-1][k]]+w[i-1][k]);
                }
            }
        }
        long spend=System.currentTimeMillis()-start;
        System.out.println("spend time:"+spend);

        return dp[groupNumber][totalVolumn];
    }
}
