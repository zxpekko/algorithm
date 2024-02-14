package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author:zxp
 * @Description:给你一个 m x n 大小的矩阵 grid ，由若干正整数组成。
 *
 * 执行下述操作，直到 grid 变为空矩阵：
 *
 * 从每一行删除值最大的元素。如果存在多个这样的值，删除其中任何一个。
 * 将删除元素中的最大值与答案相加。
 * 注意 每执行一次操作，矩阵中列的数据就会减 1 。
 *
 * 返回执行上述操作后的答案。
 *
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/delete-greatest-value-in-each-row
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 输入：grid = [[1,2,4],[3,3,1]]
 * 输出：8
 * 解释：上图展示在每一步中需要移除的值。
 * - 在第一步操作中，从第一行删除 4 ，从第二行删除 3（注意，有两个单元格中的值为 3 ，我们可以删除任一）。在答案上加 4 。
 * - 在第二步操作中，从第一行删除 2 ，从第二行删除 3 。在答案上加 3 。
 * - 在第三步操作中，从第一行删除 1 ，从第二行删除 1 。在答案上加 1 。
 * 最终，答案 = 4 + 3 + 1 = 8 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/delete-greatest-value-in-each-row
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date:18:56 2023/7/28
 */
public class DeleteMaxNumber {
    public static void main(String[] args) {
        int[][] grid={{1,2,4},{3,3,1}};
        DeleteMaxNumber deleteMaxNumber = new DeleteMaxNumber();
        int i = deleteMaxNumber.deleteGreatestValue(grid);
        System.out.println(i);
    }
    public int deleteGreatestValue(int[][] grid){
        for(int i=0;i<grid.length;i++){
            Arrays.sort(grid[i]);
        }
//        List<Integer> list=new ArrayList<>();
        int maxSum=0;
        for(int i=grid[0].length-1;i>=0;i--){
            int max=-1;
            for(int j=0;j<grid.length;j++){
                if(grid[j][i]>max)
                    max=grid[j][i];
            }
            maxSum+=max;
        }
        return maxSum;
    }
}
