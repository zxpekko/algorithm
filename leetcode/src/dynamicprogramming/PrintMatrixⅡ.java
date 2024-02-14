package dynamicprogramming;

/**
 * @Author:zxp
 * @Description:
 * @Date:19:34 2023/6/1
 */
public class PrintMatrixⅡ {
    public static void main(String[] args) {
        PrintMatrixⅡ printMatrixⅡ = new PrintMatrixⅡ();
        int [][] array=printMatrixⅡ.generateMatrix(3);
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                System.out.print(array[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }
    public int[][] generateMatrix(int n){
        int[][] ints = new int[n][n];
        boolean[][] booleans = new boolean[n][n];
        int row=0,column=0;
        int[][] direction = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int OriginalDirection=0;
        for(int i=1;i<=n*n;i++){
            ints[row][column]=i;
            int nextrow=row+direction[OriginalDirection][0],nextcolumn=column+direction[OriginalDirection][1];
            booleans[row][column]=true;
            if(nextrow<0 || nextrow>=n || nextcolumn<0 ||nextcolumn>=n || booleans[nextrow][nextcolumn]==true)
                OriginalDirection=(OriginalDirection+1)%4;
            row+=direction[OriginalDirection][0];
            column+=direction[OriginalDirection][1];
        }
        return ints;
    }
}
