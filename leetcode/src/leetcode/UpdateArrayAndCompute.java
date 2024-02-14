package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author:zxp
 * @Description:
 * @Date:10:35 2023/7/30
 */
public class UpdateArrayAndCompute {
    public static void main(String[] args) {
        int[] nums1={1,0,1};
        int[] nums2={0,0,0};
        int[][] queries={{1,1,1},{2,1,0},{3,0,0}};
        UpdateArrayAndCompute updateArrayAndCompute = new UpdateArrayAndCompute();
//        long[] longs = updateArrayAndCompute.handleQuery(nums1, nums2, queries);
        for (long l : updateArrayAndCompute.handleQuery(nums1, nums2, queries)) {
            System.out.println(l);
        }

    }
    public long[] handleQuery(int[] nums1, int[] nums2, int[][] queries) {


        int Opration3Sum=0;
        for(int i=0;i< queries.length;i++){
            if(queries[i][0]==3)
                Opration3Sum++;
        }
//        System.out.println(Opration3Sum);
        long[] res = new long[Opration3Sum];
        List<Long> list=new ArrayList<>();
        for(int i=0;i< queries.length;i++){
            if(queries[i][0]==1){
                for(int j=queries[i][1];j<=queries[i][2];j++){
                    if(nums1[j]==0)
                        nums1[j]=1;
                    else if(nums1[j]==1)
                        nums1[j]=0;
                }
            }
            else if(queries[i][0]==2){
                for(int j=queries[i][2];j< nums2.length;j++){
                    nums2[j]=nums2[j]+nums1[j]*queries[i][1];
                }
            }
            else {
                long sum=0;
                for(int j=0;j< nums2.length;j++){
                    sum+=(long)nums2[j];
                }
                list.add(sum);
            }
        }
//        System.out.println(list.size());
        for(int i=0;i< list.size();i++){
            res[i]=list.get(i);
        }
//        res[0]=(long)sum;
        return res;
    }
}
