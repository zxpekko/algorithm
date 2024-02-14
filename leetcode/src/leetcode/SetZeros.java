package leetcode;

import javax.swing.*;
import java.util.*;

/**
 * @Author:zxp
 * @Description:给定一个 m x n 的矩阵，如果一个元素为 0 ，则将其所在行和列的所有元素都设为 0 。请使用 原地 算法。
 * 输入：matrix = [[1,1,1],[1,0,1],[1,1,1]]
 * 输出：[[1,0,1],[0,0,0],[1,0,1]]
 * 示例 2：
 * @Date:21:39 2023/9/2
 */
public class SetZeros {
    public static void main(String[] args) {
        int[][] matrix={{1,1,1},{1,0,1},{1,1,1}};
        SetZeros setZeros = new SetZeros();
        setZeros.setZeroes(matrix);
        for(int i=0;i<matrix.length;i++){
            System.out.println(Arrays.toString(matrix[i]));
        }
        System.out.println(Arrays.toString(matrix));
    }
    public void setZeroes(int[][] matrix){
//        List<Integer[]> record=new ArrayList<>();
        Map<Integer,Integer> rowRecord=new HashMap<>();
        Map<Integer,Integer> columnRecord=new HashMap<>();

        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[i].length;j++){
                if(matrix[i][j]==0){
                    if(!rowRecord.containsKey(i))
                        rowRecord.put(i,1);
                    if(!columnRecord.containsKey(j))
                        columnRecord.put(j,1);
                }
//                    record.add(new Integer[]{i,j});
            }
        }
        for (Map.Entry<Integer, Integer> integerIntegerEntry : rowRecord.entrySet()) {
            Integer key = integerIntegerEntry.getKey();
            for(int k=0;k<matrix[key].length;k++)
                matrix[key][k]=0;
        }
        for (Map.Entry<Integer, Integer> integerIntegerEntry : columnRecord.entrySet()) {
            Integer key = integerIntegerEntry.getKey();
            for(int k=0;k<matrix.length;k++)
                matrix[k][key]=0;
        }


    }
}
