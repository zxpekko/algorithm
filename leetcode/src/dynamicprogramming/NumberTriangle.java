package dynamicprogramming;

/**
 * @Author:zxp
 * @Description:给定一个如下图所示的数字三角形，从顶部出发，在每一结点可以选择移动至其左下方的结点或移动至其右下方的结点，一直走到底层，要求找出一条路径，使路径上的数字的和最大。
 *
 *         7
 *       3   8
 *     8   1   0
 *   2   7   4   4
 * 4   5   2   6   5
 * 输入格式
 * 第一行包含整数 n
 * ，表示数字三角形的层数。
 *
 * 接下来 n
 *  行，每行包含若干整数，其中第 i
 *  行表示数字三角形第 i
 *  层包含的整数。
 *
 * 输出格式
 * 输出一个整数，表示最大的路径数字和。
 *
 * 数据范围
 * 1≤n≤500
 * ,
 * −10000≤三角形中的整数≤10000
 * @Date:13:45 2023/6/17
 */
public class NumberTriangle {
    public static void main(String[] args) {
        int[][] array = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};
        int i = NumberTriangle.DynamicRectangle(5, array);
        System.out.println(i);
    }
    public static int DynamicRectangle(int n,int[][] array){
        int[][] dp = new int[n + 1][n + 1];//dp[i][j]代表第i行第j的位置的最大路径
        for(int i=1;i<=n;i++){
            dp[n][i]=array[n-1][i-1];
        }
        for(int i=n;i>1;i--){
            for(int j=1;j<i;j++){
//                if(array[i-1][j-1]>array[i-1][j])
                if(dp[i][j]>dp[i][j+1])
                    dp[i-1][j]=dp[i][j]+array[i-2][j-1];
                else
                    dp[i-1][j]=dp[i][j+1]+array[i-2][j-1];
            }
        }

        return dp[1][1];
    }
}
