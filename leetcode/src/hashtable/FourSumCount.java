package hashtable;

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author:zxp
 * @Description:给你四个整数数组 nums1、nums2、nums3 和 nums4 ，数组长度都是 n ，请你计算有多少个元组 (i, j, k, l) 能满足：
 *
 * 0 <= i, j, k, l < n
 * nums1[i] + nums2[j] + nums3[k] + nums4[l] == 0
 *
 *
 * 示例 1：
 *
 * 输入：nums1 = [1,2], nums2 = [-2,-1], nums3 = [-1,2], nums4 = [0,2]
 * 输出：2
 * 解释：
 * 两个元组如下：
 * 1. (0, 0, 0, 1) -> nums1[0] + nums2[0] + nums3[0] + nums4[1] = 1 + (-2) + (-1) + 2 = 0
 * 2. (1, 1, 0, 0) -> nums1[1] + nums2[1] + nums3[0] + nums4[0] = 2 + (-1) + (-1) + 0 = 0
 * 示例 2：
 *
 * 输入：nums1 = [0], nums2 = [0], nums3 = [0], nums4 = [0]
 * 输出：1
 * @Date:12:32 2024/1/19
 */
public class FourSumCount {
    public static void main(String[] args) {
        FourSumCount fourSumCount = new FourSumCount();
        FourSumCountⅡ fourSumCountⅡ = new FourSumCountⅡ();
        System.out.println(fourSumCountⅡ.fourSumCount(new int[]{1, 2}, new int[]{-2, -1}, new int[]{-1, 2}, new int[]{0, 2}));
        System.out.println(fourSumCount.fourSumCount(new int[]{1, 2}, new int[]{-2, -1}, new int[]{-1, 2}, new int[]{0, 2}));
    }
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4){
        HashMap<Integer,Integer> record=new HashMap<>();
        for(int i=0;i<nums1.length;i++){
            for(int j=0;j<nums2.length;j++){
                int subResult = nums1[i] + nums2[j];
                if(!record.containsKey(subResult)){
                    record.put(subResult,1);
                }
                else {
                    Integer value = record.get(subResult);
                    record.put(subResult,value+1);
                }
            }
        }
        int count=0;
        for(int i=0;i<nums3.length;i++){
            for(int j=0;j< nums4.length;j++){
                int judge = nums3[i] + nums4[j];
                if(record.containsKey(-judge))
                    count+=record.get(-judge);
            }
        }
        return count;
    }
}
class FourSumCountⅡ{
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4){
        Map<Integer, Integer> record=new HashMap<>();
        for(int i=0;i<nums1.length;i++){
            for(int j=0;j<nums2.length;j++){
                int subSum = nums1[i] + nums2[j];
                if(!record.containsKey(subSum))
                    record.put(subSum,1);
                else {
                    Integer integer = record.get(subSum);
                    record.put(subSum,integer+1);
                }
            }
        }
        int count=0;
        for(int i=0;i< nums3.length;i++){
            for(int j=0;j< nums4.length;j++){
                int anotherSum = nums3[i] + nums4[j];
                if(record.containsKey(-anotherSum))
                    count+=record.get(-anotherSum);
            }
        }
        return count;
    }
}