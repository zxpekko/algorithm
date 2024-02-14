package array;

import java.util.Arrays;

/**
 * @Author:zxp
 * @Description:
 * @Date:20:41 2024/1/12
 */
public class SortedSquares {
    public static void main(String[] args) {
        SortedSquares sortedSquares = new SortedSquares();
        int[] ints = sortedSquares.sortedSquares(new int[]{-7,-3,2,3,11});
        System.out.println(Arrays.toString(ints));
    }
    public int[] sortedSquares(int[] nums){
        int[] result = new int[nums.length];
        int i=0,j= nums.length-1;
        int startIndex= nums.length-1;
        while (i<=j){
            if(nums[i]*nums[i]>nums[j]*nums[j]){
                result[startIndex]=nums[i]*nums[i];
                i++;
            }

            else{
                result[startIndex]=nums[j]*nums[j];
                j--;
            }
            startIndex--;
        }
        return result;
    }
}
