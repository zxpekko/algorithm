package stacksandqueues;

import com.sun.java.swing.plaf.windows.WindowsTextAreaUI;

import java.util.*;

/**
 * @Author:zxp
 * @Description:给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。
 *
 *
 *
 * 示例 1:
 *
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 * 示例 2:
 *
 * 输入: nums = [1], k = 1
 * 输出: [1]
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 105
 * k 的取值范围是 [1, 数组中不相同的元素的个数]
 * 题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的
 * @Date:11:07 2024/2/2
 */
public class TopKFrequent {
    public static void main(String[] args) {
        TopKFrequent topKFrequent = new TopKFrequent();
        int[] ints = topKFrequent.topKFrequent(new int[]{4,1,-1,2,-1,2,3}, 2);
        System.out.println(Arrays.toString(ints));
        TopKFrequentⅡ topKFrequentⅡ = new TopKFrequentⅡ();
        int[] ints1 = topKFrequentⅡ.topKFrequent(new int[]{4, 1, -1, 2, -1, 2, 3}, 2);
        System.out.println(Arrays.toString(ints1));
        TopKFrequentⅢ topKFrequentⅢ = new TopKFrequentⅢ();
        int[] ints2 = topKFrequentⅢ.topKFrequent(new int[]{4, 1, -1, 2, -1, 2, 3}, 2);
        System.out.println(Arrays.toString(ints2));
    }
    public int[] topKFrequent(int[] nums, int k){
        int[] result= new int[k];
        PriorityQueue<int[]> priorityQueue=new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1]-o2[1];
            }
        });//队列的头到尾部进行从小到大排列，队列头部元素最小
        Map<Integer,Integer> record=new HashMap<>();
        for(int num:nums){
            if(record.containsKey(num)){
                record.put(num,record.get(num)+1);
            }
            else record.put(num,1);
        }
        for(Map.Entry<Integer, Integer> entry:record.entrySet()){
            if(priorityQueue.size()<k){
                priorityQueue.offer(new int[]{entry.getKey(),entry.getValue()});
            }
            else {
                if(priorityQueue.peek()[1]<entry.getValue()){
                    priorityQueue.poll();
                    priorityQueue.offer(new int[]{entry.getKey(),entry.getValue()});
                }
            }
        }
        for(int i=k-1;i>=0;i--){
            result[i]=priorityQueue.poll()[0];
        }
        return result;
    }
}
class TopKFrequentⅡ{
    public int[] topKFrequent(int[] nums, int k){
        int[] result = new int[k];
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });//优先级队列，存放的元素是一个数组，两个元素，第一个元素是数组中的具体的值，第二个是这个值出现的频率。
        Map<Integer,Integer> record=new HashMap<>();
        for(int num:nums){
            if(record.containsKey(num))
                record.put(num,record.get(num)+1);
            else
                record.put(num,1);
        }
        for(Map.Entry<Integer,Integer> entry:record.entrySet()){
            if(priorityQueue.size()<k)
                priorityQueue.offer(new int[]{entry.getKey(), entry.getValue()});
            else {
                if(priorityQueue.peek()[1]<entry.getValue()){
                    priorityQueue.poll();
                    priorityQueue.offer(new int[]{entry.getKey(),entry.getValue()});
                }
            }
        }
        for(int i=k-1;i>=0;i--){
            result[i]=priorityQueue.poll()[0];
        }
        return result;
    }
}
class TopKFrequentⅢ{
    public int[] topKFrequent(int[] nums, int k){
        int[] result = new int[k];
        Map<Integer,Integer> record=new HashMap<>();
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        for(int num:nums){
            if(record.containsKey(num))
                record.put(num,record.get(num)+1);
            else
                record.put(num,1);
        }
        for(int i=0;i<nums.length;i++){
            if(priorityQueue.size()<k)
                priorityQueue.offer(new int[]{nums[i], record.get(nums[i])});
            else {
                if(priorityQueue.peek()[1]< record.get(nums[i])){
                    priorityQueue.poll();
                    priorityQueue.offer(new int[]{nums[i],record.get(nums[i])});
                }
            }
        }
        for(int i=k-1;i>=0;i--){
            result[i]=priorityQueue.poll()[0];
        }
        return result;
    }
}
