package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @Author:zxp
 * @Description:给定一个候选人编号的集合 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的每个数字在每个组合中只能使用 一次 。
 *
 * 注意：解集不能包含重复的组合。 
 *
 *  
 *
 * 示例 1:
 *
 * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 * 输出:
 * [
 * [1,1,6],
 * [1,2,5],
 * [1,7],
 * [2,6]
 * ]
 * 示例 2:
 *
 * 输入: candidates = [2,5,2,1,2], target = 5,
 * 输出:
 * [
 * [1,2,2],
 * [5]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/combination-sum-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date:14:15 2023/7/25
 */
public class CombinationSumⅡ {
    public static void main(String[] args) {
        int[] candidates={10,1,2,7,6,1,5};
        CombinationSumⅡ combinationSumⅡ = new CombinationSumⅡ();
        List<List<Integer>> list = combinationSumⅡ.combinationSum2(candidates, 8);
        System.out.println(list);
    }
    List<List<Integer>> res=new ArrayList<>();
    List<Integer> list=new ArrayList<>();
    List<int[]> freq=new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target){
        Arrays.sort(candidates);
        for(int num:candidates){
            int size= freq.size();
            if(freq.isEmpty()||num!=freq.get(size-1)[0]){
                freq.add(new int[]{num,1});
            }
            else {
                ++freq.get(size-1)[1];
            }
        }
        dfs(0,target);
//        dfs(candidates,target,res,list,0);
        return res;
    }
    public void dfs(int pos,int rest){
        if(rest==0){
            res.add(new ArrayList<>(list));
            return;
        }
        if(pos== freq.size()||rest<freq.get(pos)[0]){
            return;
        }
        dfs(pos+1,rest);
        int most= Math.min(rest/freq.get(pos)[0],freq.get(pos)[1]);
        for(int i=1;i<=most;i++){
            list.add(freq.get(pos)[0]);
            dfs(pos+1,rest-i*freq.get(pos)[0]);
        }

        for(int i=1;i<=most;i++){
            int size= list.size();
            list.remove(size-1);
        }

    }
//    public void dfs(int[] candidates,int target,List<List<Integer>> res,List<Integer> list,int idx){//此方法行不通
//        if(idx== candidates.length){
//            return;
//        }
//        if(target==0){
//            res.add(new ArrayList<>(list));
//            return;
//        }
//        dfs(candidates,target,res,list,idx+1);
//        if(target-candidates[idx]>=0){
//            list.add(candidates[idx]);
//            dfs(candidates,target-candidates[idx],res,list,idx+1);
//            list.remove(list.size()-1);
//        }
//    }

}
