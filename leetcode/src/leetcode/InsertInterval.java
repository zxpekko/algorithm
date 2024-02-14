package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author:zxp
 * @Description:给你一个 无重叠的 ，按照区间起始端点排序的区间列表。
 *
 * 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。
 *
 *
 *
 * 示例 1：
 *
 * 输入：intervals = [[1,3],[6,9]], newInterval = [2,5]
 * 输出：[[1,5],[6,9]]
 * 示例 2：
 *
 * 输入：intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * 输出：[[1,2],[3,10],[12,16]]
 * 解释：这是因为新的区间 [4,8] 与 [3,5],[6,7],[8,10] 重叠。
 * 示例 3：
 *
 * 输入：intervals = [], newInterval = [5,7]
 * 输出：[[5,7]]
 * 示例 4：
 *
 * 输入：intervals = [[1,5]], newInterval = [2,3]
 * 输出：[[1,5]]
 * 示例 5：
 *
 * 输入：intervals = [[1,5]], newInterval = [2,7]
 * 输出：[[1,7]]
 * @Date:10:54 2023/8/13
 */
public class InsertInterval {
    public static void main(String[] args) {
        int[][] intervals={{2,5},{6,7},{8,9}};
        int[] newInterval={0,1};
        InsertInterval insertInterval = new InsertInterval();
        for (int[] ints : insertInterval.insert(intervals, newInterval)) {
            System.out.println(Arrays.toString(ints));
        }

    }
    public int[][] insert(int[][] intervals, int[] newInterval){
        int left=-1;
        int right=-1;
        if(intervals.length==0){
            int[][] res=new int[1][2];
            res[0]=newInterval;
            return res;
        }
        for(int i=0;i< intervals.length;i++){
            if(isInInterval(intervals[i],newInterval)){
                left=i;
                break;
            }
        }
        for(int i= intervals.length-1;i>=0;i--){
            if(isInInterval(intervals[i],newInterval)){
                right=i;
                break;
            }
        }
        int InsertIndex=-1;
        if(left==-1&&right==-1){
            for(int i=0;i< intervals.length;i++){

                if(intervals[i][0]>newInterval[0]){
                    InsertIndex=i;
                    break;
                }

                if(intervals[intervals.length-1][0]<newInterval[0]){
                    InsertIndex= intervals.length;
                    break;
                }

            }
            List<int[]> newIntervals=new ArrayList<>();
            for(int i=0;i<InsertIndex;i++){
                newIntervals.add(intervals[i]);
            }
            newIntervals.add(newInterval);
            for(int i=InsertIndex;i< intervals.length;i++){
                newIntervals.add(intervals[i]);
            }
            int length= newIntervals.size();
            int[][] res = new int[length][2];
            for(int i=0;i<length;i++){
                res[i]=newIntervals.get(i);
            }
            return res;
        }
        else if(left==right&&left!=-1){
            int[] newSubInterval=new int[2];
            newSubInterval[0]=Math.min(intervals[left][0],newInterval[0]);
            newSubInterval[1]=Math.max(intervals[left][1],newInterval[1]);
            intervals[left]=newSubInterval;
            return intervals;
        }
        else {
            int[] newSubInterval=new int[2];
            newSubInterval[0]=Math.min(intervals[left][0],newInterval[0]);
            newSubInterval[1]=Math.max(intervals[right][1],newInterval[1]);
            List<int[]> newIntervals=new ArrayList<>();
            for(int i=0;i<left;i++){
                newIntervals.add(intervals[i]);
            }
            newIntervals.add(newSubInterval);
            for(int i=right+1;i< intervals.length;i++){
                newIntervals.add(intervals[i]);
            }
            int length= newIntervals.size();
            int[][] res=new int[length][2];
            for(int i=0;i<length;i++){
                res[i]=newIntervals.get(i);
            }
            return res;
        }
    }
    public boolean isInInterval(int[] subinterval,int[] newInterval){
        if((newInterval[0]>=subinterval[0]&&newInterval[0]<=subinterval[1])||(newInterval[1]>=subinterval[0]&&newInterval[1]<=subinterval[1]))
            return true;
        if(newInterval[0]<=subinterval[0]&&newInterval[1]>=subinterval[1])
            return true;
        return false;
    }
}
