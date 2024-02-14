package graphtheory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author:zxp
 * @Description:有一个 m × n 的矩形岛屿，与 太平洋 和 大西洋 相邻。 “太平洋” 处于大陆的左边界和上边界，而 “大西洋” 处于大陆的右边界和下边界。
 *
 * 这个岛被分割成一个由若干方形单元格组成的网格。给定一个 m x n 的整数矩阵 heights ， heights[r][c] 表示坐标 (r, c) 上单元格 高于海平面的高度 。
 *
 * 岛上雨水较多，如果相邻单元格的高度 小于或等于 当前单元格的高度，雨水可以直接向北、南、东、西流向相邻单元格。水可以从海洋附近的任何单元格流入海洋。
 *
 * 返回网格坐标 result 的 2D 列表 ，其中 result[i] = [ri, ci] 表示雨水从单元格 (ri, ci) 流动 既可流向太平洋也可流向大西洋 。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入: heights = [[1,2,2,3,5],[3,2,3,4,4],[2,4,5,3,1],[6,7,1,4,5],[5,1,1,2,4]]
 * 输出: [[0,4],[1,3],[1,4],[2,2],[3,0],[3,1],[4,0]]
 * 示例 2：
 *
 * 输入: heights = [[2,1],[1,2]]
 * 输出: [[0,0],[0,1],[1,0],[1,1]]
 * @Date:20:01 2024/2/4
 */
public class PacificAtlantic {
    public static void main(String[] args) {
        int[][] ints = {{1, 2, 2, 3, 5}, {3, 2, 3, 4, 4}, {2, 4, 5, 3, 1}, {6, 7, 1, 4, 5}, {5, 1, 1, 2, 4}};
//        PacificAtlantic pacificAtlantic = new PacificAtlantic();
//        List<List<Integer>> list = pacificAtlantic.pacificAtlantic(ints);
//        System.out.println(list);
        PacificAtlanticⅡ pacificAtlanticⅡ = new PacificAtlanticⅡ();
        System.out.println(pacificAtlanticⅡ.pacificAtlantic(ints));
        PacificAtlanticⅢ pacificAtlanticⅢ = new PacificAtlanticⅢ();
        System.out.println(pacificAtlanticⅢ.pacificAtlantic(ints));
    }
    List<List<Integer>> result=new ArrayList<>();
    List<Integer> subResult=new ArrayList<>();
    public List<List<Integer>> pacificAtlantic(int[][] heights){//此类里的解法暂时不通。

        for(int i=0;i<heights.length;i++){
            for(int j=0;j<heights[i].length;j++){
                if(dfsPa(heights,i,j)&&dfsAt(heights,i,j)){
                    subResult.add(i);
                    subResult.add(j);
                    result.add(new ArrayList<>(subResult));
                    subResult.clear();
                }
            }
        }
        return result;
    }
    public boolean dfsPa(int[][] heights,int row,int column){
        if(row<0||row>=heights.length||column<0||column>=heights[0].length)
            return false;
        if(row==0||column==0)
            return true;
        boolean up=false;
        boolean down=false;
        boolean left=false;
        boolean right=false;
        if(row-1>=0&&heights[row][column]>=heights[row-1][column])
             up=dfsPa(heights,row-1,column);
        if(row+1<heights.length&&heights[row][column]>=heights[row+1][column])
            down=dfsPa(heights,row+1,column);
        if(column-1>=0&&heights[row][column]>=heights[row][column-1])
            left=dfsPa(heights,row,column-1);
        if(column+1<heights[0].length&&heights[row][column]>=heights[row][column+1])
            right=dfsPa(heights,row,column+1);
        return up||down||left||right;
    }
    public boolean dfsAt(int[][] heights,int row,int column){
        if(row<0||row>=heights.length||column<0||column>=heights[0].length)
            return false;
        if(row== heights.length-1||column==heights[0].length-1)
            return true;
        boolean up=false;
        boolean down=false;
        boolean left=false;
        boolean right=false;
        if(row-1>=0&&heights[row][column]>=heights[row-1][column])
            up=dfsAt(heights,row-1,column);
        if(row+1<heights.length&&heights[row][column]>=heights[row+1][column])
            down=dfsAt(heights,row+1,column);
        if(column-1>=0&&heights[row][column]>=heights[row][column-1])
            left=dfsAt(heights,row,column-1);
        if(column+1<heights[0].length&&heights[row][column]>=heights[row][column+1])
            right=dfsAt(heights,row,column+1);
        return up||down||left||right;
    }
}
class PacificAtlanticⅡ{
    public List<List<Integer>> pacificAtlantic(int[][] heights){
        int m=heights.length;
        int n=heights[0].length;
        boolean[][][] visited = new boolean[m][n][2];
        List<List<Integer>> result=new ArrayList<>();
        //dfs中的sign标志，我们用1代表太平洋，0代表大西洋。
        for(int i=0;i<m;i++){
            visited[i][0][1]=true;
            visited[i][n-1][0]=true;
            dfs(heights,i,0,1,visited);
            dfs(heights,i,n-1,0,visited);
        }
        for(int j=0;j<n;j++){
            visited[0][j][1]=true;
            visited[m-1][j][0]=true;
            dfs(heights,0,j,1,visited);
            dfs(heights,m-1,j,0,visited);
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(visited[i][j][0]&&visited[i][j][1])
                    result.add(Arrays.asList(i,j));
            }
        }
        return result;
    }
    public void dfs(int[][] heights,int row,int column,int sign,boolean[][][] visited){
        int[][] current={{-1,0},{1,0},{0,-1},{0,1}};
        for(int i=0;i< current.length;i++){
            int curRow=row+current[i][0];
            int curColumn=column+current[i][1];
            if(curRow<0||curRow>=heights.length||curColumn<0||curColumn>=heights[0].length||visited[curRow][curColumn][sign])
                continue;
            if(heights[row][column]>heights[curRow][curColumn])
                continue;
            visited[curRow][curColumn][sign]=true;
            dfs(heights,curRow,curColumn,sign,visited);
        }
    }
}
class PacificAtlanticⅢ{
    int[][] position={{-1,0},{1,0},{0,-1},{0,1}};
    public List<List<Integer>> pacificAtlantic(int[][] heights){
        List<List<Integer>> result=new ArrayList<>();
        int m=heights.length;
        int n=heights[0].length;
        boolean[][][] judge = new boolean[m][n][2];
        for(int i=0;i<m;i++){//1代表是否能流入太平洋，0代表是否能流入大西洋
            judge[i][0][1]=true;
            judge[i][n-1][0]=true;
            dfs(heights,judge,i,0,1);
            dfs(heights,judge,i,n-1,0);
        }
        for(int j=0;j<n;j++){
            judge[0][j][1]=true;
            judge[m-1][j][0]=true;
            dfs(heights,judge,0,j,1);
            dfs(heights,judge,m-1,j,0);
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(judge[i][j][0]&&judge[i][j][1])
                    result.add(Arrays.asList(i,j));
            }
        }
        return result;
    }
    public void dfs(int[][] heights,boolean[][][] judge,int row,int column,int sign){//sign 1代表太平洋,0代表大西洋
        for(int i=0;i<position.length;i++){
            int curRow=row+position[i][0];
            int curColumn=column+position[i][1];
            if(curRow<0||curRow>=heights.length||curColumn<0||curColumn>=heights[0].length)
                continue;
            if(heights[row][column]>heights[curRow][curColumn]||judge[curRow][curColumn][sign])
                continue;
            judge[curRow][curColumn][sign]=true;
            dfs(heights,judge,curRow,curColumn,sign);
        }
    }
}