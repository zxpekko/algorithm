package backtracking;

import java.net.Inet4Address;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author:zxp
 * @Description:给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 *
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,3]
 * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
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
 * nums 中的所有元素 互不相同
 * @Date:11:19 2024/1/8
 */
public class Subsets {
    public static void main(String[] args) {
        Subsets subsets = new Subsets();
        System.out.println(subsets.subsets(new int[]{1,2,5}));
    }
    public List<List<Integer>> subsets(int[] nums){
        List<List<Integer>> result=new ArrayList<>();
        List<Integer> subResult=new ArrayList<>();
        if(nums.length==0)
            return result;
        backtracking(nums,0,result,subResult);
        return result;
    }
    public void backtracking(int[] nums,int startIndex,List<List<Integer>> result,List<Integer> subResult){
        for(int i=0;i< nums.length;i++){
            if(subResult.size()==i)
                  result.add(new ArrayList<>(subResult));
        }
        if(subResult.size()== nums.length){
            result.add(new ArrayList<>(subResult));
            return;
        }
        for(int j=startIndex;j< nums.length;j++){
            subResult.add(nums[j]);
            backtracking(nums,j+1,result,subResult);
            subResult.remove(subResult.size()-1);
        }
    }
}
