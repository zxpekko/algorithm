package dynamicprogramming;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author:zxp
 * @Description:
 * @Date:12:25 2023/6/8
 */
public class SolveSudoku {
    public static void main(String[] args) {
        char[][] chars = new char[][]{{'5','3','.','.','7','.','.','.','.'},
            {'6','.','.','1','9','5','.','.','.'},
        {'.','9','8','.','.','.','.','6','.'},
    {'8','.','.','.','6','.','.','.','3'},
        {'4','.','.','8','.','3','.','.','1'},
        {'7','.','.','.','2','.','.','.','6'},
        {'.','6','.','.','.','.','2','8','.'},
        {'.','.','.','4','1','9','.','.','5'},
        {'.','.','.','.','8','.','.','7','9'}};
//        chars[0]=new char[]{}
        SolveSudoku solveSudoku = new SolveSudoku();
        solveSudoku.solveSudoku(chars);
        for(int i=0;i< chars.length;i++){
            for(int j=0;j<chars[i].length;j++){
                System.out.print(chars[i][j]+" ");
            }
            System.out.println();
        }


    }
    boolean[][] line=new boolean[9][9];
    boolean[][] column=new boolean[9][9];
    boolean[][][] block=new boolean[3][3][9];
    boolean valid=false;
    List<int[]> spaces=new ArrayList<int[]>();
    public void solveSudoku(char[][] board){
        for(int i=0;i< board.length;i++){
            for(int j=0;j<board[i].length;j++){
                if(board[i][j]=='.'){
                    spaces.add(new int[]{i,j});
                }
                else {
                    line[i][board[i][j]-'0'-1]=column[j][board[i][j]-'0'-1]=block[i/3][j/3][board[i][j]-'0'-1]=true;
                }
            }
        }
        dfs(board,0);

    }
    public void dfs(char[][] board,int pos){
        if(pos==spaces.size()){
            valid=true;
            return;
        }
        int[] space = spaces.get(pos);
        int i=space[0],j=space[1];
        for(int digit=0;digit<9&& !valid;digit++){
            if(!line[i][digit]&&!column[j][digit]&&!block[i/3][j/3][digit]) {
                board[i][j] = (char) (digit + 1 + '0');
                line[i][digit] = column[j][digit] = block[i / 3][j / 3][digit] = true;
                dfs(board, pos + 1);
                line[i][digit] = column[j][digit] = block[i / 3][j / 3][digit] = false;
            }
        }
    }
    @Test
    public void test(){
        double i=8/3;
        System.out.println(8/3);
    }
}
