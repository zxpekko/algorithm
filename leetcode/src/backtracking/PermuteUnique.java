package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * @Author:zxp
 * @Description:给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,1,2]
 * 输出：
 * [[1,1,2],
 *  [1,2,1],
 *  [2,1,1]]
 * 示例 2：
 *
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 8
 * -10 <= nums[i] <= 10
 * @Date:16:38 2024/1/9
 */
public class PermuteUnique {
    public static void main(String[] args) {
        PermuteUnique permuteUnique = new PermuteUnique();
        System.out.println(permuteUnique.permuteUnique(new int[]{1,2,3,3}));
    }
    List<List<Integer>> result=new ArrayList<>();
    List<Integer> subResult=new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums){
        boolean[] used = new boolean[nums.length];
        backtracking(nums,used);
        return result;
    }
    public void backtracking(int[] nums,boolean[] used){
        if(subResult.size()== nums.length){
            result.add(new ArrayList<>(subResult));
            return;
        }
        HashSet<Integer> record=new HashSet<>();//记录当前层的使用情况，下一层又会重新实例化一个hashset的对象。
        for(int i=0;i< nums.length;i++){
            if(record.contains(nums[i])||used[i])//去重加不重复利用一个元素（指的是其中一个小解中，不能重复使用同一个值。）
                continue;
            subResult.add(nums[i]);
            record.add(nums[i]);
            used[i]=true;
            backtracking(nums,used);
            subResult.remove(subResult.size()-1);
            used[i]=false;
        }
    }
}
