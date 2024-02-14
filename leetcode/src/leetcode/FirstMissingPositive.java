package leetcode;

/**
 * @Author:zxp
 * @Description:给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。
 *
 * 请你实现时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案。
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,0]
 * 输出：3
 * 示例 2：
 *
 * 输入：nums = [3,4,-1,1]
 * 输出：2
 * 示例 3：
 *
 * 输入：nums = [7,8,9,11,12]
 * 输出：1
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 5 * 105
 * -231 <= nums[i] <= 231 - 1
 * @Date:11:18 2023/11/8
 */
public class FirstMissingPositive {
    public static void main(String[] args) {
        FirstMissingPositive firstMissingPositive = new FirstMissingPositive();
        System.out.println(firstMissingPositive.firstMissingPositive(new int[]{1,2,4}));
    }
    public int firstMissingPositive(int[] nums){
        int[] record = new int[nums.length];
        int n= nums.length;
        for(int i=0;i<n;i++){
            if(nums[i]>=1&&nums[i]<=n){
                record[nums[i]-1]=1;
            }
        }
        int i;
        for( i=0;i<n;i++){
            if(record[i]==0)
                break;
        }
//        if(i<n)
//            return i+1;
        return i+1;
    }

}
