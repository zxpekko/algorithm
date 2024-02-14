package dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author:zxp
 * @Description:
 * @Date:13:53 2023/2/27
 */
public class PermutationⅡOptimize {
    public static void main(String[] args) {
        int[] ints = {1, -1, 1, 2, -1, 2, 2, 8, 9};
        PermutationⅡOptimize permutationⅡOptimize = new PermutationⅡOptimize();
        List<List<Integer>> list = permutationⅡOptimize.pemuteUnique(ints);
        System.out.println(list);
    }
    boolean[] vis;

    public List<List<Integer>> pemuteUnique(int[] nums){
        List<List<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> perm = new ArrayList<>();
        Arrays.sort(nums);
        vis = new boolean[nums.length];
        backtrace(nums,ans,perm,0);
        return ans;
    }
    public void backtrace(int[] nums, List<List<Integer>> ans,List<Integer> perm,int idx){
        if(idx==nums.length){
            ans.add(new ArrayList(perm));
        }
        else{
            for(int i=0;i<nums.length;i++){
                if(vis[i]==true||(i>0&&nums[i-1]==nums[i]&&vis[i-1]==false))
                    continue;
                else{
                    perm.add(nums[i]);
                    vis[i]=true;
                    backtrace(nums,ans,perm,idx+1);
                    vis[i]=false;
                    perm.remove(idx);
                }
            }
        }

    }
}
