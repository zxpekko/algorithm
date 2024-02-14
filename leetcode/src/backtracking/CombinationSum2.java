package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @Author:zxp
 * @Description:给定一个候选人编号的集合 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的每个数字在每个组合中只能使用 一次 。
 *
 * 注意：解集不能包含重复的组合。
 *
 *
 *
 * 示例 1:
 *
 * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 * 输出:
 * [
 * [1,1,6],
 * [1,2,5],
 * [1,7],
 * [2,6]
 * ]
 * 示例 2:
 *
 * 输入: candidates = [2,5,2,1,2], target = 5,
 * 输出:
 * [
 * [1,2,2],
 * [5]
 * ]
 *
 *
 * 提示:
 *
 * 1 <= candidates.length <= 100
 * 1 <= candidates[i] <= 50
 * 1 <= target <= 30
 * @Date:18:41 2024/1/5
 */
public class CombinationSum2 {
    public static void main(String[] args) {
        CombinationSum2 combinationSum2 = new CombinationSum2();
        System.out.println(combinationSum2.combinationSum2(new int[]{2,5,2,1,2}, 5));
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target){
        Arrays.sort(candidates);
        boolean[] record = new boolean[candidates.length];
        List<List<Integer>> result=new ArrayList<>();
        List<Integer> subResult=new ArrayList<>();
        if(candidates.length==0)
            return result;
        backtracking(candidates,target,0,result,subResult,record);
        return result;
    }
    public void backtracking(int[] candidates,int target,int startIndex,List<List<Integer>> result,List<Integer> subResult,boolean[] record){
        if(target==0) {
            result.add(new ArrayList<>(subResult));
            return;
        }
        if(target<0)
            return;
        for(int i=startIndex;i<candidates.length;i++){
            if(i>0&&candidates[i]==candidates[i-1]&& !record[i - 1])
                continue;//去重的关键部分，如果当前值和上一个值相等并且上一个值没有被使用，说明即将开启新的树枝，这时候是不允许的，因为当前值开始往后选择，
            // 是被之前那个值往后选择给包含了的，所以如果不停止就会出现重复解的现象。
            subResult.add(candidates[i]);
            record[i]=true;
            backtracking(candidates,target-candidates[i],i+1,result,subResult,record);
            subResult.remove(subResult.size()-1);
            record[i]=false;
        }
    }
}
