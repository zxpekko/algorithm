package leetcode;

import java.util.Arrays;

/**
 * @Author:zxp
 * @Description:给你一个 升序排列 的数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。元素的 相对顺序 应该保持 一致 。然后返回 nums 中唯一元素的个数。
 *
 * 考虑 nums 的唯一元素的数量为 k ，你需要做以下事情确保你的题解可以被通过：
 *
 * 更改数组 nums ，使 nums 的前 k 个元素包含唯一元素，并按照它们最初在 nums 中出现的顺序排列。nums 的其余元素与 nums 的大小不重要。
 * 返回 k 。
 * 判题标准:
 *
 * 系统会用下面的代码来测试你的题解:
 *
 * int[] nums = [...]; // 输入数组
 * int[] expectedNums = [...]; // 长度正确的期望答案
 *
 * int k = removeDuplicates(nums); // 调用
 *
 * assert k == expectedNums.length;
 * for (int i = 0; i < k; i++) {
 *     assert nums[i] == expectedNums[i];
 * }
 * 如果所有断言都通过，那么您的题解将被 通过。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,1,2]
 * 输出：2, nums = [1,2,_]
 * 解释：函数应该返回新的长度 2 ，并且原数组 nums 的前两个元素被修改为 1, 2 。不需要考虑数组中超出新长度后面的元素。
 * 示例 2：
 *
 * 输入：nums = [0,0,1,1,1,2,2,3,3,4]
 * 输出：5, nums = [0,1,2,3,4]
 * 解释：函数应该返回新的长度 5 ， 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4 。不需要考虑数组中超出新长度后面的元素。
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 3 * 104
 * -104 <= nums[i] <= 104
 * nums 已按 升序 排列
 * @Date:20:40 2023/8/29
 */
public class RemoveDuplicates {
    public static void main(String[] args) {
        int[] nums={1,1,1};
        RemoveDuplicates removeDuplicates = new RemoveDuplicates();
        System.out.println(removeDuplicates.removeDuplicates(nums));
    }
    public int removeDuplicates(int[] nums){
//        int dupliceteNumber=0;
//        int interval=0;
//        for(int i=0;i< nums.length-1-dupliceteNumber;i++){
//            if(nums[i]==nums[i+1]){
//                dupliceteNumber++;
//                interval++;
//            }
//            else if((nums[i]!=nums[i+1])&&interval!=0){
//                int[] newNums = removeInterval(nums, i - interval + 1, i);
//                nums=newNums;
//                i=i-1;
//                interval=0;
//            }
//
//        }
//        System.out.println(dupliceteNumber);
//        System.out.println(Arrays.toString(nums));
//        return nums.length-dupliceteNumber;
        int duplicate=0;
        int lastNum=nums[nums.length-1];
        for(int i=0;i<nums.length-duplicate;i++){
//            if(nums[i]==lastNum)
//                break;
            int interval=0;
            int j;
            for(j=i+1;j<nums.length-duplicate;j++){
                if(nums[j]==nums[i]){
                    duplicate++;
                    interval++;
                    int t=j;
                    for(int k=t;k<nums.length-1;k++)nums[k]=nums[k+1];
                    j--;
                }
                else{
                    break;
                }
            }
//            int[] ints = removeInterval(nums, i + 1, j - 1);
//            nums=ints;
        }
        System.out.println(duplicate);
        System.out.println(Arrays.toString(nums));
        return nums.length-duplicate;
//        int lastNum=nums[nums.length-1];
//        int k=0;
//        while (nums[k]!=lastNum){
//
//        }
//        return 0;
    }
    public int[] remove(int[] nums,int index){
        for(int i=index;i< nums.length-1;i++) nums[i]=nums[i+1];
//        for(int i=end+1,j=start;i< nums.length;i++,j++){
//            nums[j]=nums[i];
//        }
        return nums;
    }
    public int removeDuplicatesⅡ(int[] nums){//双指针法
        int p=0;int q=1;
        while (q< nums.length){
            if(nums[p]!=nums[q]){
                if(q-p>1){
                    nums[p+1]=nums[q];
                    p++;
                }

            }
            q++;
        }
        return p+1;
    }

}
