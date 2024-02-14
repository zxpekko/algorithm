package leetcode;

import java.util.Arrays;

/**
 * @Author:zxp
 * @Description:
 * @Date:21:06 2023/7/17
 */
public class ThreeNumsSumClosest {
    public static void main(String[] args) {
        int[] nums={-1,2,1,-4};
        ThreeNumsSumClosest threeNumsSumClosest = new ThreeNumsSumClosest();
        int i = threeNumsSumClosest.threeSumClosest(nums, 2);
        System.out.println(i);
    }
    public int threeSumClosest(int[] nums,int target){
        int n= nums.length;
        Arrays.sort(nums);
        int abs=10000000;
        int best=10000000;
        for(int first=0;first<n;first++){
            if(first>0 && nums[first]==nums[first-1]){
                continue;
            }
//            int nowTarget=target-nums[first];
            int second=first+1;
            int third=n-1;
            while(second<third){
                int sum=nums[first]+nums[second]+nums[third];
                if(sum==target){
                    return sum;
                }
//                abs= Math.min(Math.abs(sum-target),abs);
                int nowAbs=Math.abs(sum-target);
                if(nowAbs<abs){
                    abs=nowAbs;
                    best=sum;
                }
                if(sum>=target){
                    third-=1;
//                    sum=nums[first]+nums[second]+nums[third];
//                    nowAbs=Math.abs(sum-target);
                }
                else {
                    second+=1;
                }
            }
        }
        return best;
    }
}
