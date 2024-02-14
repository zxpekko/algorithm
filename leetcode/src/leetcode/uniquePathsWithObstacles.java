package leetcode;

/**
 * @Author:zxp
 * @Description:
 * @Date:11:25 2023/8/12
 */
public class uniquePathsWithObstacles {
    public static void main(String[] args) {
        int[][] grid={{0,0,0},{0,1,0},{0,0,0}};
        uniquePathsWithObstacles uniquePathsWithObstacles = new uniquePathsWithObstacles();
        int i = uniquePathsWithObstacles.uniquePathsWithObstacles(grid);
        System.out.println(i);
    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid){
        int[][] dp=new int[obstacleGrid.length][obstacleGrid[0].length];
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[i].length;j++){
                if(i==0&&j==0&&obstacleGrid[i][j]==0)
                    dp[i][j]=1;
                else if (i==0&&j==0&&obstacleGrid[i][j]!=0)
                    dp[i][j]=0;
                else if(i==0){
                    if(obstacleGrid[i][j]==0&&dp[i][j-1]!=0)
                        dp[i][j]=1;
                    else
                        dp[i][j]=0;
                }
                else if(j==0){
                    if(obstacleGrid[i][j]==0&&dp[i-1][j]!=0)
                        dp[i][j]=1;
                    else
                        dp[i][j]=0;
                }
                else {
                    if(obstacleGrid[i][j]==0){
                        if(dp[i-1][j]==0&&dp[i][j-1]!=0)
                            dp[i][j]=dp[i][j-1];
                        else if (dp[i-1][j]!=0&&dp[i][j-1]==0)
                            dp[i][j]=dp[i-1][j];
                        else if(dp[i-1][j]==0&&dp[i][j-1]==0)
                            dp[i][j]=0;
                        else
                            dp[i][j]=dp[i-1][j]+dp[i][j-1];
                    }
                    else
                        dp[i][j]=0;
                }
            }
        }
        return dp[dp.length-1][dp[0].length-1];
    }
}
