package leetcode.binarysearch;

import java.lang.management.MonitorInfo;

/**
 * @Author:zxp
 * @Description:209
 * 给定一个含有 n 个正整数的数组和一个正整数 target 。
 *
 * 找出该数组中满足其总和大于等于 target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：target = 7, nums = [2,3,1,2,4,3]
 * 输出：2
 * 解释：子数组 [4,3] 是该条件下的长度最小的子数组。
 * 示例 2：
 *
 * 输入：target = 4, nums = [1,4,4]
 * 输出：1
 * 示例 3：
 *
 * 输入：target = 11, nums = [1,1,1,1,1,1,1,1]
 * 输出：0
 *
 *
 * 提示：
 *
 * 1 <= target <= 109
 * 1 <= nums.length <= 105
 * 1 <= nums[i] <= 105
 *
 * @Date:10:01 2023/10/7
 */
public class MinSubArrayLen {
    public static void main(String[] args) {
        MinSubArrayLen minSubArrayLen = new MinSubArrayLen();
        System.out.println(minSubArrayLen.minSubArrayLen(11, new int[]{1,2,3,4,5}));
    }
    public int minSubArrayLen(int target, int[] nums){
        int min=Integer.MAX_VALUE;
//        int left=0,right=left+1;
        int left=0,right=left+1;
        int sum=nums[left];
        for(left=0;left< nums.length;left++){
//            int right=left+1;
            while (sum<target&&right< nums.length){
                sum+=nums[right];
                right++;
            }
            if(sum>=target)
                min=Math.min(min,right-left);
            sum-=nums[left];
        }
        if(min==Integer.MAX_VALUE)
            return 0;
        return min;
    }
}
