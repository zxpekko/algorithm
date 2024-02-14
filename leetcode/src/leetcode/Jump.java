package leetcode;

/**
 * @Author:zxp
 * @Description:给定一个长度为 n 的 0 索引整数数组 nums。初始位置为 nums[0]。
 *
 * 每个元素 nums[i] 表示从索引 i 向前跳转的最大长度。换句话说，如果你在 nums[i] 处，你可以跳转到任意 nums[i + j] 处:
 *
 * 0 <= j <= nums[i]
 * i + j < n
 * 返回到达 nums[n - 1] 的最小跳跃次数。生成的测试用例可以到达 nums[n - 1]。
 *
 *
 *
 * 示例 1:
 *
 * 输入: nums = [2,3,1,1,4]
 * 输出: 2
 * 解释: 跳到最后一个位置的最小跳跃数是 2。
 *      从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
 * 示例 2:
 *
 * 输入: nums = [2,3,0,1,4]
 * 输出: 2
 *
 *
 * 提示:
 *
 * 1 <= nums.length <= 104
 * 0 <= nums[i] <= 1000
 * 题目保证可以到达 nums[n-1]
 * @Date:10:00 2023/9/13
 */
public class Jump {
    public static void main(String[] args) {
        Jump jump = new Jump();
        System.out.println(jump.jump(new int[]{2, 3, 0, 1, 4}));
    }
    public int jump(int[] nums){
//        if(nums.length==1)
//            return 0;
//        int minSteps=0;
//        int maxDistance=0;
//        for(int i=0;i<nums.length;i++){
//            if(i<=maxDistance){
//                minSteps++;
//                maxDistance=Math.max(maxDistance,i+nums[i]);
//            }
//            if(maxDistance>= nums.length-1)
//                return minSteps;
//
//        }
//        return 0;
        int position= nums.length-1;
        int steps=0;
        while (position>0){
            for(int i=0;i< nums.length;i++){
                if(i+ nums[i]>=position){
                    position=i;
                    steps++;
                    break;
                }
            }
        }
        return steps;
    }
}
