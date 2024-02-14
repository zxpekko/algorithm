package dynamicprogramming;

/**
 * @Author:zxp
 * @Description:给你两个单词 word1 和 word2， 请返回将 word1 转换成 word2 所使用的最少操作数  。
 *
 * 你可以对一个单词进行如下三种操作：
 *
 * 插入一个字符
 * 删除一个字符
 * 替换一个字符
 *
 *
 * 示例 1：
 *
 * 输入：word1 = "horse", word2 = "ros"
 * 输出：3
 * 解释：
 * horse -> rorse (将 'h' 替换为 'r')
 * rorse -> rose (删除 'r')
 * rose -> ros (删除 'e')
 * 示例 2：
 *
 * 输入：word1 = "intention", word2 = "execution"
 * 输出：5
 * 解释：
 * intention -> inention (删除 't')
 * inention -> enention (将 'i' 替换为 'e')
 * enention -> exention (将 'n' 替换为 'x')
 * exention -> exection (将 'n' 替换为 'c')
 * exection -> execution (插入 'u')
 * @Date:16:02 2023/6/3
 */
public class EditingDistance {
    public static void main(String[] args) {
        EditingDistance editingDistance = new EditingDistance();
        int i = editingDistance.minDistance("intention", "execution");
        int j = editingDistance.minDistanceⅡ("intention", "execution");
        System.out.println(i);
        System.out.println(j);
    }

    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int[][] ints = new int[m + 1][n + 1];
        int i, j;
        for (i = 0; i < m + 1; i++) {
            ints[i][0] = i;
        }
        for (i = 0; i < n + 1; i++) {
            ints[0][i] = i;
        }
        for (i = 1; i < m + 1; i++) {
            for (j = 1; j < n + 1; j++) {
                if (word1.charAt(i-1) == word2.charAt(j-1))
                    ints[i][j] = ints[i - 1][j - 1];
                else
                    ints[i][j] = 1 + Math.min(ints[i - 1][j], Math.min(ints[i - 1][j - 1], ints[i][j - 1]));

            }
        }
        return ints[m][n];
    }
    public int minDistanceⅡ(String word1, String word2){
        int m=word1.length();
        int n=word2.length();
        int[][] dp = new int[m + 1][n + 1];
        for(int i=0;i<=m;i++){
            dp[i][0]=i;
        }
        for(int j=0;j<=n;j++){
            dp[0][j]=j;
        }
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(word1.charAt(i-1)==word2.charAt(j-1))
                    dp[i][j]=dp[i-1][j-1];
                else
                    dp[i][j]=Math.min(Math.min(dp[i-1][j]+1,dp[i-1][j-1]+1),dp[i][j-1]+1);//增加和删除是相反的操作，因此第一个和第三个递推公式已经包含。
            }
        }
        return dp[m][n];
    }
}