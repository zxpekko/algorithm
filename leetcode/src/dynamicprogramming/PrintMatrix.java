package dynamicprogramming;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author:zxp
 * @Description:
 * @Date:21:43 2023/5/22
 */
public class PrintMatrix {
    public static void main(String[] args) {
        PrintMatrix printMatrix = new PrintMatrix();
        int[][] ints = {{0, 1, 2}, {2, 3, 4}, {2, 1, 2}};
        List<Integer> integers = printMatrix.spiralOrder(ints);
        System.out.println(integers);
    }
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> integers = new ArrayList();
        if(matrix==null || matrix.length==0 ||matrix[0].length==0)
            return integers;
        int rows=matrix.length,columns=matrix[0].length;
        int total=rows*columns;
        int row=0,column=0;
        int[][] directions = {{0, 1},{1,0},{0,-1},{-1,0}};
        int IdDirection=0;
        boolean[][] booleans = new boolean[rows][columns];
        for(int i=0;i<total;i++){
            integers.add(matrix[row][column]);
            booleans[row][column]=true;
            int nextRow=row+directions[IdDirection][0],nextCol=column+directions[IdDirection][1];
            if(nextRow<0 || nextRow>=rows ||nextCol<0 || nextCol>=columns || booleans[nextRow][nextCol]==true)
                IdDirection=(IdDirection+1)%4;
            row+=directions[IdDirection][0];
            column+=directions[IdDirection][1];
        }
        return integers;
    }

}
