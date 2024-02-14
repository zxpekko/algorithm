package leetcode;

import java.util.Arrays;

/**
 * @Author:zxp
 * @Description:260
 *
 * 给你一个整数数组 nums，其中恰好有两个元素只出现一次，其余所有元素均出现两次。 找出只出现一次的那两个元素。你可以按 任意顺序 返回答案。
 *
 * 你必须设计并实现线性时间复杂度的算法且仅使用常量额外空间来解决此问题。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,1,3,2,5]
 * 输出：[3,5]
 * 解释：[5, 3] 也是有效的答案。
 * 示例 2：
 *
 * 输入：nums = [-1,0]
 * 输出：[-1,0]
 * 示例 3：
 *
 * 输入：nums = [0,1]
 * 输出：[1,0]
 *
 * @Date:9:17 2023/10/16
 */
public class SingleNumberⅢ {
    public static void main(String[] args) {
        SingleNumberⅢ singleNumberⅢ = new SingleNumberⅢ();
        int[] ints = singleNumberⅢ.singleNumber(new int[]{1,2,1,3,2,5});
        System.out.println(Arrays.toString(ints));
    }
    public int[] singleNumber(int[] nums){
        int sum=0;
        int i=0;
        for(i=0;i< nums.length;i++){
            sum^=nums[i];
        }
        String s = Integer.toBinaryString(sum);
        for(i=s.length()-1;i>=0;i--){
            if(s.charAt(i)=='1')
                break;
        }
        int pos=s.length()-i;//右边第pos位,异或出来的结果最低位是1记该位为pos，如果数组中的数二进制的pos为1分为一组，否则分为另一组，这样必然会将出现一次的两个数分在不同的组，这是因为最低位是1，异或原则异才为1，所以在以pos位进行划分的时候，他们的最低位是不一样的，因此必然在不同组。
//        System.out.println(pos);
        int[] result=new int[2];
        int res1=0,res2=0;
        for(int j=0;j< nums.length;j++){
            String curS=Integer.toBinaryString(nums[j]);
            if(curS.length()-pos<0){
                res2^=nums[j];
            }
            else if(curS.length()-pos>=0&&curS.charAt(curS.length()-pos)=='1'){
                res1^=nums[j];
            }
//            if(curS.charAt(curS.length()-pos)=='1'){
//                res1^=nums[j];
//            }
            else
                res2^=nums[j];
        }
        result[0]=res1;
        result[1]=res2;
        return result;
    }
}
