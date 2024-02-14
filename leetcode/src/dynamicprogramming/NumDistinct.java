package dynamicprogramming;

import java.util.Arrays;

/**
 * @Author:zxp
 * @Description:给你两个字符串 s 和 t ，统计并返回在 s 的 子序列 中 t 出现的个数，结果需要对 109 + 7 取模。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "rabbbit", t = "rabbit"
 * 输出：3
 * 解释：
 * 如下所示, 有 3 种可以从 s 中得到 "rabbit" 的方案。
 * rabbbit
 * rabbbit
 * rabbbit
 * 示例 2：
 *
 * 输入：s = "babgbag", t = "bag"
 * 输出：5
 * 解释：
 * 如下所示, 有 5 种可以从 s 中得到 "bag" 的方案。
 * babgbag
 * babgbag
 * babgbag
 * babgbag
 * babgbag
 *
 *
 * 提示：
 *
 * 1 <= s.length, t.length <= 1000
 * s 和 t 由英文字母组成
 * @Date:10:24 2023/12/14
 */
public class NumDistinct {
    public static void main(String[] args) {
        NumDistinct numDistinct = new NumDistinct();
        System.out.println(numDistinct.numDistinct("babgbag", "bag"));
    }
    public int numDistinct(String s, String t){
        int m=s.length();
        int n=t.length();
        int[][] dp = new int[m + 1][n + 1];//dp[i][j]表示以s中i-1，t中j-1结尾的字符，t出现的次数。
        for(int i=0;i<=m;i++){
            dp[i][0]=1;
        }
        for(int i=0;i<=n;i++){
            dp[0][i]=0;
        }
        dp[0][0]=1;
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(s.charAt(i-1)==t.charAt(j-1))
                    dp[i][j]=dp[i-1][j-1]+dp[i-1][j];
                else
                    dp[i][j]=dp[i-1][j];
            }
        }

        return dp[m][n];
    }
}
