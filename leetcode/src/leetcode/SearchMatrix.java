package leetcode;

/**
 * @Author:zxp
 * @Description:给你一个满足下述两条属性的 m x n 整数矩阵：
 *
 * 每行中的整数从左到右按非递减顺序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 * 给你一个整数 target ，如果 target 在矩阵中，返回 true ；否则，返回 false 。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
 * 输出：true
 * 示例 2：
 *
 *
 * 输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
 * 输出：false
 *
 * @Date:11:13 2023/9/14
 */
public class SearchMatrix {
    public static void main(String[] args) {
//        int[][] matrix={{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        int[][] matrix={{1}};
        SearchMatrix searchMatrix = new SearchMatrix();
        System.out.println(searchMatrix.searchMatrix(matrix, 1));
    }
    public boolean searchMatrix(int[][] matrix, int target){
        int i;
        for(i=0;i<matrix.length;i++){
            if(matrix[i][matrix[i].length-1]>target)
                break;
            if(matrix[i][matrix[i].length-1]==target||matrix[i][0]==target)
                return true;
        }
        if(i== matrix.length)
            return false;
        int left=0,right=matrix[i].length-1;
        while (left<=right){
            int mid=(left+right)/2;
            if(matrix[i][mid]==target)
                return true;
            else if(matrix[i][mid]<target)
                left=mid+1;
            else
                right=mid-1;
        }
        return false;
    }
}
