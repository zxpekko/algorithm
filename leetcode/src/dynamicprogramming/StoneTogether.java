package dynamicprogramming;

import org.junit.Test;

/**
 * @Author:zxp
 * @Description:设有 N
 *  堆石子排成一排，其编号为 1,2,3,…,N
 * 。
 *
 * 每堆石子有一定的质量，可以用一个整数来描述，现在要将这 N
 *  堆石子合并成为一堆。
 *
 * 每次只能合并相邻的两堆，合并的代价为这两堆石子的质量之和，合并后与这两堆石子相邻的石子将和新堆相邻，合并时由于选择的顺序不同，合并的总代价也不相同。
 *
 * 例如有 4
 *  堆石子分别为 1 3 5 2， 我们可以先合并 1、2
 *  堆，代价为 4
 * ，得到 4 5 2， 又合并 1、2
 *  堆，代价为 9
 * ，得到 9 2 ，再合并得到 11
 * ，总代价为 4+9+11=24
 * ；
 *
 * 如果第二步是先合并 2、3
 *  堆，则代价为 7
 * ，得到 4 7，最后一次合并代价为 11
 * ，总代价为 4+7+11=22
 * 。
 *
 * 问题是：找出一种合理的方法，使总的代价最小，输出最小代价。
 *
 * 输入格式
 * 第一行一个数 N
 *  表示石子的堆数 N
 * 。
 *
 * 第二行 N
 *  个数，表示每堆石子的质量(均不超过 1000
 * )。
 *
 * 输出格式
 * 输出一个整数，表示最小代价。
 * @Date:11:51 2023/6/27
 */
public class StoneTogether {
    public static void main(String[] args) {
        int i = StoneTogether.DynamicProgramming(new int[]{1, 3, 5, 2});
        System.out.println(i);
    }
    public static int DynamicProgramming(int[] stones){
        int[][] dp = new int[stones.length + 1][stones.length+1];
//        int[][] weight = new int[stones.length][stones.length];
//        for(int i=0;i< stones.length;i++){
//            for(int j=0;j<stones.length;j++){
//                if(i==j)
//                    weight[i][j]=0;
//                else{
//                    weight[i][j]=stones[i]+stones[j];
//                    weight[j][i]=stones[i]+stones[j];
//                }
//            }
//        }
        int[] weight = new int[stones.length + 1];
        for(int i=1;i<= stones.length;i++){
            weight[i]=weight[i-1]+stones[i-1];
        }
//        for(int i=0;i< dp.length;i++){
//            for(int j=0;j<dp.length;j++){
//                dp[i][j]=10000000;
//            }
//        }
//        System.out.println(Arrays.toString(weight));
        for(int len=1;len<= stones.length;len++){
            for(int i=1;i+len-1<=stones.length;i++){
                int j=i+len-1;
                if(len==1){
                    dp[i][j]=0;
                    continue;
                }
                dp[i][j]=1000000;
                for(int k=i;k<=j-1;k++){
                    dp[i][j]=Math.min(dp[i][j],dp[i][k]+dp[k+1][j]+weight[j]-weight[i-1]);
                }

            }
        }
//        for(int i=0;i<dp.length;i++){
//            for(int j=0;j<dp[i].length;j++){
//                System.out.print(dp[i][j]);
//            }
//            System.out.println();
//        }
        return dp[1][stones.length];
    }
    @Test
    public void test(){
        double pow = Math.pow(10, 9);
        System.out.println(pow);
    }
}
