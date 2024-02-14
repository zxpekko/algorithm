package leetcode;

/**
 * @Author:zxp
 * @Description:给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 *
 * 请必须使用时间复杂度为 O(log n) 的算法。
 *
 *
 *
 * 示例 1:
 *
 * 输入: nums = [1,3,5,6], target = 5
 * 输出: 2
 * 示例 2:
 *
 * 输入: nums = [1,3,5,6], target = 2
 * 输出: 1
 * 示例 3:
 *
 * 输入: nums = [1,3,5,6], target = 7
 * 输出: 4
 *
 * @Date:16:54 2023/8/31
 */
public class SearchInsert {
    public static void main(String[] args) {
        int[] nums={1,3,5,6};
        SearchInsert searchInsert = new SearchInsert();
        System.out.println(searchInsert.searchInsert(nums, 7));
    }
    public int searchInsert(int[] nums, int target) {
        int low=0;
        int high= nums.length-1;
        int targetIndex=-1;
        while(low<=high){
//            System.out.println(1);
            int mid=(low+high)/2;
            if(nums[mid]==target)
            {
                targetIndex=mid;
                break;
            }

            else if(nums[mid]<target)
                low=mid+1;
            else
                high=mid-1;
        }
        if(targetIndex!=-1)
            return targetIndex;
        else {
            if(low== nums.length)
                return nums.length;
            else if(high==-1)
                return 0;
            else
                return low;
        }
    }

}
