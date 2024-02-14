package dynamicprogramming;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Author:zxp
 * @Description:
 * @Date:11:50 2023/11/28
 */
public class CanPartition {
    public static void main(String[] args) {
        CanPartition canPartition = new CanPartition();
        System.out.println(canPartition.canPartitionⅡ(new int[]{1, 5,11,5}));
    }
    List<Integer> subResult=new ArrayList<>();
    List<List<Integer>> result=new ArrayList<>();
    public boolean canPartition(int[] nums){
        int sum=0;
        for(int i=0;i< nums.length;i++){
            sum+=nums[i];
        }
        if(sum%2==1)
            return false;
        int target=sum/2;
        dfs(target,nums,0,subResult,result);
        System.out.println(result);
        if(result.size()>0)
            return true;
        else
            return false;
    }
    public void dfs(int target,int[] nums,int start,List<Integer> subResult,List<List<Integer>> result){
          if(target==0){
              result.add(new ArrayList<>(subResult));
              return;
          }
          if(start>= nums.length)
              return;
          dfs(target,nums,start+1,subResult,result);
          if(target-nums[start]>=0){
              subResult.add(nums[start]);
              dfs(target-nums[start],nums,start+1,subResult,result);
              subResult.remove(subResult.size()-1);
          }
    }
    public boolean canPartitionⅡ(int[] nums){//考虑背包问题的应用
        //weight和value都是这个nums，最终目标是dp[target]==target，装满大小为target的背包的最大价值，如果能到target，说明正好装满。
        int n= nums.length;
        int sum=0;
        for(int i=0;i<n;i++){
            sum+=nums[i];
        }
        int target=sum/2;
        if(sum%2==1)
            return false;
        int[] dp = new int[target+1];
        for(int i=0;i<n;i++){
            for(int j=target;j>=nums[i];j--){
                dp[j]=Math.max(dp[j],dp[j-nums[i]]+nums[i]);
            }
        }
        if(dp[target]==target)
            return true;
        return false;
    }
}
