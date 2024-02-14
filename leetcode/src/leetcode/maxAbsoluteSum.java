package leetcode;

/**
 * @Author:zxp
 * @Description:给你一个整数数组 nums 。一个子数组 [numsl, numsl+1, ..., numsr-1, numsr] 的 和的绝对值 为 abs(numsl + numsl+1 + ... + numsr-1 + numsr) 。
 *
 * 请你找出 nums 中 和的绝对值 最大的任意子数组（可能为空），并返回该 最大值 。
 *
 * abs(x) 定义如下：
 *
 * 如果 x 是负整数，那么 abs(x) = -x 。
 * 如果 x 是非负整数，那么 abs(x) = x 。
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,-3,2,3,-4]
 * 输出：5
 * 解释：子数组 [2,3] 和的绝对值最大，为 abs(2+3) = abs(5) = 5 。
 * 示例 2：
 *
 * 输入：nums = [2,-5,1,-4,3,-2]
 * 输出：8
 * 解释：子数组 [-5,1,-4] 和的绝对值最大，为 abs(-5+1-4) = abs(-8) = 8 。
 * @Date:13:04 2023/8/8
 */
public class maxAbsoluteSum{
    public static void main(String[] args) {
        int[] nums={2,-5,1,-4,3,-2};
        maxAbsoluteSum maxAbsoluteSum = new maxAbsoluteSum();
        int i = maxAbsoluteSum.maxAbsoluteSum(nums);
        System.out.println(i);

    }
//    public int maxAbsoluteSum(int[] nums){//目前动态规划
//        int[] dpMax=new int[nums.length];//dpMax[i]定义为以下标i的元素结尾的情况的子数组最大的值。
//        int[] dpMin=new int[nums.length];//dpMax[i]定义为以下标i的元素结尾的情况的子数组最小的值。
//
//        for(int i=0;i< nums.length;i++){
//            if(i==0){
//                dpMax[i]=nums[i];
//            }
//            else {
//                dpMax[i]=Math.max(dpMax[i-1]+nums[i],nums[i]);
//            }
//        }
//        for(int i=0;i< nums.length;i++){
//            if(i==0){
//                dpMin[i]=nums[i];
//            }
//            else {
//                dpMin[i]=Math.min(dpMin[i-1]+nums[i],nums[i]);
//            }
//        }
//        int DPMAX=dpMax[0];
//        int DPMIN=dpMin[0];
//        for(int i=1;i< dpMax.length;i++){
//            if(dpMax[i]>DPMAX)
//                DPMAX=dpMax[i];
//        }
//        for(int i=1;i< dpMin.length;i++){
//            if(dpMin[i]<DPMIN)
//                DPMIN=dpMin[i];
//        }
//        DPMAX=Math.abs(DPMAX);
//        DPMIN=Math.abs(DPMIN);
//
//        return Math.max(DPMAX,DPMIN);
//    }
    public int maxAbsoluteSum(int[] nums){//目前动态规划,相比上面的方法内存更优，只创建了一个长度为nums.length的dp数组。
        int[] dp=new int[nums.length];//dpMax[i]定义为以下标i的元素结尾的情况的子数组最大或者最小的值。
        for(int i=0;i< nums.length;i++){
            if(i==0){
                dp[i]=nums[i];
            }
            else {
                dp[i]=Math.max(dp[i-1]+nums[i],nums[i]);
            }
        }
        int DPMAX=dp[0];
        for(int i=1;i< dp.length;i++){
            if(dp[i]>DPMAX)
                DPMAX=dp[i];
        }
        for(int i=0;i< dp.length;i++){
            dp[i]=0;
        }
        for(int i=0;i< nums.length;i++){
            if(i==0){
                dp[i]=nums[i];
            }
            else {
                dp[i]=Math.min(dp[i-1]+nums[i],nums[i]);
            }
        }

        int DPMIN=dp[0];

        for(int i=1;i< dp.length;i++){
            if(dp[i]<DPMIN)
                DPMIN=dp[i];
        }
        DPMAX=Math.abs(DPMAX);
        DPMIN=Math.abs(DPMIN);

        return Math.max(DPMAX,DPMIN);
    }
}