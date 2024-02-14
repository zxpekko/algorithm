package backtracking;

import java.util.ArrayList;
import java.util.EventListener;
import java.util.List;

/**
 * @Author:zxp
 * @Description:按照国际象棋的规则，皇后可以攻击与之处在同一行或同一列或同一斜线上的棋子。
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
 * @Date:17:25 2024/1/9
 */
public class SolveNQueens {
    public static void main(String[] args) {
        SolveNQueens solveNQueens = new SolveNQueens();
        System.out.println(solveNQueens.solveNQueens(2));
    }
    List<List<String>> result=new ArrayList<>();
    List<String> subResult=new ArrayList<>();
    public List<List<String>> solveNQueens(int n){
        backtracking(n,0);
        return result;
    }
    public void backtracking(int n,int level){
        if(subResult.size()==n){
            result.add(new ArrayList<>(subResult));
            return;
        }
        for(int i=0;i<n;i++){
            if(!subResult.isEmpty()&&isContack(subResult,i,level))
                continue;
            StringBuilder stringBuilder = new StringBuilder();
            for(int j=0;j<n;j++){
                if(j==i)
                    stringBuilder.append("Q");
                else
                    stringBuilder.append(".");
            }
            String s = stringBuilder.toString();
            subResult.add(s);
            backtracking(n,level+1);
            subResult.remove(subResult.size()-1);
        }
    }
    public boolean isContack(List<String> subResult,int indexQ,int level){
        for(int i=0;i<subResult.size();i++){
            String s = subResult.get(i);
            if(s.charAt(indexQ)=='Q')
                return true;
        }
        for(int i=subResult.size()-1,j=1;i>=0;i--,j++){
            String s = subResult.get(i);
            if((indexQ-j>=0&&s.charAt(indexQ-j)=='Q')||(indexQ+j<s.length()&&s.charAt(indexQ+j)=='Q'))
                return true;
        }
        return false;
    }
}
