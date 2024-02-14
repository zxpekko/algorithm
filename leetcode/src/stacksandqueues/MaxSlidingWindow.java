package stacksandqueues;

import com.sun.java.swing.plaf.windows.WindowsTextAreaUI;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author:zxp
 * @Description:给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 *
 * 返回 滑动窗口中的最大值 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
 * 输出：[3,3,5,5,6,7]
 * 解释：
 * 滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7
 * 示例 2：
 *
 * 输入：nums = [1], k = 1
 * 输出：[1]
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 105
 * -104 <= nums[i] <= 104
 * 1 <= k <= nums.length
 * @Date:12:01 2024/2/1
 */
public class MaxSlidingWindow {
    public static void main(String[] args) {
        MaxSlidingWindow maxSlidingWindow = new MaxSlidingWindow();
        int[] ints = maxSlidingWindow.maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3);
        System.out.println(Arrays.toString(ints));
        MaxSlidingWindowⅡ maxSlidingWindowⅡ = new MaxSlidingWindowⅡ();
        int[] ints1 = maxSlidingWindowⅡ.maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3);
        System.out.println(Arrays.toString(ints1));
        MaxSlidingWindowⅢ maxSlidingWindowⅢ = new MaxSlidingWindowⅢ();
        int[] ints2 = maxSlidingWindowⅢ.maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3);
        System.out.println(Arrays.toString(ints2));
        MaxSlidingWindowⅣ maxSlidingWindowⅣ = new MaxSlidingWindowⅣ();
        int[] ints3 = maxSlidingWindowⅣ.maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3);
        System.out.println(Arrays.toString(ints3));
    }
    public int[] maxSlidingWindow(int[] nums, int k){
        int n= nums.length;
        ArrayDeque<Integer> arrayDeque=new ArrayDeque<>();
        int[] result = new int[n - k + 1];
        int index=0;
        for(int i=0;i<n;i++){
            //元素提取范围[i-k+1,i],如果双端队列的头部元素小于i-k+1说明是老元素，需要弹出
            while (!arrayDeque.isEmpty()&&arrayDeque.peek()<i-k+1)
                arrayDeque.poll();
            //维护单调队列，如果队列的尾部元素小于当前即将插入的元素则弹出
            while (!arrayDeque.isEmpty()&&nums[arrayDeque.peekLast()]<nums[i])
                arrayDeque.pollLast();
            arrayDeque.offer(i);
            if(i>=k-1)//i至少要是k-1，那么窗口才正好从元素0位置开始，否则不能加入结果集。
                result[index++]=nums[arrayDeque.peek()];
        }
        return result;
    }
}
class MaxSlidingWindowⅡ{
    public int[] maxSlidingWindow(int[] nums, int k){
        int n= nums.length;
        int[] result= new int[n - k + 1];
        ArrayDeque<Integer> arrayDeque=new ArrayDeque<>();//双端队列
        int index=0;
        for(int i=0;i<n;i++){
            //[i-k+1,i]这个范围才可以取值，不符合范围需要弹出
            while (!arrayDeque.isEmpty()&&arrayDeque.peek()<i-k+1)
                arrayDeque.poll();
            while (!arrayDeque.isEmpty()&&nums[arrayDeque.peekLast()]<nums[i])
                arrayDeque.pollLast();
            arrayDeque.offer(i);
            if(i>=k-1){
                result[index++]=nums[arrayDeque.peek()];
            }
        }
        return result;
    }
}
class MaxSlidingWindowⅢ{
    public int[] maxSlidingWindow(int[] nums, int k){
        int n= nums.length;
        int[] result = new int[n - k + 1];
        int index=0;
        ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();
        for(int i=0;i<n;i++){
            //[i-k+1,i]
            while (!arrayDeque.isEmpty()&&arrayDeque.peek()<i-k+1)
                arrayDeque.poll();
            while (!arrayDeque.isEmpty()&&nums[arrayDeque.peekLast()]<nums[i])
                arrayDeque.pollLast();
            arrayDeque.offer(i);
            if(i>=k-1)
                result[index++]=nums[arrayDeque.peek()];
        }
        return result;
    }
}
class MaxSlidingWindowⅣ{
    public int[] maxSlidingWindow(int[] nums, int k){
        int n=nums.length;
        int[] result=new int[n-k+1];
        int index=0;
        ArrayDeque<Integer> q1=new ArrayDeque();
        for(int i=0;i<n;i++){
            //i-k+1
            while(!q1.isEmpty()&&q1.peek()<i-k+1)
                q1.pollLast();
            while(!q1.isEmpty()&&nums[q1.peekLast()]<nums[i])
                q1.pollLast();
            q1.offer(i);
            if(i>=k-1)
                result[index++]=nums[q1.peek()];
        }
        return result;
    }
}
