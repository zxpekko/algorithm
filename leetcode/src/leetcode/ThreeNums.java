package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author:zxp
 * @Description:
 * @Date:14:27 2023/7/15
 */
public class ThreeNums {
    public static void main(String[] args) {
        ThreeNums threeNums = new ThreeNums();
        int[] nums={0,0,0};
        List<List<Integer>> list = threeNums.threeSum(nums);
        System.out.println(list);
    }
    public List<List<Integer>> threeSum(int[] nums){
        List<List<Integer>> result=new ArrayList<>();
//        List<Integer> SingleResult=new ArrayList<>();
        int n= nums.length;
        Arrays.sort(nums);
        for(int first=0;first<n;first++){
            int third=n-1;
            int target=-nums[first];
            if(first>0&&nums[first]==nums[first-1]){
                continue;
            }
            for(int second=first+1;second<n;second++){
                if(second>first+1&&nums[second]==nums[second-1]){
                    continue;
                }
                while (second<third&&nums[second]+nums[third]>target){
                    third--;
                }
                if(second==third){
                    break;
                }
                if(nums[second]+nums[third]==target){
                    List<Integer> SingleResult=new ArrayList<>();
                    SingleResult.add(nums[first]);
                    SingleResult.add(nums[second]);
                    SingleResult.add(nums[third]);
                    result.add(SingleResult);
                }
            }
        }
        return result;
    }
}
