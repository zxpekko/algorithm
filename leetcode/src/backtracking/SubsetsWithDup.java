package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author:zxp
 * @Description:给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。
 *
 * 解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,2]
 * 输出：[[],[1],[1,2],[1,2,2],[2],[2,2]]
 * 示例 2：
 *
 * 输入：nums = [0]
 * 输出：[[],[0]]
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 10
 * -10 <= nums[i] <= 10
 * @Date:15:02 2024/1/8
 */
public class SubsetsWithDup {
    public static void main(String[] args) {
        SubsetsWithDup subsetsWithDup = new SubsetsWithDup();
        System.out.println(subsetsWithDup.subsetsWithDup(new int[]{4,4,4,1,4}));
    }
    public List<List<Integer>> subsetsWithDup(int[] nums){
        Arrays.sort(nums);
        List<List<Integer>> result=new ArrayList<>();
        List<Integer> subResult=new ArrayList<>();
        boolean[] record = new boolean[nums.length];
        if(nums.length==0)
            return result;
        backtracking(nums,0,result,subResult,record);
        return result;
    }
    public void backtracking(int[] nums,int startIndex,List<List<Integer>> result,List<Integer> subResult,boolean[] record){
        for(int i=0;i<nums.length;i++){
            if(subResult.size()==i)
                result.add(new ArrayList<>(subResult));
        }
        if(subResult.size()==nums.length){
            result.add(new ArrayList<>(subResult));
            return;
        }
        for(int j=startIndex;j<nums.length;j++){
            if(j>startIndex&&nums[j]==nums[j-1]&&!record[j-1])//去重逻辑
                continue;
            subResult.add(nums[j]);
            record[j]=true;
            backtracking(nums,j+1,result,subResult,record);
            subResult.remove(subResult.size()-1);
            record[j]=false;
        }
    }
}
