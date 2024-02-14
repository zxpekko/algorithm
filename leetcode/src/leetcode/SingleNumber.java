package leetcode;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author:zxp
 * @Description:给你一个 非空 整数数组 nums ，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 *
 * 你必须设计并实现线性时间复杂度的算法来解决此问题，且该算法只使用常量额外空间。
 *
 * 示例 1 ：
 *
 * 输入：nums = [2,2,1]
 * 输出：1
 * 示例 2 ：
 *
 * 输入：nums = [4,1,2,1,2]
 * 输出：4
 * 示例 3 ：
 *
 * 输入：nums = [1]
 * 输出：1
 * @Date:21:28 2023/8/27
 */
public class SingleNumber {
    public static void main(String[] args) {
        int[] nums={4,1,2,1,2};
        SingleNumber singleNumber = new SingleNumber();
        System.out.println(singleNumber.singleNumberⅡ(nums));

    }
    public int singleNumber(int[] nums){
        Map<Integer,Integer> visited=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(visited.containsKey(nums[i])){
                visited.put(nums[i],2);
            }
            else {
                visited.put(nums[i],1);
            }

        }
        int i;
        for(i=0;i< nums.length;i++){
            if(visited.get(nums[i])==1)
                break;
        }

        return nums[i];
    }
    @Test
    public void test(){
        int a=1;
        int b=0;
        System.out.println(a&b);
    }
    public int singleNumberⅡ(int[] nums){//异或方法。a^0=a,a^b^a=(a^a)^b=0^b=b,a^a=0.
        int single=0;
        for(int i=0;i<nums.length;i++){
            single^=nums[i];
        }
        return single;
    }

}
