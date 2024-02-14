package graphtheory;

/**
 * @Author:zxp
 * @Description:给定一个 row x col 的二维网格地图 grid ，其中：grid[i][j] = 1 表示陆地， grid[i][j] = 0 表示水域。
 *
 * 网格中的格子 水平和垂直 方向相连（对角线方向不相连）。整个网格被水完全包围，但其中恰好有一个岛屿（或者说，一个或多个表示陆地的格子相连组成的岛屿）。
 *
 * 岛屿中没有“湖”（“湖” 指水域在岛屿内部且不和岛屿周围的水相连）。格子是边长为 1 的正方形。网格为长方形，且宽度和高度均不超过 100 。计算这个岛屿的周长。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：grid = [[0,1,0,0],[1,1,1,0],[0,1,0,0],[1,1,0,0]]
 * 输出：16
 * 解释：它的周长是上面图片中的 16 个黄色的边
 * 示例 2：
 *
 * 输入：grid = [[1]]
 * 输出：4
 * 示例 3：
 *
 * 输入：grid = [[1,0]]
 * 输出：4
 *
 *
 * 提示：
 *
 * row == grid.length
 * col == grid[i].length
 * 1 <= row, col <= 100
 * grid[i][j] 为 0 或 1
 * @Date:12:50 2024/2/7
 */
public class IslandPerimeter {
    public static void main(String[] args) {
        IslandPerimeter islandPerimeter = new IslandPerimeter();
//        System.out.println(islandPerimeter.islandPerimeter(new int[][]{{0, 1, 0, 0}, {1, 1, 1, 0}, {0, 1, 0, 0}, {1, 1, 0, 0}}));
        System.out.println(islandPerimeter.islandPerimeter(new int[][]{{1}}));
    }
    int sum;
    int[][] position={{-1,0},{1,0},{0,-1},{0,1}};
    public int islandPerimeter(int[][] grid){
        int m=grid.length;
        int n=grid[0].length;
        boolean[][] visited = new boolean[m][n];
        label:for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    visited[i][j]=true;
                    int reduce = ComputeOneNums(grid, i, j);
                    sum+=(4-reduce);
                    dfs(grid,i,j,visited);
                    break label;
                }
            }
        }

        return sum;
    }
    public void dfs(int[][] grid,int row,int column,boolean[][] visited){
        for(int i=0;i<position.length;i++){
            int curRow=row+position[i][0];
            int curColumn=column+position[i][1];
            if(curRow<0||curRow>=grid.length||curColumn<0||curColumn>=grid[0].length)
                continue;
            if(grid[curRow][curColumn]==0||visited[curRow][curColumn])
                continue;
            int reduce = ComputeOneNums(grid, curRow, curColumn);
            sum+=(4-reduce);
            visited[curRow][curColumn]=true;
            dfs(grid,curRow,curColumn,visited);
        }
    }
    public int ComputeOneNums(int[][] grid,int row,int column){
        int oneNums=0;
        for(int i=0;i< position.length;i++){
            int curRow=row+position[i][0];
            int curColumn=column+position[i][1];
            if(curRow<0||curRow>=grid.length||curColumn<0||curColumn>=grid[0].length)
                continue;
            if(grid[curRow][curColumn]==0)
                continue;
            oneNums++;
        }
        return oneNums;
    }
}
