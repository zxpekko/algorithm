package dynamicprogramming;

/**
 * @Author:zxp
 * @Description:有一堆石头，用整数数组 stones 表示。其中 stones[i] 表示第 i 块石头的重量。
 *
 * 每一回合，从中选出任意两块石头，然后将它们一起粉碎。假设石头的重量分别为 x 和 y，且 x <= y。那么粉碎的可能结果如下：
 *
 * 如果 x == y，那么两块石头都会被完全粉碎；
 * 如果 x != y，那么重量为 x 的石头将会完全粉碎，而重量为 y 的石头新重量为 y-x。
 * 最后，最多只会剩下一块 石头。返回此石头 最小的可能重量 。如果没有石头剩下，就返回 0。
 *
 *
 *
 * 示例 1：
 *
 * 输入：stones = [2,7,4,1,8,1]
 * 输出：1
 * 解释：
 * 组合 2 和 4，得到 2，所以数组转化为 [2,7,1,8,1]，
 * 组合 7 和 8，得到 1，所以数组转化为 [2,1,1,1]，
 * 组合 2 和 1，得到 1，所以数组转化为 [1,1,1]，
 * 组合 1 和 1，得到 0，所以数组转化为 [1]，这就是最优值。
 * 示例 2：
 *
 * 输入：stones = [31,26,33,21,40]
 * 输出：5
 * @Date:9:24 2023/11/29
 */
public class LastStoneWeightII {
    public static void main(String[] args) {
        LastStoneWeightII lastStoneWeightII = new LastStoneWeightII();
        System.out.println(lastStoneWeightII.lastStoneWeightII(new int[]{31,26,33,21,40}));
    }
    public int lastStoneWeightII(int[] stones){
        //分析：尽可能的将石头快分成重量近似的两队，这样就可以最后碰撞时候重量更近。这是关键。
        //可以是近似sum/2的重量，也就是说将石头放入容量为sum/2的背包中，尽可能使得最后的价值最大，不一定装满，然后将这个背包中的价值（重量）和剩下的重量做差即为结果
        //因为必然可以碰撞到最后变成两个重量的差值，这也是最优结果。
        int n=stones.length;
        int sum=0;
        for(int i=0;i<n;i++){
            sum+=stones[i];
        }
        int capcity=sum/2;
        int[] dp = new int[capcity + 1];//这里我们使用滚动数组
        for(int i=0;i<n;i++){
            for(int j=capcity;j>=stones[i];j--){
                dp[j]=Math.max(dp[j],dp[j-stones[i]]+stones[i]);
            }
        }
        return sum-2*dp[capcity];
    }
}