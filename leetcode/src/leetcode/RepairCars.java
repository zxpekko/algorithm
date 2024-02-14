package leetcode;

/**
 * @Author:zxp
 * @Description:给你一个整数数组 ranks ，表示一些机械工的 能力值 。ranksi 是第 i 位机械工的能力值。能力值为 r 的机械工可以在 r * n2 分钟内修好 n 辆车。
 *
 * 同时给你一个整数 cars ，表示总共需要修理的汽车数目。
 *
 * 请你返回修理所有汽车 最少 需要多少时间。
 *
 * 注意：所有机械工可以同时修理汽车。
 *
 *
 *
 * 示例 1：
 *
 * 输入：ranks = [4,2,3,1], cars = 10
 * 输出：16
 * 解释：
 * - 第一位机械工修 2 辆车，需要 4 * 2 * 2 = 16 分钟。
 * - 第二位机械工修 2 辆车，需要 2 * 2 * 2 = 8 分钟。
 * - 第三位机械工修 2 辆车，需要 3 * 2 * 2 = 12 分钟。
 * - 第四位机械工修 4 辆车，需要 1 * 4 * 4 = 16 分钟。
 * 16 分钟是修理完所有车需要的最少时间。
 * 示例 2：
 *
 * 输入：ranks = [5,1,8], cars = 6
 * 输出：16
 * 解释：
 * - 第一位机械工修 1 辆车，需要 5 * 1 * 1 = 5 分钟。
 * - 第二位机械工修 4 辆车，需要 1 * 4 * 4 = 16 分钟。
 * - 第三位机械工修 1 辆车，需要 8 * 1 * 1 = 8 分钟。
 * 16 分钟时修理完所有车需要的最少时间。
 *
 *
 * 提示：
 *
 * 1 <= ranks.length <= 105
 * 1 <= ranks[i] <= 100
 * 1 <= cars <= 106
 * @Date:10:12 2023/9/10
 */
public class RepairCars {
    public static void main(String[] args) {
        int[] ranks={31,31,5,19,19,10,31,18,19,3,16,20,4,16,2,25,10,16,23,18,21,23,28,6,7,29,11,11,19,20,24,19,26,12,29,29,1,14,17,26,24,7,11,28,22,14,31,12,3,19,16,26,11};
        RepairCars repairCars = new RepairCars();
        System.out.println(repairCars.repairCars(ranks, 736185));
    }
    public long repairCars(int[] ranks, int cars){
//        if(isSame(ranks)){
//            int eachcar=cars/ ranks.length;
//            return ranks[0]*eachcar*eachcar;
//        }
        int minIndex = getMinIndex(ranks);
        long low=0;
//        System.out.println(ranks[maxIndex]);
        long high=(long)ranks[minIndex]*cars*cars;
//        long high=Integer.MAX_VALUE;

//        System.out.println(high);
        long totalTime=0;
        while (low+1<high){
            long mid=(low+high)/2;
            int totalCars=0;
            for(int i=0;i<ranks.length;i++){
                double sqrt = Math.sqrt(mid / ranks[i]);
                long cur=(long) sqrt;
                totalCars+=cur;
            }
            if(totalCars>=cars){
//                System.out.println("run");
//                totalTime=mid;
                high=mid;
            }
            else
                low=mid;
        }
        return high;
    }
    public int getMinIndex(int[] ranks){
        int minIndex=0;
        for(int i=0;i<ranks.length;i++){
            if(ranks[i]<ranks[minIndex])
                minIndex=i;
        }
        return minIndex;
    }
    public boolean isSame(int[] ranks){
        int a=ranks[0];
        for(int i=0;i< ranks.length;i++){
            if(a!=ranks[i])
                return false;
        }
        return true;
    }

}