package dynamicprogramming;
/**
    *@Author:zxp
    *@Description:给你一个二进制字符串数组 strs 和两个整数 m 和 n 。
 *
 * 请你找出并返回 strs 的最大子集的长度，该子集中 最多 有 m 个 0 和 n 个 1 。
 *
 * 如果 x 的所有元素也是 y 的元素，集合 x 是集合 y 的 子集 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：strs = ["10", "0001", "111001", "1", "0"], m = 5, n = 3
 * 输出：4
 * 解释：最多有 5 个 0 和 3 个 1 的最大子集是 {"10","0001","1","0"} ，因此答案是 4 。
 * 其他满足题意但较小的子集包括 {"0001","1"} 和 {"10","1","0"} 。{"111001"} 不满足题意，因为它含 4 个 1 ，大于 n 的值 3 。
 * 示例 2：
 *
 * 输入：strs = ["10", "0", "1"], m = 1, n = 1
 * 输出：2
 * 解释：最大的子集是 {"0", "1"} ，所以答案是 2 。
    *@Date:13:39 2023/12/1
*/
public class FindMaxForm {
    public static void main(String[] args) {
        String[] strings = {"10", "0", "1"};
        FindMaxForm findMaxForm = new FindMaxForm();
        System.out.println(findMaxForm.findMaxForm(strings, 1, 1));
    }
    public int findMaxForm(String[] strs, int m, int n){
        int[][] dp = new int[m + 1][n + 1];//dp[i][j]代表i个0和j个1的背包能装的最多字符串数量，将问题看成向背包中加入物品，只不过是物品有两个维度，0和1.
        for(int k=0;k< strs.length;k++){
            int[] result = ZeroOnes(strs[k]);
            for(int i=m;i>=result[0];i--){
                for(int j=n;j>=result[1];j--){
                        dp[i][j]=Math.max(dp[i][j],dp[i-result[0]][j-result[1]]+1);
                    }
                }
            }
        return dp[m][n];
    }
    public int ZeroCount(String str){
        int sum=0;
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)=='0')
                sum++;
        }
        return sum;
    }
    public int OneCount(String str){
        int sum=0;
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)=='1')
                sum++;
        }
        return sum;
    }
    public int[] ZeroOnes(String str){
        int[] result = new int[2];
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)=='0')
                result[0]++;
            else
                result[1]++;
        }
        return result;
    }
}
