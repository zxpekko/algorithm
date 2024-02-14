package graphtheory;

import java.util.*;

/**
 * @Author:zxp
 * @Description:给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 *
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
 *
 * 此外，你可以假设该网格的四条边均被水包围。
 *
 *
 *
 * 示例 1：
 *
 * 输入：grid = [
 *   ["1","1","1","1","0"],
 *   ["1","1","0","1","0"],
 *   ["1","1","0","0","0"],
 *   ["0","0","0","0","0"]
 * ]
 * 输出：1
 * 示例 2：
 *
 * 输入：grid = [
 *   ["1","1","0","0","0"],
 *   ["1","1","0","0","0"],
 *   ["0","0","1","0","0"],
 *   ["0","0","0","1","1"]
 * ]
 * 输出：3
 *
 *
 * 提示：
 *
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 300
 * @Date:10:26 2024/2/3
 */
public class NumIslands {
    public static void main(String[] args) {
        NumIslands numIslands = new NumIslands();
        char[][] chars = {{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
        System.out.println(numIslands.numIslands(chars));
        NumsIslandⅡ numsIslandⅡ = new NumsIslandⅡ();
        char[][] chars1 = {{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
        System.out.println(numsIslandⅡ.numIslands(chars1));
    }
    public int numIslands(char[][] grid){//深度优先搜索
        int result=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j]=='1'){
                    result++;
                    dfs(grid,i,j);//找到为1的地方就加1，同时调用dfs函数将自己和他的上下左右都置为0.
                }
            }
        }
        return result;
    }
    public void dfs(char[][] grid,int i,int j){//此处采用深度优先搜索将上面为1的位置的周围的为1的部分全部“淹没”
        if(i<0||i>= grid.length||j<0||j>=grid[0].length||grid[i][j]=='0')
            return;
        grid[i][j]='0';
        dfs(grid,i-1,j);
        dfs(grid,i+1,j);
        dfs(grid,i,j-1);
        dfs(grid,i,j+1);
    }
}
class NumsIslandⅡ{
    public int numIslands(char[][] grid){//广度优先搜索
        int result=0;
        int m=grid.length;
        int n=grid[0].length;
        boolean[][] visited = new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]=='1'){
                    result++;
                    bfs(grid,visited,i,j);
                }
            }
        }
        return result;
    }
    public void bfs(char[][] grid,boolean[][] visited, int i,int j){//采用广度优先搜索的方式将上面判断的为1的位置的周围上下左右的位置也置为0
        Queue<int[]> queue=new LinkedList<>();
        grid[i][j]='0';
        queue.offer(new int[]{i,j});
        visited[i][j]=true;
        while (!queue.isEmpty()){
            int[] poll = queue.poll();
            int row=poll[0];
            int column=poll[1];
            if(row-1>=0&&!visited[row-1][column]&&grid[row-1][column]=='1'){
                grid[row-1][column]='0';
                queue.offer(new int[]{row-1,column});
                visited[row-1][column]=true;
            }
            if(row+1<grid.length&&!visited[row+1][column]&&grid[row+1][column]=='1'){
                grid[row+1][column]='0';
                queue.offer(new int[]{row+1,column});
                visited[row+1][column]=true;
            }
            if(column-1>=0&&!visited[row][column-1]&&grid[row][column-1]=='1'){
                grid[row][column-1]='0';
                queue.offer(new int[]{row,column-1});
                visited[row][column-1]=true;
            }
            if(column+1<grid[0].length&&!visited[row][column+1]&&grid[row][column+1]=='1'){
                grid[row][column+1]='0';
                queue.offer(new int[]{row,column+1});
                visited[row][column+1]=true;
            }
        }
    }
}
