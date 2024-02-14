package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author:zxp
 * @Description:给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
 *
 * 你可以按 任何顺序 返回答案。
 *
 *
 *
 * 示例 1：
 *
 * 输入：n = 4, k = 2
 * 输出：
 * [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4],
 * ]
 * 示例 2：
 *
 * 输入：n = 1, k = 1
 * 输出：[[1]]
 * @Date:20:18 2023/8/14
 */
public class Combinations {
    public static void main(String[] args) {
        Combinations combinations = new Combinations();
        List<List<Integer>> combine = combinations.combine(4, 2);
        System.out.println(combine);
    }

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result=new ArrayList<>();
        List<Integer> currentResult=new ArrayList<>();
        dfs(1,n,k,result,currentResult);
        return result;
    }
    public void dfs(int current,int n,int k,List<List<Integer>> result,List<Integer> currentResult){
//        if(current==n+1)
//            return;
        if(currentResult.size()+(n-current+1)<k)
            return;
        if(currentResult.size()==k){
            result.add(new ArrayList<>(currentResult));
            return;
        }

        currentResult.add(current);
        dfs(current+1,n,k,result,currentResult);
        int index=currentResult.size()-1;
        currentResult.remove(index);
        dfs(current+1,n,k,result,currentResult);
    }
}
