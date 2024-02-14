package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Author:zxp
 * @Description:51
 *
 * 按照国际象棋的规则，皇后可以攻击与之处在同一行或同一列或同一斜线上的棋子。
 *
 * n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 *
 * 给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。
 *
 * 每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：n = 4
 * 输出：[[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
 * 解释：如上图所示，4 皇后问题存在两个不同的解法。
 * 示例 2：
 *
 * 输入：n = 1
 * 输出：[["Q"]]
 *
 *
 * 提示：
 *
 * 1 <= n <= 9
 * @Date:11:45 2023/9/8
 */
public class NQueue {
    public static void main(String[] args) {
        NQueue nQueue = new NQueue();
        System.out.println(nQueue.solveNQueens(8));
    }
    public List<List<String>> solveNQueens(int n){
        List<List<String>> result=new ArrayList<>();
//        List<String> subResult=new ArrayList<>();
        int[] board=new int[n];
        dfs(board,0,result);

        return result;
    }
    public void dfs(int[] board,int row,List<List<String>> result){
        if(row== board.length){
            List<String> subResult=new ArrayList<>();
            for(int i=0;i<board.length;i++){
//                String s=null;
                char[] chars=new char[board.length];
                for(int j=0;j<board[i];j++)
                    chars[j]='.';
//                s+="Q";
                chars[board[i]]='Q';
                for(int j=board[i]+1;j< board.length;j++)
                    chars[j]='.';
                String s = new String(chars);
                subResult.add(s);
            }
            result.add(subResult);
            return;
        }
        for(int i=0;i< board.length;i++){//i此处代表哪一列
            if(check(board,row,i)){
                board[row]=i;
                dfs(board,row+1,result);
            }
        }
    }
    public boolean check(int[] board,int row,int col){
        for(int i=0;i< row;i++){
            if((board[i]-col==0)|| (Math.abs(i-row)==Math.abs(board[i]-col)))
                return false;
        }
        return true;
    }
}
