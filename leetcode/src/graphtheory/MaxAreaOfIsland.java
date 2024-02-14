package graphtheory;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author:zxp
 * @Description:给你一个大小为 m x n 的二进制矩阵 grid 。
 *
 * 岛屿 是由一些相邻的 1 (代表土地) 构成的组合，这里的「相邻」要求两个 1 必须在 水平或者竖直的四个方向上 相邻。你可以假设 grid 的四个边缘都被 0（代表水）包围着。
 *
 * 岛屿的面积是岛上值为 1 的单元格的数目。
 *
 * 计算并返回 grid 中最大的岛屿面积。如果没有岛屿，则返回面积为 0 。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：grid = [[0,0,1,0,0,0,0,1,0,0,0,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,1,1,0,1,0,0,0,0,0,0,0,0],[0,1,0,0,1,1,0,0,1,0,1,0,0],[0,1,0,0,1,1,0,0,1,1,1,0,0],[0,0,0,0,0,0,0,0,0,0,1,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,0,0,0,0,0,0,1,1,0,0,0,0]]
 * 输出：6
 * 解释：答案不应该是 11 ，因为岛屿只能包含水平或垂直这四个方向上的 1 。
 * 示例 2：
 *
 * 输入：grid = [[0,0,0,0,0,0,0,0]]
 * 输出：0
 * @Date:11:22 2024/2/3
 */
public class MaxAreaOfIsland {
    public static void main(String[] args) {
        MaxAreaOfIsland maxAreaOfIsland = new MaxAreaOfIsland();
        int[][] ints = {{0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},{0,1,1,0,1,0,0,0,0,0,0,0,0},{0,1,0,0,1,1,0,0,1,0,1,0,0}
        ,{0,1,0,0,1,1,0,0,1,1,1,0,0},{0,0,0,0,0,0,0,0,0,0,1,0,0},{0,0,0,0,0,0,0,1,1,1,0,0,0},{0,0,0,0,0,0,0,1,1,0,0,0,0}};
        System.out.println(maxAreaOfIsland.maxAreaOfIsland(ints));
        MaxAreaOfIslandⅡ maxAreaOfIslandⅡ = new MaxAreaOfIslandⅡ();
        int[][] ints1 = {{0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},{0,1,1,0,1,0,0,0,0,0,0,0,0},{0,1,0,0,1,1,0,0,1,0,1,0,0}
                ,{0,1,0,0,1,1,0,0,1,1,1,0,0},{0,0,0,0,0,0,0,0,0,0,1,0,0},{0,0,0,0,0,0,0,1,1,1,0,0,0},{0,0,0,0,0,0,0,1,1,0,0,0,0}};
        System.out.println(maxAreaOfIslandⅡ.maxAreaOfIsland(ints1));

    }
    public int maxAreaOfIsland(int[][] grid){
        int result=Integer.MIN_VALUE;
        int m= grid.length;
        int n=grid[0].length;
        int[] subResult = new int[1];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    dfs(grid,subResult,i,j);
                }
                if(subResult[0]>result)
                    result=subResult[0];
                subResult[0]=0;
            }
        }
        return result;
    }
    public void dfs(int[][] grid,int[] subResult,int i,int j){
        if(i<0|i>=grid.length||j<0||j>=grid[0].length||grid[i][j]==0)
            return;
        grid[i][j]=0;
        subResult[0]++;
        dfs(grid,subResult,i-1,j);
        dfs(grid,subResult,i+1,j);
        dfs(grid,subResult,i,j-1);
        dfs(grid,subResult,i,j+1);
    }
}
class MaxAreaOfIslandⅡ{
    public int maxAreaOfIsland(int[][] grid){
        int result=Integer.MIN_VALUE;
        int[] subResult = new int[1];
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j]==1){
                    bfs(grid,subResult,i,j);
                }
                if(subResult[0]>result)
                    result=subResult[0];
                subResult[0]=0;
            }
        }
        return result;
    }
    public void bfs(int[][] grid,int[] subResult,int i,int j){
        Queue<int[]> queue=new LinkedList<>();
        queue.offer(new int[]{i,j});
        grid[i][j]=0;
        subResult[0]++;
        while (!queue.isEmpty()){
            int[] poll = queue.poll();
            int row=poll[0];
            int column=poll[1];
            if(row-1>=0&&grid[row-1][column]==1){
                subResult[0]++;
                grid[row-1][column]=0;
                queue.offer(new int[]{row-1,column});
            }
            if(row+1<grid.length&&grid[row+1][column]==1){
                subResult[0]++;
                grid[row+1][column]=0;
                queue.offer(new int[]{row+1,column});
            }
            if(column-1>=0&&grid[row][column-1]==1){
                subResult[0]++;
                grid[row][column-1]=0;
                queue.offer(new int[]{row,column-1});
            }
            if(column+1<grid[0].length&&grid[row][column+1]==1){
                subResult[0]++;
                grid[row][column+1]=0;
                queue.offer(new int[]{row,column+1});
            }
        }
    }
}
