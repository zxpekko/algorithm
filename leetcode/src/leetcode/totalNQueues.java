package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author:zxp
 * @Description:52
 *
 * n 皇后问题 研究的是如何将 n 个皇后放置在 n × n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 *
 * 给你一个整数 n ，返回 n 皇后问题 不同的解决方案的数量。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：n = 4
 * 输出：2
 * 解释：如上图所示，4 皇后问题存在两个不同的解法。
 * 示例 2：
 *
 * 输入：n = 1
 * 输出：1
 * @Date:12:24 2023/9/8
 */
public class totalNQueues {
    public static void main(String[] args) {
        totalNQueues totalNQueues = new totalNQueues();
        System.out.println(totalNQueues.totalNQueens(4));

    }
//    int count=0;
    public int totalNQueens(int n){

        int[] board=new int[n];
        List<Integer> result=new ArrayList<>();
        dfs(board,0,result);

        return result.size();
    }
    public void dfs(int[] board,int row,List<Integer> result){
        if(row== board.length)
            result.add(1);
        for(int i=0;i<board.length;i++){
            if(check(board,row,i)){
                board[row]=i;
                dfs(board,row+1,result);
            }
        }
    }
    public boolean check(int[] board,int row,int col){
        for(int i=0;i<row;i++){
            if((Math.abs(i-row)==Math.abs(board[i]-col))||(board[i]-col==0))
                return false;
        }
        return true;
    }
}
