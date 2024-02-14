package dynamicprogramming;

/**
 * @Author:zxp
 * @Description:给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 子数组 是数组中的一个连续部分。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出：6
 * 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
 * 示例 2：
 *
 * 输入：nums = [1]
 * 输出：1
 * 示例 3：
 *
 * 输入：nums = [5,4,-1,7,8]
 * 输出：23
 * @Date:20:13 2023/11/20
 */
public class maxSubArray {
    public static void main(String[] args) {
        maxSubArray maxSubArray = new maxSubArray();
        System.out.println(maxSubArray.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        System.out.println(maxSubArray.maxSubArrayⅡ(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }
    public int maxSubArray(int[] nums){
        int n= nums.length;
        int[] dp = new int[n];//动态规划，dp[i]的含义是以nums[i]结尾的最大子数组的和
        for(int i=0;i<n;i++){
            if(i==0)
                dp[i]=nums[i];
            else
                dp[i]=Math.max(nums[i],dp[i-1]+nums[i] );
        }
        int result=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            if(dp[i]>result)
                result=dp[i];
        }
        return result;
    }
    public int maxSubArrayⅡ(int[] nums){
        int n= nums.length;
        int[] dp = new int[n];//dp[i]表示以i下标的数字结尾的最大子数组和
        dp[0]=nums[0];
        for(int i=1;i<n;i++){
            dp[i]=Math.max(nums[i],dp[i-1]+nums[i]);
        }
        int max=0;
        for(int i=0;i<n;i++){
            max=Math.max(max,dp[i]);
        }
        return max;
    }
}
