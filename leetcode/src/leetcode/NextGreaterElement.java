package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @Author:zxp
 * @Description:nums1 中数字 x 的 下一个更大元素 是指 x 在 nums2 中对应位置 右侧 的 第一个 比 x 大的元素。
 *
 * 给你两个 没有重复元素 的数组 nums1 和 nums2 ，下标从 0 开始计数，其中nums1 是 nums2 的子集。
 *
 * 对于每个 0 <= i < nums1.length ，找出满足 nums1[i] == nums2[j] 的下标 j ，并且在 nums2 确定 nums2[j] 的 下一个更大元素 。如果不存在下一个更大元素，那么本次查询的答案是 -1 。
 *
 * 返回一个长度为 nums1.length 的数组 ans 作为答案，满足 ans[i] 是如上所述的 下一个更大元素 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums1 = [4,1,2], nums2 = [1,3,4,2].
 * 输出：[-1,3,-1]
 * 解释：nums1 中每个值的下一个更大元素如下所述：
 * - 4 ，用加粗斜体标识，nums2 = [1,3,4,2]。不存在下一个更大元素，所以答案是 -1 。
 * - 1 ，用加粗斜体标识，nums2 = [1,3,4,2]。下一个更大元素是 3 。
 * - 2 ，用加粗斜体标识，nums2 = [1,3,4,2]。不存在下一个更大元素，所以答案是 -1 。
 * 示例 2：
 *
 * 输入：nums1 = [2,4], nums2 = [1,2,3,4].
 * 输出：[3,-1]
 * 解释：nums1 中每个值的下一个更大元素如下所述：
 * - 2 ，用加粗斜体标识，nums2 = [1,2,3,4]。下一个更大元素是 3 。
 * - 4 ，用加粗斜体标识，nums2 = [1,2,3,4]。不存在下一个更大元素，所以答案是 -1 。
 *
 *
 * 提示：
 *
 * 1 <= nums1.length <= nums2.length <= 1000
 * 0 <= nums1[i], nums2[i] <= 104
 * nums1和nums2中所有整数 互不相同
 * nums1 中的所有整数同样出现在 nums2 中
 *
 * @Date:20:16 2023/11/21
 */
public class NextGreaterElement {
    public static void main(String[] args) {
        int[] nums1 = {4, 1, 2};
        int[] nums2 = {1, 3, 4, 2};
        NextGreaterElement nextGreaterElement = new NextGreaterElement();
        int[] ints = nextGreaterElement.nextGreaterElement(nums1, nums2);
        System.out.println(Arrays.toString(ints));

    }
    public int[] nextGreaterElement(int[] nums1, int[] nums2){//单调栈加hash

        int n=nums1.length;
        int m=nums2.length;
        int[] result = new int[n];
        Arrays.fill(result,-1);
        Map<Integer,Integer> map=new HashMap<>();
        Stack<Integer> stack=new Stack<>();
        stack.push(0);
        for(int i=1;i<m;i++){
            if(nums2[i]<=nums2[stack.peek()]){
                stack.push(i);
            }
            else {
                while (!stack.isEmpty()&&nums2[i]>nums2[stack.peek()]){

                    map.put(nums2[stack.peek()],nums2[i]);//存储nums2中的下一个更大元素采用的是hash映射，键是具体的值，值是下一个更大元素，这样在遍历nums1
//                    时候，可以直接判断是否有键即可
                    stack.pop();
                }
                stack.push(i);
            }
        }

        for(int i=0;i<n;i++){
            if(map.containsKey(nums1[i]))
                result[i]=map.get(nums1[i]);
        }

        return result;
    }
}
