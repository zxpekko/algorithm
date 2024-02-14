package dynamicprogramming;

/**
 * @Author:zxp
 * @Description:给定一个长度为 N
 *  的数列，求数值严格单调递增的子序列的长度最长是多少。
 *
 * 输入格式
 * 第一行包含整数 N
 * 。
 *
 * 第二行包含 N
 *  个整数，表示完整序列。
 *
 * 输出格式
 * 输出一个整数，表示最大长度。
 *
 * 数据范围
 * 1≤N≤1000
 * ，
 * −109≤数列中的数≤109
 * 输入样例：
 * 7
 * 3 1 2 1 8 5 6
 *
 *输出：2
 * @Date:18:17 2023/6/19
 */
public class LongestNumber {
    public static void main(String[] args) {
        int[] array = {3, 1, 2, 1,8, 5, 6};
        int i = LongestNumber.DynamicProgramming(7, array);
        System.out.println(i);
    }
    public static int DynamicProgramming(int totalNumber,int[] array){
        int[] dp = new int[totalNumber+1];//dp[i]代表以第i个数结尾的最大的递增子序列，
        // 如果第i个数比第i-1个大，则在dp[i-1]基础上加1，否则以自己为结尾的最大递增子序列长度为1，即重开
        dp[1]=1;
        for(int i=2;i<=totalNumber;i++){
            if(array[i-1]>array[i-2])
                dp[i]=dp[i-1]+1;
            else
                dp[i]=1;
        }
        int max=dp[0];
        for(int j=1;j< dp.length;j++){
            max=Math.max(max,dp[j]);
        }
        return max;
    }
}
