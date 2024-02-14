package leetcode.binarysearch;

/**
 * @Author:zxp
 * @Description:已知存在一个按非降序排列的整数数组 nums ，数组中的值不必互不相同。
 *
 * 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转 ，使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。例如， [0,1,2,4,4,4,5,6,6,7] 在下标 5 处经旋转后可能变为 [4,5,6,6,7,0,1,2,4,4] 。
 *
 * 给你 旋转后 的数组 nums 和一个整数 target ，请你编写一个函数来判断给定的目标值是否存在于数组中。如果 nums 中存在这个目标值 target ，则返回 true ，否则返回 false 。
 *
 * 你必须尽可能减少整个操作步骤。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [2,5,6,0,0,1,2], target = 0
 * 输出：true
 * 示例 2：
 *
 * 输入：nums = [2,5,6,0,0,1,2], target = 3
 * 输出：false
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 5000
 * -104 <= nums[i] <= 104
 * 题目数据保证 nums 在预先未知的某个下标上进行了旋转
 * -104 <= target <= 104
 * @Date:10:21 2023/9/21
 */
public class SearchⅡ {
    public static void main(String[] args) {
        SearchⅡ searchⅡ = new SearchⅡ();
        System.out.println(searchⅡ.search(new int[]{1,1}, 0));
    }
    public boolean search(int[] nums, int target){
        if(nums.length==1)
            return nums[0]==target;
        int i;
        for(i=0;i< nums.length-1;i++){
            if(nums[i+1]<nums[i])
                break;
        }
        int start=i+1;
        int left=0,right= nums.length-1;
        while (left<=right){
            int mid=(left+right)/2;
            int trueMid=mid+start;
            if(trueMid> nums.length-1){
                int over=trueMid-(nums.length-1);
                trueMid=over-1;
            }
            if(nums[trueMid]==target)
                return true;
            else if (nums[trueMid]>target)
                right=mid-1;
            else
                left=mid+1;
        }
        return false;
    }
}
