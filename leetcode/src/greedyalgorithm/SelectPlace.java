package greedyalgorithm;

/**
 * @Author:zxp
 * @Description:在一条数轴上有 N
 *  家商店，它们的坐标分别为 A1∼AN
 * 。
 *
 * 现在需要在数轴上建立一家货仓，每天清晨，从货仓到每家商店都要运送一车商品。
 *
 * 为了提高效率，求把货仓建在何处，可以使得货仓到每家商店的距离之和最小。
 *
 * 输入格式
 * 第一行输入整数 N
 * 。
 *
 * 第二行 N
 *  个整数 A1∼AN
 * 。
 *
 * 输出格式
 * 输出一个整数，表示距离之和的最小值。
 *
 * 数据范围
 * 1≤N≤100000
 * ,
 * 0≤Ai≤40000
 * 输入样例：
 * 4
 * 6 2 9 1
 * 输出样例：
 * 12
 * @Date:11:09 2023/8/15
 */
public class SelectPlace {
    public static void main(String[] args) {
        int[] nums={6,2,9,1,3};
        SelectPlace selectPlace = new SelectPlace();
        int i = selectPlace.SelectPlace(nums);
        System.out.println(i);
    }
    public int SelectPlace(int[] nums){
        int maxIndex=getMaxIndex(nums);
        int minIndex=getMinIndex(nums);
        int minSum=1000000000;
        int minNum=-1;
        for(int i=nums[minIndex];i<=nums[maxIndex];i++){
            int CurrentSum=0;
            for(int j=0;j< nums.length;j++){
                CurrentSum+=Math.abs(i-nums[j]);
            }
            if(CurrentSum<minSum){
                minSum=CurrentSum;
                minNum=i;
            }

        }
        return minNum;
    }
    public int getMaxIndex(int[] nums){
        int maxIndex=0;
        for(int i=1;i< nums.length;i++){
            if(nums[i]>nums[maxIndex])
                maxIndex=i;
        }
        return maxIndex;
    }
    public int getMinIndex(int[] nums){
        int minIndex=0;
        for(int i=0;i< nums.length;i++){
            if(nums[i]<nums[minIndex])
                minIndex=i;
        }
        return minIndex;
    }

}
