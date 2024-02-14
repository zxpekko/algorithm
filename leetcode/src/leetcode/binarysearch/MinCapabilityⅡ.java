package leetcode.binarysearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author:zxp
 * @Description:2560
 *
 * 街有一排连续的房屋。每间房屋内都藏有一定的现金。现在有一位小偷计划从这些房屋中窃取现金。
 *
 * 由于相邻的房屋装有相互连通的防盗系统，所以小偷 不会窃取相邻的房屋 。
 *
 * 小偷的 窃取能力 定义为他在窃取过程中能从单间房屋中窃取的 最大金额 。
 *
 * 给你一个整数数组 nums 表示每间房屋存放的现金金额。形式上，从左起第 i 间房屋中放有 nums[i] 美元。
 *
 * 另给你一个整数 k ，表示窃贼将会窃取的 最少 房屋数。小偷总能窃取至少 k 间房屋。
 *
 * 返回小偷的 最小 窃取能力。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [2,3,5,9], k = 2
 * 输出：5
 * 解释：
 * 小偷窃取至少 2 间房屋，共有 3 种方式：
 * - 窃取下标 0 和 2 处的房屋，窃取能力为 max(nums[0], nums[2]) = 5 。
 * - 窃取下标 0 和 3 处的房屋，窃取能力为 max(nums[0], nums[3]) = 9 。
 * - 窃取下标 1 和 3 处的房屋，窃取能力为 max(nums[1], nums[3]) = 9 。
 * 因此，返回 min(5, 9, 9) = 5 。
 * 示例 2：
 *
 * 输入：nums = [2,7,9,3,1], k = 2
 * 输出：2
 * 解释：共有 7 种窃取方式。窃取能力最小的情况所对应的方式是窃取下标 0 和 4 处的房屋。返回 max(nums[0], nums[4]) = 2 。
 *
 * @Date:19:21 2023/9/19
 */
public class MinCapabilityⅡ {
    public static void main(String[] args) {
//            MinCapability minCapability = new MinCapability();
//            System.out.println(minCapability.minCapability(new int[]{2,2}, 1));
        MinCapabilityⅡ minCapabilityⅡ = new MinCapabilityⅡ();
        System.out.println(minCapabilityⅡ.minCapabilityⅡ(new int[]{5038,3053,2825,3638,4648,3259,4948,4248,4940,2834,109,5224,5097,
                4708,2162,3438,4152,4134,551,3961,2294,3961,1327,2395,1002,763,4296,3147,5069,2156,572,1261,4272,4158,5186,2543,5055,
                4735,2325,1206,1019,1257,5048,1563,3507,4269,5328,173,5007,2392,967,2768,86,3401,3667,4406,4487,876,1530,819,1320,
                883,1101,5317,2305,89,788,1603,3456,5221,1910,3343,4597}, 28));
    }
        int minCapability=Integer.MAX_VALUE;
        public int minCapability(int[] nums, int k){//该方法运行超时
//        int minCapability=Integer.MAX_VALUE;
//        int max=0;
//        for(int i=0;i<nums.length;i++){
//            for(int j=i+2;j<nums.length;j++){
//                max=Math.max(nums[i],nums[j]);
//                if(max<minCapability)
//                    minCapability=max;
//            }
//        }
//        List<Integer> list=new ArrayList<>();
//        int start=0;
//        while (start<= nums.length-3){
//            for(int i=start;i< nums.length;i+=2){
//
//            }
//        }
//        return minCapability;
//            List<List<Integer>> result=new ArrayList<>();
            List<Integer> subResult=new ArrayList<>();
            dfs(nums,subResult,0,k);

//            int minCapability=Integer.MAX_VALUE;
//            for(List<Integer> subResults:result){
//                int max=Integer.MIN_VALUE;
//                for(int i=0;i<subResults.size();i++){
//                    if(max<subResults.get(i))
//                        max=subResults.get(i);
//                }
//                if(max<minCapability)
//                    minCapability=max;
//            }

            return minCapability;
        }
        public void dfs(int[] nums,List<Integer> subResult,int start,int k){
            if(subResult.size()==k){
                int max=Integer.MIN_VALUE;
                for(Integer integer:subResult){
                    if(max<integer)
                        max=integer;
                }
                if(max<minCapability)
                    minCapability=max;
//                result.add(new ArrayList<>(subResult));
                return;
            }
            if(start+(k-1-subResult.size())*2> nums.length-1)
                return;
            subResult.add(nums[start]);
            dfs(nums,subResult,start+2,k);
            subResult.remove(subResult.size()-1);
            dfs(nums,subResult,start+1,k);
        }
        public int minCapabilityⅡ(int[] nums, int k){
            int low= Arrays.stream(nums).min().getAsInt();
            int high=Arrays.stream(nums).max().getAsInt();
            while (low<=high){
                int mid=(low+high)/2;
                boolean visited=false;
                int count=0;
                for(int i=0;i< nums.length;i++){
                    if(nums[i]<=mid&&!visited){
                        count++;
                        visited=true;
                    }
                    else
                        visited=false;
                }
                if(count>=k)
                    high=mid-1;
                else
                    low=mid+1;
            }
            return low;//这种二分不是单纯的搜索，是逼近，是一种缩小范围。所以low是答案，最后low和high只差1.
        }
    }

