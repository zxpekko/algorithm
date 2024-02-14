package leetcode.binarysearch;

/**
 * @Author:zxp
 * @Description:240
 *
 * 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target 。该矩阵具有以下特性：
 *
 * 每行的元素从左到右升序排列。
 * 每列的元素从上到下升序排列。
 *
 *
 * 示例 1：
 *
 *
 * 输入：matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 5
 * 输出：true
 * 示例 2：
 *
 *
 * 输入：matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 20
 * 输出：false
 * @Date:9:53 2023/10/9
 */
public class SearchMatrix {
    public static void main(String[] args) {
        SearchMatrix searchMatrix = new SearchMatrix();
//        int[][] matrix={{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24}};
        int[][] matrix={{-1},{-1}};
        System.out.println(searchMatrix.searchMatrixⅡ(matrix, 3));
    }
    public boolean searchMatrix(int[][] matrix, int target){//逐行二分搜索，只在对角线后面进行搜索。
        for(int i=0;i<matrix.length;i++){
            if(binarySearch(matrix,target,i))
                return true;
        }
        return false;
    }
    public boolean binarySearch(int[][] matrix,int target,int start){
        int left=start,right= matrix[start].length-1;
        while (left<=right){
            int mid=left+((right-left)>>1);
            if(matrix[start][mid]>target)
                right=mid-1;
            else if(matrix[start][mid]<target)
                left=mid+1;
            else return true;
        }
        int up=start,down= matrix.length-1;
        if(start<matrix[start].length){
            while (up<=down){
                int mid=up+((down-up)>>1);
                if(matrix[mid][start]>target)
                    down=mid-1;
                else if(matrix[mid][start]<target)
                    up=mid+1;
                else
                    return true;
            }
        }

        return false;
    }
    public boolean searchMatrixⅡ(int[][] matrix, int target){//官方妙解，Z字型查找，从右上角逐渐缩小搜索范围。
        int row=0,column=matrix[0].length-1;
        while (row<matrix.length&&column>=0){
            if(matrix[row][column]>target)
                column--;
            else if(matrix[row][column]<target)
                row++;
            else return true;
        }
        return false;
    }

}
