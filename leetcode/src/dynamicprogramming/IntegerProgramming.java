package dynamicprogramming;

/**
 * @Author:zxp
 * @Description:整数划分。两种方法：动态规划，分治递归。两种思想的核心部分所采用的方法类似。
 * @Date:10:57 2023/7/20
 */
public class IntegerProgramming {
    public static void main(String[] args) {
        IntegerProgramming integerProgramming = new IntegerProgramming();

        int split = integerProgramming.split(5, 5);
        System.out.println(split);
        int i = integerProgramming.DynamicProgramming(2);
        System.out.println(i);

    }
    public int DynamicProgramming(int num){//dp[i][j]的含义是将i划分的方案中上限为j的方法数,最小的划分方案数字为1。
        int[][] dp = new int[num+1][num+1];
        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp.length;j++){
                if(i==1||j==1)
                    dp[i][j]=1;
                else if(i<j)
                    dp[i][j]=dp[i][i];
                else if(i==j)
                    dp[i][j]=1+dp[i][j-1];
                else
                    dp[i][j]=dp[i][j-1]+dp[i-j][j];
            }
        }

        return dp[num][num];
    }
    public int split(int num,int bound){
        if(num==1||bound==1)
            return 1;
        if(num<bound)
            return split(num,num);
        if(num==bound)
            return 1+split(num,num-1);

        return split(num,bound-1)+split(num-bound,bound);
    }
}
