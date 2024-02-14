package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author:zxp
 * @Description:以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
 * 输出：[[1,6],[8,10],[15,18]]
 * 解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 示例 2：
 *
 * 输入：intervals = [[1,4],[4,5]]
 * 输出：[[1,5]]
 * 解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。
 * @Date:15:06 2023/8/6
 */
public class MergeArrays {
    public static void main(String[] args) {
        int[][] intervals = {{2, 3}, {5, 5}, {2, 2}, {3, 4}, {3, 4}};
        MergeArrays mergeArrays = new MergeArrays();
        int[][] merge = mergeArrays.merge(intervals);
        for(int i=0;i< merge.length;i++){
            System.out.println(Arrays.toString(merge[i]));

        }
    }
    public int[][] merge(int[][] intervals){
        for(int i=0;i< intervals.length-1;i++){
            for(int j=0;j< intervals.length-1-i;j++){
                if(intervals[j][0]>intervals[j+1][0]){
                    int[] temp=intervals[j];
                    intervals[j]=intervals[j+1];
                    intervals[j+1]=temp;
                }
            }
        }
        if(intervals.length==1){
            return intervals;
        }
        else if(intervals.length==2){
            List<int[]> ints = mergeTwo(intervals[0], intervals[1]);
            int[][] result = new int[ints.size()][2];
            for(int i=0;i< result.length;i++)
                result[i]=ints.get(i);
            return result;
        }
        else {
            int flag=1;
            int num=0;
            while (flag==1){
                flag=0;
                for(int i=0;i< intervals.length-1-num;i++){
                    List<int[]> resMerge = mergeTwo(intervals[i], intervals[i + 1]);
                    if(resMerge.size()==2){

                    }
                    else {
                        for(int j=i;j< intervals.length-1;j++){
                            intervals[j]=intervals[j+1];
                        }
                        intervals[i]= resMerge.get(0);
                        num+=1;
                        flag=1;
                    }
                }
            }
            int[][] result=new int[intervals.length-num][2];
            for(int i=0;i< result.length;i++){
                result[i]=intervals[i];
            }
            return result;
        }

    }
    public List<int[]> mergeTwo(int[] intervals1, int[] intervals2){
        if((intervals2[0]>=intervals1[0]&&intervals2[0]<=intervals1[1])||
                (intervals2[1]>=intervals1[0]&&intervals2[1]<=intervals1[1])||
                (intervals1[0]>=intervals2[0]&&intervals1[0]<=intervals2[1])
                ||intervals1[1]>=intervals2[0]&&intervals1[1]<=intervals2[1]){
            int a=Math.min(intervals1[0],intervals2[0]);
            int b=Math.max(intervals1[1],intervals2[1] );
            int[] merge={a,b};
            List<int[]> res=new ArrayList<>();
            res.add(merge);
            return res;
        }
        else {
            List<int[]> res=new ArrayList<>();
            res.add(intervals1);
            res.add(intervals2);
            return res;
        }
    }
}
