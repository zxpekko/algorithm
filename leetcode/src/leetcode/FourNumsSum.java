package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author:zxp
 * @Description:
 * @Date:12:00 2023/7/18
 */
public class FourNumsSum {
    public static void main(String[] args) {
        int[] nums={2,2,2,2};
        FourNumsSum fourNumsSum = new FourNumsSum();
        List<List<Integer>> list = fourNumsSum.fourSum(nums, 8);
        System.out.println(list);
    }
    public List<List<Integer>> fourSum(int[] nums, int target){
        int n= nums.length;
        Arrays.sort(nums);
        List<List<Integer>> result=new ArrayList<>();
        for(int first=0;first<n;first++){
            if(first>0&&nums[first]==nums[first-1]){
                continue;
            }

            int nowTarget=target-nums[first];
            for(int second=first+1;second<n;second++){
                if(second>first+1&&nums[second]==nums[second-1]){
                    continue;
                }
                int fourest=n-1;
                for(int third=second+1;third<n;third++){
                    if(third>second+1&&nums[third]==nums[third-1]){
                        continue;
                    }
                    while (third<fourest&&(long)nums[second]+(long)nums[third]+(long)nums[fourest]>nowTarget){
                        fourest--;
                    }
                    if(third==fourest){
                        break;
                    }
                    if((long)nums[second]+(long)nums[third]+(long)nums[fourest]==nowTarget) {
                        List<Integer> SingleResult=new ArrayList<>();
                        SingleResult.add(nums[first]);
                        SingleResult.add(nums[second]);
                        SingleResult.add(nums[third]);
                        SingleResult.add(nums[fourest]);
                        result.add(SingleResult);
                    }
                }

            }
        }
        return result;
    }
}
