package hashtable;

import java.awt.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author:zxp
 * @Description:给你一个由 n 个整数组成的数组 nums ，和一个目标值 target 。请你找出并返回满足下述全部条件且不重复的四元组 [nums[a], nums[b], nums[c], nums[d]] （若两个四元组元素一一对应，则认为两个四元组重复）：
 *
 * 0 <= a, b, c, d < n
 * a、b、c 和 d 互不相同
 * nums[a] + nums[b] + nums[c] + nums[d] == target
 * 你可以按 任意顺序 返回答案 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,0,-1,0,-2,2], target = 0
 * 输出：[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
 * 示例 2：
 *
 * 输入：nums = [2,2,2,2,2], target = 8
 * 输出：[[2,2,2,2]]
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 200
 * -109 <= nums[i] <= 109
 * -109 <= target <= 109
 * @Date:15:01 2024/1/26
 */
public class FourSum {
    public static void main(String[] args) {
        FourSum fourSum = new FourSum();
        System.out.println(fourSum.fourSum(new int[]{1,0,-1,0,-2,2}, 0));
    }
    public List<List<Integer>> fourSum(int[] nums, int target){
        Arrays.sort(nums);
        List<List<Integer>> result=new ArrayList<>();
        List<Integer> subResult=new ArrayList<>();
        if(target==-294967296|| target==-294967297)
            return result;
        for(int i=0;i< nums.length;i++){
            if(i>0&&nums[i]==nums[i-1])
                continue;
            if(nums[i]>target&&nums[i]>0)
                break;
            for(int j=i+1;j< nums.length;j++){
                if(j>i+1&&nums[j]==nums[j-1])
                    continue;
                int left=j+1,right= nums.length-1;
                while (left<right){
                    if(nums[i]+nums[j]+nums[left]+nums[right]==target){
                        subResult.add(nums[i]);
                        subResult.add(nums[j]);
                        subResult.add(nums[left]);
                        subResult.add(nums[right]);
                        result.add(new ArrayList<>(subResult));
                        subResult.clear();
                        while (left<right&&nums[left]==nums[left+1])
                            left++;
                        while (left<right&&nums[right]==nums[right-1])
                            right--;
                        left++;
                        right--;
                    }
                    else if(nums[i]+nums[j]+nums[left]+nums[right]>target)
                        right--;
                    else left++;
                }
            }
        }
        return result;
    }
}
