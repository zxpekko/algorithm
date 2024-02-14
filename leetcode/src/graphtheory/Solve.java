package graphtheory;

import javax.swing.plaf.PanelUI;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author:zxp
 * @Description:给你一个 m x n 的矩阵 board ，由若干字符 'X' 和 'O' ，找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。
 *
 *
 * 示例 1：
 *
 *
 * 输入：board = [["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O","X","X"]]
 * 输出：[["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X","X"]]
 * 解释：被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。 任何不在边界上，或不与边界上的 'O' 相连的 'O' 最终都会被填充为 'X'。如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。
 * 示例 2：
 *
 * 输入：board = [["X"]]
 * 输出：[["X"]]
 *
 *
 * 提示：
 *
 * m == board.length
 * n == board[i].length
 * 1 <= m, n <= 200
 * board[i][j] 为 'X' 或 'O'
 * @Date:10:54 2024/2/4
 */
public class Solve {
    public static void main(String[] args) {
        Solve solve = new Solve();
        char[][] board=new char[][]{{'O','X','X','O','X'},{'X','O','O','X','O'},{'X','O','X','O','X'},{'O','X','O','O','O'},{'X','X','O','X','O'}};
        char[][] board1=new char[][]{{'O','X','X','O','X'},{'X','O','O','X','O'},{'X','O','X','O','X'},{'O','X','O','O','O'},{'X','X','O','X','O'}};
        //OXXOX
//        XOOXO
        //XOXOX
        //OXOOO
        //XXOXO
        //
        solve.solve(board);
        System.out.println(Arrays.deepToString(board));
        SolveⅡ solveⅡ = new SolveⅡ();
        solveⅡ.solve(board1);
        System.out.println(Arrays.deepToString(board1));
    }
//    public void solve(char[][] board){
//        int m=board.length;
//        int n=board[0].length;
//        for(int i=0;i<m;i++){
//            for(int j=0;j<n;j++){
//                if(board[i][j]=='O')
//                    change(board,i,j);
//            }
//        }
//    }
//    public void change(char[][] board,int i,int j){
//        if(i==0||i== board.length-1||j==0||j==board[0].length-1)
//            return;
//        else{
//            if((board[i-1][j]=='O'&&i-1==0)||(board[i+1][j]=='O'&&i+1==board.length-1)||(board[i][j-1]=='O'&&j-1==0)||(board[i][j+1]=='O'&&j+1==board[0].length-1))
//                return;
//            else
//                board[i][j]='X';
//        }
//    }
    public void solve(char[][] board){
        int m=board.length;
        int n=board[0].length;
        for(int i=0;i<m;i++){
            if(board[i][0]=='O')
                dfs(board,i,0);
            if(board[i][n-1]=='O')
                dfs(board,i,n-1);
        }
        for(int j=0;j<n;j++){
            if(board[0][j]=='O')
                dfs(board,0,j);
            if(board[m-1][j]=='O')
                dfs(board,m-1,j);
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]=='A')
                    board[i][j]='O';
                else if(board[i][j]=='O')
                    board[i][j]='X';
            }
        }
    }
    public void dfs(char[][] board,int i,int j){
        if(i<0||i>=board.length||j<0||j>=board[0].length||board[i][j]=='X'||board[i][j]=='A')
            return;
        board[i][j]='A';
        dfs(board,i-1,j);
        dfs(board,i+1,j);
        dfs(board,i,j-1);
        dfs(board,i,j+1);
    }
}
class SolveⅡ{
    public void solve(char[][] board){
        int m=board.length;
        int n=board[0].length;
        for(int i=0;i<m;i++){
            if(board[i][0]=='O')
                bfs(board,i,0);
            if(board[i][n-1]=='O')
                bfs(board,i,n-1);
        }
        for(int j=0;j<n;j++){
            if(board[0][j]=='O')
                bfs(board,0,j);
            if(board[m-1][j]=='O')
                bfs(board,m-1,j);
        }
        System.out.println(Arrays.deepToString(board));
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]=='A')
                    board[i][j]='O';
                else if(board[i][j]=='O')
                    board[i][j]='X';
            }
        }
    }
    public void bfs(char[][] board,int i,int j){
        Queue<int[]> queue=new LinkedList<>();
        queue.offer(new int[]{i,j});
        while (!queue.isEmpty()){
            int[] poll = queue.poll();
            int row=poll[0];
            int column=poll[1];
            board[row][column]='A';
            if(row-1>=0&&board[row-1][column]=='O')
                queue.offer(new int[]{row-1,column});
            if(row+1<board.length&&board[row+1][column]=='O')
                queue.offer(new int[]{row+1,column});
            if(column-1>=0&&board[row][column-1]=='O')
                queue.offer(new int[]{row,column-1});
            if(column+1<board[0].length&&board[row][column+1]=='O')
                queue.offer(new int[]{row,column+1});
        }
    }
}