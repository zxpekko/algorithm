package leetcode;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Author:zxp
 * @Description:给定一个三角形 triangle ，找出自顶向下的最小路径和。
 *
 * 每一步只能移动到下一行中相邻的结点上。相邻的结点 在这里指的是 下标 与 上一层结点下标 相
 * 同或者等于 上一层结点下标 + 1 的两个结点。也就是说，如果正位于当前行的下标 i ，那么下一步可以移动到下一行的下标 i 或 i + 1 。
 * @Date:15:31 2023/8/20
 */
public class MinimumTotal {
    public static void main(String[] args) {
        List<List<Integer>> triangle=new ArrayList<>();
        List<List<Integer>> tr1=new ArrayList<>();
        List<Integer> list=new ArrayList<>();
        list.add(-10);
        tr1.add(list);
        List<Integer> list1=new ArrayList<>();
        List<Integer> list2=new ArrayList<>();
        List<Integer> list3=new ArrayList<>();
        List<Integer> list4=new ArrayList<>();
        list1.add(2);
        list2.add(3);
        list2.add(4);
        list3.add(6);
        list3.add(5);
        list3.add(7);
        list4.add(4);
        list4.add(1);
        list4.add(8);
        list4.add(3);
        triangle.add(list1);
        triangle.add(list2);
        triangle.add(list3);
        triangle.add(list4);
        MinimumTotal minimumTotal = new MinimumTotal();
        int i = minimumTotal.minimumTotal(tr1);
        System.out.println(i);

    }
    public int minimumTotal(List<List<Integer>> triangle){
//        int[] dp = new int[triangle.size()];//dp[i]表示第i层的最小路径和。
//        dp[0]=triangle.get(0).get(0);
        int[][] dp = new int[triangle.size()][triangle.size()];//dp[i][j]表示以第i层第j个数结尾的情况下的最短路径
        dp[0][0]=triangle.get(0).get(0);
        for(int i=1;i< triangle.size();i++){
            for(int j=0;j<triangle.get(i).size();j++){
                if(j==0){
                    dp[i][j]=dp[i-1][j]+triangle.get(i).get(j);
                }
                else if(j==triangle.get(i).size()-1){
                    dp[i][j]=dp[i-1][j-1]+triangle.get(i).get(j);
                }
                else {
                    dp[i][j]=Math.min(dp[i-1][j]+triangle.get(i).get(j),dp[i-1][j-1]+triangle.get(i).get(j));
                }
            }
        }
        int min=dp[dp.length-1][0];
        for(int i=1;i<dp[dp.length-1].length;i++){
            if(dp[dp.length-1][i]<min)
                min=dp[dp.length-1][i];
        }
        return min;
    }

}
