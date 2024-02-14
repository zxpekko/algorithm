package dynamicprogramming;

import java.util.Arrays;

/**
 * @Author:zxp
 * @Description:给你一个整数数组 nums，返回 nums 中最长等差子序列的长度。
 *
 * 回想一下，nums 的子序列是一个列表 nums[i1], nums[i2], ..., nums[ik] ，且 0 <= i1 < i2 < ... < ik <= nums.length - 1。并且如果 seq[i+1] - seq[i]( 0 <= i < seq.length - 1) 的值都相同，那么序列 seq 是等差的。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [3,6,9,12]
 * 输出：4
 * 解释：
 * 整个数组是公差为 3 的等差数列。
 * 示例 2：
 *
 * 输入：nums = [9,4,7,2,10]
 * 输出：3
 * 解释：
 * 最长的等差子序列是 [4,7,10]。
 * 示例 3：
 *
 * 输入：nums = [20,1,15,3,10,5,8]
 * 输出：4
 * 解释：
 * 最长的等差子序列是 [20,15,10,5]。
 *
 *
 * 提示：
 *
 * 2 <= nums.length <= 1000
 * 0 <= nums[i] <= 500
 * @Date:9:26 2023/11/13
 */
public class LongestArithSeqLength {
    public static void main(String[] args) {
        LongestArithSeqLength longestArithSeqLength = new LongestArithSeqLength();
        System.out.println(longestArithSeqLength.longestArithSeqLength(new int[]{20,1,15,3,10,5,8}));
    }
    public int longestArithSeqLength(int[] nums){//动态规划，dp[i][j]代表以nums[i],num[j]作为末尾两项。
        int[][] dp = new int[nums.length][nums.length];//dp数组
        for(int m=0;m<dp.length;m++){
            Arrays.fill(dp[m],2);
        }
        int res=2;
        for(int i=0;i< nums.length;i++){
            for(int j=i+1;j< nums.length;j++){
                int gap=nums[j]-nums[i];
                int pre=nums[i]-gap;
                int flag=0;
                int k;
                for(k=i-1;k>=0;k--){
                    if(nums[k]==pre){
                        flag=1;
                        break;
                    }
                }
                if(flag==1)
                    dp[i][j]=Integer.max(dp[i][j],dp[k][i]+1);
                res=Integer.max(res,dp[i][j]);
            }
        }
        return res;
    }
}