package hashtable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author:zxp
 * @Description:给定两个数组 nums1 和 nums2 ，返回 它们的交集 。输出结果中的每个元素一定是 唯一 的。我们可以 不考虑输出结果的顺序 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2]
 * 示例 2：
 *
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[9,4]
 * 解释：[4,9] 也是可通过的
 *
 *
 * 提示：
 *
 * 1 <= nums1.length, nums2.length <= 1000
 * 0 <= nums1[i], nums2[i] <= 1000
 * @Date:10:33 2024/1/19
 */
public class Intersection {
    public static void main(String[] args) {
        Intersection intersection = new Intersection();
        int[] intersection1 = intersection.intersection(new int[]{1, 2, 2, 1}, new int[]{2, 2});
        System.out.println(Arrays.toString(intersection1));
    }
    public int[] intersection(int[] nums1, int[] nums2){
        int[] record1 = new int[1001];
        int[] record2 = new int[1001];
        record1=getRecord(nums1,record1);
        record2=getRecord(nums2,record2);
        List<Integer> result=new ArrayList<>();
        for(int i=0;i<record1.length;i++){
            if(record1[i]>0&&record2[i]>0)
                result.add(i);
        }
        int[] lastResult = new int[result.size()];
        for(int i=0;i<lastResult.length;i++){
            lastResult[i]=result.get(i);
        }
        return lastResult;
    }
    public int[] getRecord(int[] nums,int[] record){
        for(int i=0;i< nums.length;i++){
            record[nums[i]]++;
        }
        return record;
    }
}
