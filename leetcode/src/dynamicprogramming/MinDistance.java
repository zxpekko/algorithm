package dynamicprogramming;

/**
 * @Author:zxp
 * @Description:给定两个单词 word1 和 word2 ，返回使得 word1 和  word2 相同所需的最小步数。
 *
 * 每步 可以删除任意一个字符串中的一个字符。
 *
 *
 *
 * 示例 1：
 *
 * 输入: word1 = "sea", word2 = "eat"
 * 输出: 2
 * 解释: 第一步将 "sea" 变为 "ea" ，第二步将 "eat "变为 "ea"
 * 示例  2:
 *
 * 输入：word1 = "leetcode", word2 = "etco"
 * 输出：4
 *
 *
 * 提示：
 *
 * 1 <= word1.length, word2.length <= 500
 * word1 和 word2 只包含小写英文字母
 * @Date:20:18 2023/12/14
 */
public class MinDistance {
    public static void main(String[] args) {
        MinDistance minDistance = new MinDistance();
        System.out.println(minDistance.minDistance("leetcode", "etco"));
    }
    public int minDistance(String word1, String word2){
        int m=word1.length();
        int n=word2.length();
        int[][] dp = new int[m + 1][n + 1];
        for(int i=0;i<=m;i++){
            dp[i][0]=i;
        }
        for(int j=0;j<=n;j++){
            dp[0][j]=j;
        }//两步初始化
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(word1.charAt(i-1)==word2.charAt(j-1))
                    dp[i][j]=dp[i-1][j-1];//若相等，则不用删除这两个元素，一起向前即可
                else
                    dp[i][j]=Math.min(dp[i-1][j]+1,dp[i][j-1]+1);//若不相等，则可以删除前者字符，也可删除后者字符，
                // 所以这边要计算谁更小，删前者字符就为dp[i-1][j]+1,加1是删除的操作，删后者字符就为dp[i][j-1]+1,加1是删除的操作。
            }
        }
        return dp[m][n];
    }


}
