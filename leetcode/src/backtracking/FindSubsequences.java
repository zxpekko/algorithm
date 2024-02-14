package backtracking;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @Author:zxp
 * @Description:给你一个整数数组 nums ，找出并返回所有该数组中不同的递增子序列，递增子序列中 至少有两个元素 。你可以按 任意顺序 返回答案。
 *
 * 数组中可能含有重复元素，如出现两个整数相等，也可以视作递增序列的一种特殊情况。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [4,6,7,7]
 * 输出：[[4,6],[4,6,7],[4,6,7,7],[4,7],[4,7,7],[6,7],[6,7,7],[7,7]]
 * 示例 2：
 *
 * 输入：nums = [4,4,3,2,1]
 * 输出：[[4,4]]
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 15
 * -100 <= nums[i] <= 100
 * @Date:21:01 2024/1/8
 */
public class FindSubsequences {
    public static void main(String[] args) {
        FindSubsequences findSubsequences = new FindSubsequences();
        System.out.println(findSubsequences.findSubsequences(new int[]{4, 6, 7, 7}));
    }
    List<List<Integer>> result=new ArrayList<>();
    List<Integer> subResult=new ArrayList<>();
    public List<List<Integer>> findSubsequences(int[] nums){
        backtraking(nums,0);
        return result;
    }
    public void backtraking(int[] nums,int startIndex){
        if(subResult.size()>=2)
            result.add(new ArrayList<>(subResult));
        HashSet<Integer> record=new HashSet<>();//注意只记录这一层的情况，也就是说从这一层开始的数字，不能重复，否则是没有意义的。
        for(int i=startIndex;i<nums.length;i++){
            if((!subResult.isEmpty()&& subResult.get(subResult.size()-1)>nums[i])||record.contains(nums[i]))
                continue;
            record.add(nums[i]);
            subResult.add(nums[i]);
            backtraking(nums,i+1);
            subResult.remove(subResult.size()-1);
        }
    }
}
