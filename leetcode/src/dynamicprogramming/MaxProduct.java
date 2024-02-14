package dynamicprogramming;

/**
 * @Author:zxp
 * @Description: 152
 *
 * 给你一个整数数组 nums ，请你找出数组中乘积最大的非空连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
 *
 * 测试用例的答案是一个 32-位 整数。
 *
 * 子数组 是数组的连续子序列。
 *
 *
 *
 * 示例 1:
 *
 * 输入: nums = [2,3,-2,4]
 * 输出: 6
 * 解释: 子数组 [2,3] 有最大乘积 6。
 * 示例 2:
 *
 * 输入: nums = [-2,0,-1]
 * 输出: 0
 * 解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
 *
 *
 * 提示:
 *
 * 1 <= nums.length <= 2 * 104
 * -10 <= nums[i] <= 10
 * nums 的任何前缀或后缀的乘积都 保证 是一个 32-位 整数
 * @Date:8:58 2023/9/18
 */
public class MaxProduct {
    public static void main(String[] args) {
        MaxProduct maxProduct = new MaxProduct();
        System.out.println(maxProduct.maxProduct(new int[]{2, 3, -2, 4}));
    }
//    public int maxProduct(int[] nums){
//        int[] dp = new int[nums.length];//dp[i]代表以下标为i的元素结尾的最大连续子数组的乘积
////        dp[0]=nums[0];
//        for(int i=0;i<dp.length;i++){
//            if(i==0)
//                dp[i]=nums[0];
//            else dp[i]=Math.max(nums[i],dp[i-1]*nums[i] );
//        }
//        int maxProduct=dp[0];
//        for(int i=0;i< dp.length;i++){
//            if(dp[i]>maxProduct)
//                maxProduct=dp[i];
//        }
//        return maxProduct;
//    }
     public int maxProduct(int[] nums){
        int curMax=nums[0];//以nums[i]结尾的最大乘积。
        int curMin=nums[0];
        if(nums.length==1)
            return nums[0];
        int maxResult=nums[0];
        for(int i=1;i< nums.length;i++){
            if(nums[i]<0){
                int temp=curMax;
                curMax=curMin;
                curMin=temp;
            }
            curMax=Math.max(nums[i],nums[i]*curMax );
            curMin=Math.min(nums[i],nums[i]*curMin );
            maxResult=Math.max(maxResult,curMax);
        }
        return maxResult;
     }


}
