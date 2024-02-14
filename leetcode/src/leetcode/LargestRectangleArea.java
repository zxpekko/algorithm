package leetcode;

import java.util.Stack;

/**
 * @Author:zxp
 * @Description:给定非负整数数组 heights ，数组中的数字用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 *
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 *
 *
 *
 * 示例 1:
 *
 *
 *
 * 输入：heights = [2,1,5,6,2,3]
 * 输出：10
 * 解释：最大的矩形为图中红色区域，面积为 10
 * 示例 2：
 *
 *
 *
 * 输入： heights = [2,4]
 * 输出： 4
 * @Date:10:10 2023/11/23
 */
public class LargestRectangleArea {
    public static void main(String[] args) {
        int[] heights = {2,0,2};
        LargestRectangleArea largestRectangleArea = new LargestRectangleArea();
        System.out.println(largestRectangleArea.largestRectangleArea(heights));
    }
    public int largestRectangleArea(int[] heights){
        int result=Integer.MIN_VALUE;
        int n= heights.length;
        Stack<Integer> stack=new Stack<>();
        stack.push(0);
        for(int i=1;i<n;i++){
            if(heights[i]>=heights[stack.peek()]){
                stack.push(i);
            }
            else {
                while (!stack.isEmpty()&&heights[i]<heights[stack.peek()]){
                    int mid=stack.pop();
                    if(!stack.isEmpty()){
                        int height=heights[mid];
                        int width=i-stack.peek()-1;
                        result=Math.max(result,height*width);
                    }
                    else {
                        int height=heights[mid];
                        int width=i;
                        result=Math.max(result,height*width);
                    }

                }
                stack.push(i);
            }
        }
        while (!stack.isEmpty()){
            int mid=stack.pop();
            if(mid==n-1&& !stack.isEmpty()){
                int width=n-stack.peek()-1;
                int height=heights[mid];
                result=Math.max(result,width*height);
            }
            else if(mid==n-1&&stack.isEmpty()){
                int width=n;
                int height=heights[mid];
                result=Math.max(result,width*height);
            }
            else if(mid==0){
                int width=n;
                int height=heights[mid];
                result=Math.max(result,width*height);
            }
            else if(mid!=0&&!stack.isEmpty()){
                int width=n-stack.peek()-1;
                int height=heights[mid];
                result=Math.max(result,width*height);
            }
            else {
                int width=n;
                int height=heights[mid];
                result=Math.max(result,width*height);
            }
        }
        return result;

    }
}
