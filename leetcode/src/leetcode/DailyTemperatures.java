package leetcode;

import javax.swing.*;
import java.util.Arrays;
import java.util.Stack;

/**
 * @Author:zxp
 * @Description:给定一个整数数组 temperatures ，表示每天的温度，返回一个数组 answer ，其中 answer[i] 是指对于第 i 天，下一个更高温度出现在几天后。如果气温在这之后都不会升高，请在该位置用 0 来代替。
 *
 *
 *
 * 示例 1:
 *
 * 输入: temperatures = [73,74,75,71,69,72,76,73]
 * 输出: [1,1,4,2,1,1,0,0]
 * 示例 2:
 *
 * 输入: temperatures = [30,40,50,60]
 * 输出: [1,1,1,0]
 * 示例 3:
 *
 * 输入: temperatures = [30,60,90]
 * 输出: [1,1,0]
 * @Date:19:00 2023/11/21
 */
public class DailyTemperatures {
    public static void main(String[] args) {
        int[] ints = {30,60,90};
        DailyTemperatures dailyTemperatures = new DailyTemperatures();
        int[] result = dailyTemperatures.dailyTemperaturesⅢ(ints);
        System.out.println(Arrays.toString(result));
    }
    public int[] dailyTemperatures(int[] temperatures){
        int n= temperatures.length;
        int[] result = new int[n];
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(temperatures[j]>temperatures[i]){
                    result[i]=j-i;
                    break;
                }
            }
        }
        return result;
    }
    public int[] dailyTemperaturesⅡ(int[] temperatures){
        int n= temperatures.length;
        int[] result = new int[n];
        Stack<Integer> stack=new Stack<>();
        stack.push(0);
        for(int i=1;i<n;i++){
            while (!stack.isEmpty()){
                Integer peek = stack.peek();//peek()方法只是找到栈顶元素，不移除
                if(temperatures[i]>temperatures[peek]){
                    result[peek]=i-peek;
                    stack.pop();//pop()方法找到栈顶元素并且移除它。
                }
                else {
                    stack.push(i);
                    break;
                }
                if(stack.isEmpty())
                    stack.push(i);
            }
        }
        return result;
    }
    public int[] dailyTemperaturesⅢ(int[] temperatures){
        int n = temperatures.length;
        int[] result = new int[n];
        Stack<Integer> stack=new Stack<>();
        stack.push(0);
        for(int i=1;i<n;i++){
            if(temperatures[i]<=temperatures[stack.peek()]){
                stack.push(i);
            }
            else {
                while (!stack.isEmpty()&&temperatures[i]>temperatures[stack.peek()]){
                    result[stack.peek()]=i-stack.peek();
                    stack.pop();
                }
                stack.push(i);
            }
        }
        return result;
    }
}
