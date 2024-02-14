package graphtheory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * @Author:zxp
 * @Description:给你一个大小为 n x n 二进制矩阵 grid 。最多 只能将一格 0 变成 1 。
 *
 * 返回执行此操作后，grid 中最大的岛屿面积是多少？
 *
 * 岛屿 由一组上、下、左、右四个方向相连的 1 形成。
 *
 *
 *
 * 示例 1:
 *
 * 输入: grid = [[1, 0], [0, 1]]
 * 输出: 3
 * 解释: 将一格0变成1，最终连通两个小岛得到面积为 3 的岛屿。
 * 示例 2:
 *
 * 输入: grid = [[1, 1], [1, 0]]
 * 输出: 4
 * 解释: 将一格0变成1，岛屿的面积扩大为 4。
 * 示例 3:
 *
 * 输入: grid = [[1, 1], [1, 1]]
 * 输出: 4
 * 解释: 没有0可以让我们变成1，面积依然为 4。
 *
 *
 * 提示：
 *
 * n == grid.length
 * n == grid[i].length
 * 1 <= n <= 500
 * grid[i][j] 为 0 或 1
 * @Date:11:51 2024/2/6
 */
public class LargestIsland {
    public static void main(String[] args) {
//        LargestIsland largestIsland = new LargestIsland();
//        System.out.println(largestIsland.largestIsland(new int[][]{{1,1}, {1, 1}}));
//        LargestIslandⅡ largestIslandⅡ = new LargestIslandⅡ();
//        System.out.println(largestIslandⅡ.largestIsland(new int[][]{{0,0,0,0,0,0,0}, {0,1,1,1,1,0,0},{0,1,0,0,1,0,0},{1,0,1,0,1,0,0},{0,1,0,0,1,0,0},{0,1,0,0,1,0,0},{0,1,1,1,1,0,0}}));
        LargestIslandⅢ largestIslandⅢ = new LargestIslandⅢ();
//        System.out.println(largestIslandⅢ.largestIsland(new int[][]{{0, 0, 0, 0, 0, 0, 0}, {0, 1, 1, 1, 1, 0, 0}, {0, 1, 0, 0, 1, 0, 0}, {1, 0, 1, 0, 1, 0, 0}, {0, 1, 0, 0, 1, 0, 0}, {0, 1, 0, 0, 1, 0, 0}, {0, 1, 1, 1, 1, 0, 0}}));
        System.out.println(largestIslandⅢ.largestIsland(new int[][]{{1, 1}, {1, 1}}));
    }
    int sum=0;
    int max=0;
    public int largestIsland(int[][] grid){//此方法不行，类二时间复杂度高，类三正解。
//        int result=0;
        int m=grid.length;
        int n=grid[0].length;
        int flag=0;
        boolean[][] visited = new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    flag=1;
                    sum=1;
                    visited[i][j]=true;
                    dfs(grid,i,j,0,visited);
//                    for(int k=0;k< visited.length;k++)
//                        Arrays.fill(visited[i],false);
                }
//                if(sum>result)
//                    result=sum;
                sum=0;
            }
        }
        if(flag==0)
            return 1;
        return max;
    }
    public void dfs(int[][] grid,int row,int column,int sign,boolean[][] visited){
        int[][] current={{-1,0},{1,0},{0,-1},{0,1}};
        for(int i=0;i<current.length;i++){
            int curRow=row+current[i][0];
            int curColumn=column+current[i][1];
            if(judgeFalse(visited)){
                if(sum>max)
                    max=sum;
            }
            if(curRow<0||curRow>=grid.length||curColumn<0||curColumn>=grid[0].length)
                continue;
            if(grid[curRow][curColumn]==0&&sign==1){
                if(sum>max)
                    max=sum;
                continue;
            }
            if(visited[curRow][curColumn])
                continue;
            if((grid[curRow][curColumn]==0&&sign==0)&&!visited[curRow][curColumn]){
                sum+=1;
                visited[curRow][curColumn]=true;
                grid[curRow][curColumn]=1;
                sign=1;
                dfs(grid,curRow,curColumn,sign,visited);
                sum-=1;
//                visited[curRow][curColumn]=false;
                grid[curRow][curColumn]=0;
                sign=0;
            }
            if(grid[curRow][curColumn]==1&&!visited[curRow][curColumn]){
                sum+=1;
                visited[curRow][curColumn]=true;
                dfs(grid,curRow,curColumn,sign,visited);
//                visited[curRow][curColumn]=false;
//                sum-=1;
            }
        }
    }
    public boolean judgeFalse(boolean[][] visited){
        int m=visited.length;
        int n=visited[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(!visited[i][j])
                    return false;
            }
        }
        return true;
    }
}
class LargestIslandⅡ{
    int sum=0;
    public int largestIsland(int[][] grid){//时间复杂度太高
        int result=0;
        int m=grid.length;
        int n=grid[0].length;
        int flag=0;
        if(isAllZero(grid))
            return 1;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==0){
                    boolean[][] visited = new boolean[m][n];
                    sum+=1;
                    flag=1;
                    dfs(grid,i,j,visited);
                }
                if(sum>result)
                    result=sum;
                sum=0;
            }
        }
        if(flag==0)
            return m*n;
        return result;
    }
    public void dfs(int[][] grid,int row,int column,boolean[][] visited){
        int[][] current={{-1,0},{1,0},{0,-1},{0,1}};
        for(int i=0;i<current.length;i++){
            int curRow=row+current[i][0];
            int curColumn=column+current[i][1];
            if(curRow<0||curRow>=grid.length||curColumn<0||curColumn>=grid[0].length)
                continue;
            if(grid[curRow][curColumn]==0||visited[curRow][curColumn])
                continue;
            sum+=1;
            visited[curRow][curColumn]=true;
            dfs(grid,curRow,curColumn,visited);
//            visited[curRow][curColumn]=false;
        }
    }
    public boolean isAllZero(int[][] grid){
        int m=grid.length;
        int n=grid[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1)
                    return false;
            }
        }
        return true;
    }
}
class LargestIslandⅢ{
    int sum=0;
    public int largestIsland(int[][] grid){
        int[][] current={{-1,0},{1,0},{0,-1},{0,1}};
        int m=grid.length;
        int n=grid[0].length;
        int[][] record= new int[m][n];
        boolean[][] visited = new boolean[m][n];
        List<Integer> recordArea=new ArrayList<>();
        int index=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1&&!visited[i][j]){
                    visited[i][j]=true;
                    record[i][j]=index;
                    sum+=1;
                    dfs(grid,i,j,record,visited,index);
                    index++;
                    recordArea.add(sum);
                    sum=0;
                }
            }
        }
        int result=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==0){
                    int cur=1;
                    HashSet<Integer> hashSet = new HashSet<>();
                    for(int k=0;k<current.length;k++){
                        int curRow=i+current[k][0];
                        int curColumn=j+current[k][1];
                        if(curRow<0||curRow>=m||curColumn<0||curColumn>=n)
                            continue;
                        if(grid[curRow][curColumn]==0)
                            continue;
                        int mark = record[curRow][curColumn];
                        if(hashSet.contains(mark))
                            continue;
                        hashSet.add(mark);
                        cur+=recordArea.get(mark);
                    }
                    if(cur>result)
                        result=cur;
                }
            }
        }
        return result>0?result:m*n;
    }
    public void dfs(int[][] grid,int row,int column,int[][] record,boolean[][] visited,int index){
        int[][] current={{-1,0},{1,0},{0,-1},{0,1}};
        for(int i=0;i<current.length;i++){
            int curRow=row+current[i][0];
            int curColumn=column+current[i][1];
            if(curRow<0||curRow>= grid.length||curColumn<0||curColumn>=grid[0].length)
                continue;
            if(grid[curRow][curColumn]==0||visited[curRow][curColumn])
                continue;
            sum+=1;
            record[curRow][curColumn]=index;
            visited[curRow][curColumn]=true;
            dfs(grid,curRow,curColumn,record,visited,index);
        }
    }
}