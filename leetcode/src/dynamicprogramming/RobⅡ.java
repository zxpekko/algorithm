package dynamicprogramming;

import java.util.Arrays;

/**
 * @Author:zxp
 * @Description:你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都 围成一圈 ，这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。
 *
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 在不触动警报装置的情况下 ，今晚能够偷窃到的最高金额。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [2,3,2]
 * 输出：3
 * 解释：你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。
 * 示例 2：
 *
 * 输入：nums = [1,2,3,1]
 * 输出：4
 * 解释：你可以先偷窃 1 号房屋（金额 = 1），然后偷窃 3 号房屋（金额 = 3）。
 *      偷窃到的最高金额 = 1 + 3 = 4 。
 * 示例 3：
 *
 * 输入：nums = [1,2,3]
 * 输出：3
 *
 * @Date:10:06 2023/12/7
 */
public class RobⅡ {
    public static void main(String[] args) {
        RobⅡ robⅡ = new RobⅡ();
        System.out.println(robⅡ.rob(new int[]{1,2,3}));
    }
    public int rob(int[] nums){
        int n=nums.length;
        int[] dp = new int[n];//dp[i]表示考虑到i号房间的最大偷窃金额
        for(int i=0;i<n;i++){
            if(i==0){//必然不偷第一间
                dp[i]=0;
            }
            else if(i==1){
                dp[i]=nums[i];
            }
            else {
                dp[i]=Math.max(nums[i]+dp[i-2],dp[i-1] );
            }
        }
        int result=dp[n-1];
        Arrays.fill(dp,0);
        for(int i=0;i<n;i++){
            if(i==0){
                dp[i]=nums[i];
            }
            else if(i==1){
                dp[i]=nums[i-1];
            }
            else if(i==n-1) {
                dp[i]=dp[i-1];
            }
            else {
                dp[i]=Math.max(nums[i]+dp[i-2],dp[i-1]);
            }
        }
        System.out.println(dp[n-1]);
        result=Math.max(result,dp[n-1]);
        return result;
    }
}
