package graphtheory;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author:zxp
 * @Description:给你一个大小为 m x n 的二进制矩阵 grid ，其中 0 表示一个海洋单元格、1 表示一个陆地单元格。
 * <p>
 * 一次 移动 是指从一个陆地单元格走到另一个相邻（上、下、左、右）的陆地单元格或跨过 grid 的边界。
 * <p>
 * 返回网格中 无法 在任意次数的移动中离开网格边界的陆地单元格的数量。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：grid = [[0,0,0,0],[1,0,1,0],[0,1,1,0],[0,0,0,0]]
 * 输出：3
 * 解释：有三个 1 被 0 包围。一个 1 没有被包围，因为它在边界上。
 * 示例 2：
 * <p>
 * <p>
 * 输入：grid = [[0,1,1,0],[0,0,1,0],[0,0,1,0],[0,0,0,0]]
 * 输出：0
 * 解释：所有 1 都在边界上或可以到达边界。
 * <p>
 * <p>
 * 提示：
 * <p>
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 500
 * grid[i][j] 的值为 0 或 1
 * @Date:19:25 2024/2/3
 */
public class NumEnclaves {
    public static void main(String[] args) {
        NumEnclavesⅡ numEnclaves = new NumEnclavesⅡ();
        System.out.println(numEnclaves.numEnclaves(new int[][]{{0,1,1,0}, {0,0,1,0}, {0,0,1,0}, {0, 0, 0, 0}}));
        NumEnclavesⅡ numEnclavesⅡ = new NumEnclavesⅡ();
        System.out.println(numEnclavesⅡ.numEnclaves(new int[][]{{0,0,0,0}, {1,0,1,0}, {0,1,1,0}, {0, 0, 0, 0}}));
        NumEnclavesⅢ numEnclavesⅢ = new NumEnclavesⅢ();
        System.out.println(numEnclavesⅢ.numEnclaves(new int[][]{{0, 0, 0, 0}, {1, 0, 1, 0}, {0, 1, 1, 0}, {0, 0, 0, 0}}));
    }

    public int numEnclaves(int[][] grid) {//此算法也对，但是时间上不能通过测试
        int result = 0;
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    if (!dfs(grid, i, j))
                        result++;
                }
            }
        }
        return result;
    }
    public boolean dfs(int[][] grid, int i, int j) {
        if ((i == 0 || i == grid.length - 1 || j == 0 || j == grid[0].length - 1) && grid[i][j] == 1)
            return true;
        if ((i == 0 || i == grid.length - 1 || j == 0 || j == grid[0].length - 1) && grid[i][j] == 0)
            return false;
        else if (grid[i][j] == 0)
            return false;
        grid[i][j]=0;
        boolean dfs1 = dfs(grid, i + 1, j);
        boolean dfs2 = dfs(grid, i - 1, j);
        boolean dfs3 = dfs(grid, i, j + 1);
        boolean dfs4 = dfs(grid, i, j - 1);
        grid[i][j]=1;
        return dfs1 || dfs2 || dfs3 || dfs4;
    }
}
class NumEnclavesⅡ{
    public int numEnclaves(int[][] grid){//思想是将能到达边界的1都变成海洋0，其余的1都是飞地了。
        int result=0;
        int m=grid.length;
        int n=grid[0].length;
        for(int i=0;i<m;i++){
            if(grid[i][0]==1)
                dfs(grid,i,0);
            if(grid[i][n-1]==1)
                dfs(grid,i,n-1);
        }
        for(int j=0;j<n;j++){
            if(grid[0][j]==1)
                dfs(grid,0,j);
            if(grid[m-1][j]==1)
                dfs(grid,m-1,j);
        }
        for(int i=1;i<m-1;i++){
            for(int j=1;j<n-1;j++){
                if(grid[i][j]==1)
                    result++;
            }
        }
        return result;
    }
    public void dfs(int[][] grid,int i,int j){
        if(i<0||i>=grid.length||j<0||j>=grid[0].length||grid[i][j]==0)
            return;
        grid[i][j]=0;
        dfs(grid,i-1,j);
        dfs(grid,i+1,j);
        dfs(grid,i,j-1);
        dfs(grid,i,j+1);
    }
//    public int numEnclaves(int[][] grid){
//        int result=0;
//        int m=grid.length;
//        int n=grid[0].length;
////        boolean[][] isFly = new boolean[m][n];
//        for(int i=0;i<m;i++){
//            for(int j=0;j<n;j++){
//                if(grid[i][j]==1){
//                    if(!dfs(grid,i,j))
//                        result++;
//                }
//            }
//        }
//        return result;
//    }
//    public boolean dfs(int[][] grid,int i,int j){
////        if((i==0||i==grid.length-1||j==0||j==grid[0].length)&&grid[i][j]==1){
////            isFly[i][j]=false;
////            return;
////        }
////        if((i-1>=0&&i+1<grid.length&&j-1>=0&&j+1<grid[0].length)&&grid[i][j]==1&&(!isFly[i-1][j]||!isFly[i+1][j]||!isFly[i][j-1]||!isFly[i][j+1])){
////            isFly[i][j]=false;
////            return;
////        }
////
////        if(grid[i][j]==0){
////            isFly[i][j]=true;
////            return;
////        }
////        if((i-1>=0&&i+1<grid.length&&j-1>=0&&j+1<grid[0].length)&&grid[i][j]==1&&(isFly[i-1][j]&&isFly[i+1][j]&&isFly[i][j-1]&&isFly[i][j+1])){
////            isFly[i][j]=true;
////            return;
////        }
////
////        dfs(grid,isFly,i-1,j);
////        dfs(grid,isFly,i+1,j);
////        dfs(grid,isFly,i,j-1);
////        dfs(grid,isFly,i,j+1);
//        if((i==0||i==grid.length-1||j==0||j==grid[0].length)&&grid[i][j]==1)
//            return true;
//        if (grid[i][j]==0)
//            return false;
//        if((i-1>=0&&i+1<grid.length&&j-1>=0&&j+1<grid[0].length)&&grid[i][j]==1&&(dfs(grid,i-1,j)||dfs(grid,i+1,j)||dfs(grid,i,j-1)||dfs(grid,i,j+1)))
//            return true;
//        return false;
//    }
}
class NumEnclavesⅢ{
    public int numEnclaves(int[][] grid){
        int result=0;
        int m=grid.length;
        int n=grid[0].length;
        for(int i=0;i<m;i++){
            if(grid[i][0]==1)
                bfs(grid,i,0);
            if(grid[i][n-1]==1)
                bfs(grid,i,n-1);
        }
        for(int j=0;j<n;j++){
            if(grid[0][j]==1)
                bfs(grid,0,j);
            if(grid[m-1][j]==1)
                bfs(grid,m-1,j);
        }
        for(int i=1;i<m-1;i++){
            for(int j=1;j<n-1;j++){
                if(grid[i][j]==1)
                    result++;
            }
        }
        return result;
    }
    public void bfs(int[][] grid,int i,int j){
        Queue<int[]> queue=new LinkedList<>();
        queue.offer(new int[]{i,j});
//        grid[i][j]=0;
        while (!queue.isEmpty()){
            int[] poll = queue.poll();
            int row=poll[0];
            int column=poll[1];
            grid[row][column]=0;
            if(row-1>=0&&grid[row-1][column]==1)
                queue.offer(new int[]{row-1,column});
            if(row+1<grid.length&&grid[row+1][column]==1)
                queue.offer(new int[]{row+1,column});
            if(column-1>=0&&grid[row][column-1]==1)
                queue.offer(new int[]{row,column-1});
            if(column+1<grid[0].length&&grid[row][column+1]==1)
                queue.offer(new int[]{row,column+1});
        }
    }
}