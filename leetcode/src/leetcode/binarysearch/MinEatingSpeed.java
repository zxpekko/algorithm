package leetcode.binarysearch;

import java.lang.management.MonitorInfo;

/**
 * @Author:zxp
 * @Description:珂珂喜欢吃香蕉。这里有 n 堆香蕉，第 i 堆中有 piles[i] 根香蕉。警卫已经离开了，将在 h 小时后回来。
 *
 * 珂珂可以决定她吃香蕉的速度 k （单位：根/小时）。每个小时，她将会选择一堆香蕉，从中吃掉 k 根。如果这堆香蕉少于 k 根，她将吃掉这堆的所有香蕉，然后这一小时内不会再吃更多的香蕉。
 *
 * 珂珂喜欢慢慢吃，但仍然想在警卫回来前吃掉所有的香蕉。
 *
 * 返回她可以在 h 小时内吃掉所有香蕉的最小速度 k（k 为整数）。
 *
 *
 *
 * 示例 1：
 *
 * 输入：piles = [3,6,7,11], h = 8
 * 输出：4
 * 示例 2：
 *
 * 输入：piles = [30,11,23,4,20], h = 5
 * 输出：30
 * 示例 3：
 *
 * 输入：piles = [30,11,23,4,20], h = 6
 * 输出：23
 * @Date:9:57 2023/10/26
 */
public class MinEatingSpeed {
    public static void main(String[] args) {
        MinEatingSpeed minEatingSpeed = new MinEatingSpeed();
        System.out.println(minEatingSpeed.minEatingSpeed(new int[]{30,11,23,4,20}, 5));
    }
    public int minEatingSpeed(int[] piles, int h){
        int low=1;
        int high=0;
        for(int i=0;i<piles.length;i++){
            high=Math.max(high,piles[i]);
        }
        int k=high;
        while (low<high){
            int speed=low+((high-low)>>1);
//            int speed=(low+high)/2;
            int totalTime=countTime(piles,speed);
            if(totalTime<=h){
              k=speed;
              high=speed;
            }
            else
                low=speed+1;
        }
        return k;
    }
    public int countTime(int[] piles,int speed){
        int totalTime=0;
        for(int i=0;i< piles.length;i++){
            int time=(int)Math.ceil((double)piles[i]/speed);
//            System.out.println(time);
            totalTime+=time;
        }
        return totalTime;
    }
}
