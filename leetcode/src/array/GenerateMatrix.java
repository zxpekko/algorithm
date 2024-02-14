package array;

import javax.swing.*;
import java.util.*;

/**
 * @Author:zxp
 * @Description:给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：n = 3
 * 输出：[[1,2,3],[8,9,4],[7,6,5]]
 * 示例 2：
 * <p>
 * 输入：n = 1
 * 输出：[[1]]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 20
 * @Date:14:49 2024/1/16
 */
public class GenerateMatrix {
    public static void main(String[] args) {
        GenerateMatrix generateMatrix = new GenerateMatrix();
        GenerateMatrixⅡ generateMatrixⅡ = new GenerateMatrixⅡ();
        for (int[] ints : generateMatrixⅡ.generateMatrix(4)) {
            System.out.println(Arrays.toString(ints));
        }
        System.out.println("==================================");
        for (int[] ints : generateMatrix.generateMatrix(4)) {
            System.out.println(Arrays.toString(ints));
        }

    }

    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        boolean[][] record = new boolean[n][n];
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int originalDirection = 0;
        int row = 0, column = 0;
        for (int i = 1; i <= n * n; i++) {
            result[row][column] = i;
            record[row][column] = true;
            int nextRow = row + directions[originalDirection][0], nextColumn = column + directions[originalDirection][1];
            if (nextRow < 0 || nextRow >= n || nextColumn < 0 || nextColumn >= n || record[nextRow][nextColumn])
                originalDirection = (originalDirection + 1) % 4;
            row += directions[originalDirection][0];
            column += directions[originalDirection][1];
        }
        return result;
    }

}

class GenerateMatrixⅡ {
    public int[][] generateMatrix(int n) {
        boolean[][] record = new boolean[n][n];
        int[][] result = new int[n][n];
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int originalDirection = 0;
        int row = 0, column = 0;
        for (int i = 1; i <= n * n; i++) {
            result[row][column] = i;
            record[row][column] = true;
            int nextRow = row + directions[originalDirection][0], nextColumn = column + directions[originalDirection][1];
            if (nextRow < 0 || nextRow >= n || nextColumn < 0 || nextColumn >= n || record[nextRow][nextColumn])
                originalDirection = (originalDirection + 1) % 4;
            row += directions[originalDirection][0];
            column += directions[originalDirection][1];
        }
        return result;
    }
}
