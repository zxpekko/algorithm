package dynamicprogramming;

import java.util.Map;

/**
 * @Author:zxp
 * @Description:354  本方法动态规划时间复杂度O(n^2)，也是官方给出的一个解法，但是超出时间限制，算法正确。
 *
 * 给你一个二维整数数组 envelopes ，其中 envelopes[i] = [wi, hi] ，表示第 i 个信封的宽度和高度。
 *
 * 当另一个信封的宽度和高度都比这个信封大的时候，这个信封就可以放进另一个信封里，如同俄罗斯套娃一样。
 *
 * 请计算 最多能有多少个 信封能组成一组“俄罗斯套娃”信封（即可以把一个信封放到另一个信封里面）。
 *
 * 注意：不允许旋转信封。
 *
 *
 * 示例 1：
 *
 * 输入：envelopes = [[5,4],[6,4],[6,7],[2,3]]
 * 输出：3
 * 解释：最多信封的个数为 3, 组合为: [2,3] => [5,4] => [6,7]。
 * 示例 2：
 *
 * 输入：envelopes = [[1,1],[1,1],[1,1]]
 * 输出：1
 *
 *
 * 提示：
 *
 * 1 <= envelopes.length <= 105
 * envelopes[i].length == 2
 * 1 <= wi, hi <= 105
 * @Date:10:43 2023/9/22
 */
public class MaxEnvelopes {
    public static void main(String[] args) {
        int[][] env={{2,100},{3,200},{4,300},{5,500},{5,400},{5,250},{6,370},{6,360},{7,380}};
        MaxEnvelopes maxEnvelopes = new MaxEnvelopes();
        System.out.println(maxEnvelopes.maxEnvelopes(env));
    }
    public int maxEnvelopes(int[][] envelopes){
        if(envelopes.length==1){
            return 1;
        }
        for(int i=0;i<envelopes.length-1;i++){
            for(int j=0;j<envelopes.length-i-1;j++){
                if(envelopes[j+1][0]<envelopes[j][0]){
                    int[] temp=new int[2];
                    temp=envelopes[j+1];
                    envelopes[j+1]=envelopes[j];
                    envelopes[j]=temp;
                }
                else if(envelopes[j+1][0]==envelopes[j][0]&&envelopes[j+1][1]>envelopes[j][1]){
                    int[] temp=new int[2];
                    temp=envelopes[j+1];
                    envelopes[j+1]=envelopes[j];
                    envelopes[j]=temp;
                }
            }
        }
        int[] dp=new int[envelopes.length];
        for(int i=0;i<envelopes.length;i++){
//            if(i==0)
//                dp[i]=1;
            dp[i]=1;
            for(int j=i-1;j>=0;j--){
                if(envelopes[j][1]<envelopes[i][1]){
                    dp[i]=Math.max(dp[i],dp[j]+1 );
                }
            }
        }
        int max=dp[0];
        for(int i=0;i<dp.length;i++){
            if(max<dp[i])
                max=dp[i];
        }
        return max;
    }
}
