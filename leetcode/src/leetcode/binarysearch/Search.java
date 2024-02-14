package leetcode.binarysearch;

/**
 * @Author:zxp
 * @Description:33
 *
 * 整数数组 nums 按升序排列，数组中的值 互不相同 。
 *
 * 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。例如， [0,1,2,4,5,6,7] 在下标 3 处经旋转后可能变为 [4,5,6,7,0,1,2] 。
 *
 * 给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回 -1 。
 *
 * 你必须设计一个时间复杂度为 O(log n) 的算法解决此问题。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [4,5,6,7,0,1,2], target = 0
 * 输出：4
 * 示例 2：
 *
 * 输入：nums = [4,5,6,7,0,1,2], target = 3
 * 输出：-1
 * 示例 3：
 *
 * 输入：nums = [1], target = 0
 * 输出：-1
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 5000
 * -104 <= nums[i] <= 104
 * nums 中的每个值都 独一无二
 * 题目数据保证 nums 在预先未知的某个下标上进行了旋转
 * -104 <= target <= 104
 * @Date:12:13 2023/9/20
 */
public class Search {
    public static void main(String[] args) {
        Search search = new Search();
        System.out.println(search.search(new int[]{2,3,4,5,1}, 1));
    }
    public int search(int[] nums, int target){//定位原数组中的第一位数，再二分，时间复杂度次于下方给出的直接二分
//        int i;
//        for(i=0;i< nums.length;i++){
//            if(nums[i+1]<nums[i])
//                break;
//        }
//        int start=i+1;
//        int[] newNums = new int[nums.length];
//        int j=0;
//        for(i=start;i< newNums.length;i++){
//            newNums[j]=nums[i];
//            j++;
//        }
//        for(i=0;i<start;i++){
//            newNums[j]=nums[i];
//            j++;
//        }
        int i=0,j= nums.length-1;
        while (i<j){
            if(nums[i]>nums[j]){
                i++;
                j--;
            }
            else
                break;
        }
        int start=0;
        if(i==j){
            if(i+1<= nums.length-1&&nums[i+1]<nums[i])
                start=i+1;
            else
                start=i;
        }
        if(i<j){
            if(j+1<= nums.length-1&&j-1>=0&&nums[j]>nums[j+1]&&nums[j]>nums[j-1])
                start=j+1;
            else
                start=i;
        }
        if(i>j){
            start=i;
        }
//        System.out.println(start);
        int left=0,right= nums.length-1;
        while (left<=right){
            int mid=(left+right)/2;
            int trueMid=mid+start;
            if(trueMid> nums.length-1){
                int over=trueMid-(nums.length-1);
                trueMid=over-1;
            }
            if(nums[trueMid]==target)
                return trueMid;
            else if(nums[trueMid]>target){
                right=mid-1;
            }
            else
                left=mid+1;
        }
        return -1;
    }
    public int searchOfficial(int[] nums, int target){//官方题解，直接二分

        return -1;
    }

}