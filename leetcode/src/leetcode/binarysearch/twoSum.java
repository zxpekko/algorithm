package leetcode.binarysearch;

import java.util.Arrays;

/**
 * @Author:zxp
 * @Description:给你一个下标从 1 开始的整数数组 numbers ，该数组已按 非递减顺序排列  ，请你从数组中找出满足相加之和等于目标数 target 的两个数。如果设这两个数分别是 numbers[index1] 和 numbers[index2] ，则 1 <= index1 < index2 <= numbers.length 。
 *
 * 以长度为 2 的整数数组 [index1, index2] 的形式返回这两个整数的下标 index1 和 index2。
 *
 * 你可以假设每个输入 只对应唯一的答案 ，而且你 不可以 重复使用相同的元素。
 *
 * 你所设计的解决方案必须只使用常量级的额外空间。
 *
 *
 * 示例 1：
 *
 * 输入：numbers = [2,7,11,15], target = 9
 * 输出：[1,2]
 * 解释：2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。返回 [1, 2] 。
 * 示例 2：
 *
 * 输入：numbers = [2,3,4], target = 6
 * 输出：[1,3]
 * 解释：2 与 4 之和等于目标数 6 。因此 index1 = 1, index2 = 3 。返回 [1, 3] 。
 * 示例 3：
 *
 * 输入：numbers = [-1,0], target = -1
 * 输出：[1,2]
 * 解释：-1 与 0 之和等于目标数 -1 。因此 index1 = 1, index2 = 2 。返回 [1, 2] 。
 *
 *
 * 提示：
 *
 * 2 <= numbers.length <= 3 * 104
 * -1000 <= numbers[i] <= 1000
 * numbers 按 非递减顺序 排列
 * -1000 <= target <= 1000
 * 仅存在一个有效答案
 * @Date:9:59 2023/9/27
 */
public class twoSum {
    public static void main(String[] args) {
        twoSum twoSum = new twoSum();
        int[] ints = twoSum.twoSumⅡ(new int[]{2, 3, 4}, 6);
        System.out.println(Arrays.toString(ints));
    }
    public int[] twoSum(int[] numbers, int target){//时间复杂度 O(nlogn)
        for(int i=0;i<numbers.length;i++){
            int anIndex = searchIndex(numbers, target - numbers[i], i);
            if(anIndex!=-1){
                int[] result= new int[2];
                if(anIndex>i)
                    return new int[]{i+1,anIndex+1};
                return new int[]{anIndex+1,i+1};
            }

        }
        return null;
    }
    public int searchIndex(int[] numbers,int searchTarget,int nowIndex){
        int left=0,right= numbers.length-1;
        while (left<=right){
            int mid=(left+right)/2;
            if(numbers[mid]==searchTarget&&mid!=nowIndex)
                return mid;
            else if (numbers[mid]>searchTarget) {
                right=mid-1;
            }
            else
                left=mid+1;
        }
        return -1;
    }
    public int[] twoSumⅡ(int[] numbers, int target){
        int left=0,right=numbers.length-1;
        while (left<right){
            if(numbers[left]+numbers[right]==target)
                return new int[]{left+1,right+1};
            else if (numbers[left]+numbers[right]>target) right--;
            else left++;
        }
        return null;
    }
}