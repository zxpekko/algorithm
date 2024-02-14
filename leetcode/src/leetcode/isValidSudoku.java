package leetcode;

import org.junit.Test;

/**
 * @Author:zxp
 * @Description:请你判断一个 9 x 9 的数独是否有效。只需要 根据以下规则 ，验证已经填入的数字是否有效即可。
 *
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。（请参考示例图）
 *
 *
 * 注意：
 *
 * 一个有效的数独（部分已被填充）不一定是可解的。
 * 只需要根据以上规则，验证已经填入的数字是否有效即可。
 * 空白格用 '.' 表示。
 *
 * @Date:20:17 2023/8/11
 */
public class isValidSudoku {
    public static void main(String[] args) {
        char[][] board={{'5','3','.','.','.','.','.','.','.'},{'6','.','.','1','9','5','.','.','.'},{'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},{'4','.','.','8','.','3','.','.','1'},{'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},{'.','.','.','4','1','9','.','.','5'},{'.','.','.','.','8','.','.','7','9'},};
        isValidSudoku isValidSudoku = new isValidSudoku();
        boolean validSudoku = isValidSudoku.isValidSudoku(board);
        System.out.println(validSudoku);
    }
    public boolean isValidSudoku(char[][] board) {
        for(int i=0;i< board.length;i++){
            for(int j=0;j<board[i].length;j++){
                if(board[i][j]!='.'){
                    for(int k=0;k< board.length;k++){
                        if(k==j)
                            continue;
                        else if(board[i][j]==board[i][k])
                            return false;

                    }
                    for(int k=0;k<board.length;k++){
                        if(k==i)
                            continue;
                        else if (board[i][j]==board[k][j]) {
                            return false;
                        }
                    }
                    int row=i/3;
                    int column=j/3;
                    for(int m=row*3;m<3+row*3;m++){
                        for(int n=column*3;n<3+column*3;n++){
                            if(m==i&&n==j)
                                continue;
                            else if (board[m][n]==board[i][j]) {
                                return false;
                            }
                        }
                    }

                }
            }
        }
        return true;
    }
    @Test
    public void test(){
        char a='.';
        System.out.println(a=='.');
    }
}
