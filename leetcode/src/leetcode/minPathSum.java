package leetcode;

/**
 * @Author:zxp
 * @Description:
 * @Date:10:43 2023/8/12
 */
public class minPathSum {
    public static void main(String[] args) {
        int[][] grid={{1,2,3},{4,5,6}};
        minPathSum minPathSum = new minPathSum();
        int i = minPathSum.minPathSum(grid);
        System.out.println(i);
    }
    public int minPathSum(int[][] grid){
        int[][] dp=new int[grid.length][grid[0].length];
        for(int i=0;i< dp.length;i++){
            for(int j=0;j<dp[i].length;j++){
                if(i==0&&j==0)
                    dp[i][j]=grid[i][j];
                else if(i==0){
                    dp[i][j]=dp[i][j-1]+grid[i][j];
                }
                else if(j==0){
                    dp[i][j]=dp[i-1][j]+grid[i][j];
                }
                else {
                    dp[i][j]=Math.min(dp[i-1][j]+grid[i][j],dp[i][j-1]+grid[i][j]);
                }
            }
        }
        return dp[dp.length-1][dp[0].length-1];
    }
}
