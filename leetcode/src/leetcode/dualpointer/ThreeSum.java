package leetcode.dualpointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author:zxp
 * @Description:给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a ，b ，c ，使得 a + b + c = 0 ？请找出所有和为 0 且 不重复 的三元组。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 * 示例 2：
 *
 * 输入：nums = []
 * 输出：[]
 * 示例 3：
 *
 * 输入：nums = [0]
 * 输出：[]
 * @Date:9:32 2023/10/30
 */
public class ThreeSum {
    public static void main(String[] args) {
        ThreeSum threeSum = new ThreeSum();
        System.out.println(threeSum.threeSum(new int[]{-1,0,1,2,-1,-4,-2,-3,3,0,4}));
    }
    public List<List<Integer>> threeSum(int[] nums){//超出时间限制，算法没问题，g
        Arrays.sort(nums);
        List<List<Integer>> result=new ArrayList<>();
        if(nums.length<3)
            return result;
//        int i=0;
        for(int i=0;i< nums.length;i++){
            int left=0,right= nums.length-1;
            while (left<right){
                if(left==i)
                    left+=1;
                if(right==i)
                    right-=1;
                if(nums[i]+nums[left]+nums[right]>0)
                    right--;
                else if(nums[i]+nums[left]+nums[right]<0)
                    left++;
                else{
                    if(i!=left&&i!=right&&left!=right){
                        List<Integer> subResult=new ArrayList<>();
                        if(nums[i]<=nums[left]){
                            subResult.add(nums[i]);
                            subResult.add(nums[left]);
                            subResult.add(nums[right]);
                        }
                        else if(nums[i]>nums[left]&&nums[i]<=nums[right]){
                            subResult.add(nums[left]);
                            subResult.add(nums[i]);
                            subResult.add(nums[right]);
                        }
                        else if(nums[i]>nums[right]){
                            subResult.add(nums[left]);
                            subResult.add(nums[right]);
                            subResult.add(nums[i]);
                        }

                        if(result.size()>0){
                            int flag=0;
                            for(int j=0;j<result.size();j++){
                                int count=0;
                                List<Integer> lastResult=result.get(j);
                                for(int k=0;k<subResult.size();k++){
                                    if(subResult.get(k)==lastResult.get(k))
                                        count++;
                                }
                                if(count==3){
                                    flag=1;
                                    break;
                                }
                            }
                            if(flag==0){
//                                System.out.println(i);
//                                System.out.println(left);
//                                System.out.println(right);
//                                System.out.println("==============");
                                result.add(subResult);
//                            break;
                            }
//                        else
//                            break;
//                        List<Integer> lastResult=result.get(result.size()-1);
//                        int count=0;
//                        for(int j=0;j<subResult.size();j++){
//                            if(subResult.get(j)==lastResult.get(j)){
//                                count+=1;
//                            }
//                        }
//                        if(count<3){
//                            result.add(subResult);
//                            break;
//                        }
//                        else
//                            break;
                        }
                        else {
                            result.add(subResult);
//                        break;
                        }
                        left++;
                        right--;
                    }
                    else{
                        left++;
                        right--;
                    }
//                    System.out.println(i+" "+left+right);

                }

            }
        }
        return result;
    }
    public List<List<Integer>> threeSumⅡ(int[] nums){
        int n= nums.length;
        List<List<Integer>> result=new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0;i<n;i++){
            if(i>0&&nums[i]==nums[i-1]){
                continue;
            }
            int k=n-1;
            for(int j=i+1;j<n;j++){
                if(j>i+1&&nums[j]==nums[j-1]){
                    continue;
                }

                while(j<k&&nums[i]+nums[j]+nums[k]>0){
                    k--;
                }
                if(j==k)
                    break;
                if(nums[i]+nums[j]+nums[k]==0){
                    List<Integer> subResult=new ArrayList<>();
                    subResult.add(nums[i]);
                    subResult.add(nums[j]);
                    subResult.add(nums[k]);
                    result.add(subResult);
                }
            }
        }
        return result;
    }
}
