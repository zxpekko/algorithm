package leetcode;

/**
 * @Author:zxp
 * @Description:你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 *
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
 *
 *
 *
 * 示例 1：
 *
 * 输入：[1,2,3,1]
 * 输出：4
 * 解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
 *      偷窃到的最高金额 = 1 + 3 = 4 。
 * 示例 2：
 *
 * 输入：[2,7,9,3,1]
 * 输出：12
 * 解释：偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
 *      偷窃到的最高金额 = 2 + 9 + 1 = 12 。
 * @Date:10:12 2023/8/5
 */
public class RobMoney {
    public static void main(String[] args) {
           int[] nums={2,7,9,3,1};
        RobMoney robMoney = new RobMoney();
        int rob = robMoney.rob(nums);
        System.out.println(rob);
    }
    public int rob(int[] nums) {//dp[i]表示以下标为i的元素结尾的子数组的最大偷窃金额。
        int[] dp=new int[nums.length];
        for(int i=0;i< nums.length;i++){
            if(i==0)
                dp[i]=nums[i];
            else if(i==1){
                dp[i]=Math.max(nums[i-1],nums[i]);
            }
            else {
                dp[i]=Math.max(nums[i]+dp[i-2],dp[i-1] );
            }
        }
        return dp[dp.length-1];
    }
}
