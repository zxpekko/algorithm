package leetcode;

import java.util.Arrays;

/**
 * @Author:zxp
 * @Description:实现冒泡排序
 * @Date:12:28 2023/10/10
 */
public class Bubble {
    public static void main(String[] args) {
        int[] ints = {4, 3, 2, 1};
        Bubble bubble = new Bubble();
        bubble.bubble(ints);
        System.out.println(Arrays.toString(ints));
    }
    public void bubble(int[] nums){
        int n= nums.length;
        for(int i=0;i<n-1;i++){
            for(int j=0;j<n-i-1;j++){
                if(nums[j]>nums[j+1]){
                    int temp=nums[j];
                    nums[j]=nums[j+1];
                    nums[j+1]=temp;
                }
            }
        }
    }
}
