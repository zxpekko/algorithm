package leetcode.binarysearch;

/**
 * @Author:zxp
 * @Description:540
 *
 * 给你一个仅由整数组成的有序数组，其中每个元素都会出现两次，唯有一个数只会出现一次。
 *
 * 请你找出并返回只出现一次的那个数。
 *
 * 你设计的解决方案必须满足 O(log n) 时间复杂度和 O(1) 空间复杂度。
 *
 *
 *
 * 示例 1:
 *
 * 输入: nums = [1,1,2,3,3,4,4,8,8]
 * 输出: 2
 * 示例 2:
 *
 * 输入: nums =  [3,3,7,7,10,11,11]
 * 输出: 10
 *
 *
 * 提示:
 *
 * 1 <= nums.length <= 105
 * 0 <= nums[i] <= 105
 * @Date:19:43 2023/10/17
 */
public class SingleNonDuplicate {
    public static void main(String[] args) {
        SingleNonDuplicate singleNonDuplicate = new SingleNonDuplicate();
        System.out.println(singleNonDuplicate.singleNonDuplicateⅢ(new int[]{1,1,2,2,3}));
    }
    public int singleNonDuplicate(int[] nums){
        if(nums.length==1)
            return nums[0];
        int n= nums.length;
        int left=0,right=n-1;
        while (left<=right){
            int mid=left+((right-left)>>1);
            if(mid-1>=0&&nums[mid-1]==nums[mid]){
                if(mid!=left&&(mid-left)%2==0)
                    right=mid-1;
//                else if()
                else
                    left=mid+1;
            }
            else if(mid+1<n&&nums[mid+1]==nums[mid]){
                if((right-mid)%2==0)
                    left=mid+1;
                else
                    right=mid-1;
            }
            else
                return nums[mid];
        }
        return 0;
    }
    public int singleNonDuplicateⅡ(int[] nums){
        int sum=0;
        for(int i=0;i< nums.length;i++){
            sum^=nums[i];
        }
        return sum;
    }
    public int singleNonDuplicateⅢ(int[] nums){
        int low=0,high= nums.length-1;
        while (low<high){
            int mid=low+((high-low)>>2);
            if((mid%2==0&&nums[mid]==nums[mid+1])||(mid%2==1&&nums[mid]==nums[mid-1]))
                low=mid+1;
            else
                high=mid;
        }
        return nums[low];
    }
}