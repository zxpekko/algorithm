package leetcode;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @Author:zxp
 * @Description:给你一个整数数组 nums ，除某个元素仅出现 一次 外，其余每个元素都恰出现 三次 。请你找出并返回那个只出现了一次的元素。
 *
 * 你必须设计并实现线性时间复杂度的算法且使用常数级空间来解决此问题。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [2,2,3,2]
 * 输出：3
 * 示例 2：
 *
 * 输入：nums = [0,1,0,1,0,1,99]
 * 输出：99
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 3 * 104
 * -231 <= nums[i] <= 231 - 1
 * nums 中，除某个元素仅出现 一次 外，其余每个元素都恰出现 三次
 * @Date:9:27 2023/10/25
 */
public class SingleNumberⅡ {
    public static void main(String[] args) {
        SingleNumberⅡ singleNumberⅡ = new SingleNumberⅡ();
        System.out.println(singleNumberⅡ.singleNumber(new int[]{2, 2, 3, 2}));
    }
    public int singleNumber(int[] nums){
        HashMap<Integer, Integer> record = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(record.containsKey(nums[i])){
                int count=record.get(nums[i]);
                record.put(nums[i],count+1);
            }
            else {
                record.put(nums[i],1);
            }
        }
        int target=0;
        for (Map.Entry<Integer, Integer> integerIntegerEntry : record.entrySet()) {
            if(integerIntegerEntry.getValue()==1){
                target= integerIntegerEntry.getKey();
                break;
            }
        }
        return target;
    }

}
