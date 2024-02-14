package backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @Author:zxp
 * @Description:给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * 示例 2：
 *
 * 输入：nums = [0,1]
 * 输出：[[0,1],[1,0]]
 * 示例 3：
 *
 * 输入：nums = [1]
 * 输出：[[1]]
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 6
 * -10 <= nums[i] <= 10
 * nums 中的所有整数 互不相同
 * @Date:15:25 2024/1/9
 */
public class Permute {
    public static void main(String[] args) {
        Permute permute = new Permute();
        System.out.println(permute.permute(new int[]{}));
    }
    List<List<Integer>> result=new ArrayList<>();
    List<Integer> subResult=new ArrayList<>();
    HashSet<Integer> record=new HashSet<>();

    public List<List<Integer>> permute(int[] nums){
        backtracking(nums,0);
        return result;
    }
    public void backtracking(int[] nums,int startIndex){
        if(subResult.size()== nums.length){
            result.add(new ArrayList<>(subResult));
            return;
        }
        for(int i=startIndex;i<nums.length;i++){
            if(record.contains(nums[i]))
                continue;
            subResult.add(nums[i]);
            record.add(nums[i]);
            backtracking(nums,startIndex);
            subResult.remove(subResult.size()-1);
            record.remove(nums[i]);
        }
    }
}
