package leetcode;

/**
 * @Author:zxp
 * @Description:给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。
 *
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 *
 * 你必须设计并实现时间复杂度为 O(log n) 的算法解决此问题。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [5,7,7,8,8,10], target = 8
 * 输出：[3,4]
 * 示例 2：
 *
 * 输入：nums = [5,7,7,8,8,10], target = 6
 * 输出：[-1,-1]
 * 示例 3：
 *
 * 输入：nums = [], target = 0
 * 输出：[-1,-1]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/find-first-and-last-position-of-element-in-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date:20:51 2023/7/20
 */
public class SearchRange {
    public static void main(String[] args) {
        int[] nums={5,7,7,8,8,10};
        SearchRange searchRange = new SearchRange();
        for (int i : searchRange.searchRange(nums, 6)) {
            System.out.println(i);
        }

    }
    public int[] searchRange(int[] nums, int target){
        int[] res = new int[2];
        if(SearchMid(nums,target,0, nums.length-1)==-1){
            res[0]=-1;
            res[1]=-1;
            return res;
        }
        else {
            int mid=SearchMid(nums,target,0, nums.length-1);
            res[0]=res[1]=mid;
            while(SearchMid(nums,target,0,mid-1)!=-1){
                mid=SearchMid(nums,target,0,mid-1);
            }
            res[0]=mid;
            while (SearchMid(nums,target,mid+1, nums.length-1)!=-1){
                mid=SearchMid(nums,target,mid+1, nums.length-1);
            }
            res[1]=mid;
        }
        return res;
    }
    public int SearchMid(int[] subNums,int target,int l,int r){
        while(l<=r){
            int mid=(l+r)/2;
            if(subNums[mid]==target)
                return mid;
            else if(subNums[mid]<target){
                l=mid+1;
            }
            else
                r=mid-1;
        }
        return -1;
    }
}
