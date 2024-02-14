package dynamicprogramming;

/**
 * @Author:zxp
 * @Description:给你一个字符串 s ，找出其中最长的回文子序列，并返回该序列的长度。
 *
 * 子序列定义为：不改变剩余字符顺序的情况下，删除某些字符或者不删除任何字符形成的一个序列。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "bbbab"
 * 输出：4
 * 解释：一个可能的最长回文子序列为 "bbbb" 。
 * 示例 2：
 *
 * 输入：s = "cbbd"
 * 输出：2
 * 解释：一个可能的最长回文子序列为 "bb" 。
 *
 *
 * 提示：
 *
 * 1 <= s.length <= 1000
 * s 仅由小写英文字母组成
 * @Date:17:47 2023/12/16
 */
public class LongestPalindromeSubseq {
    public static void main(String[] args) {
        LongestPalindromeSubseq longestPalindromeSubseq = new LongestPalindromeSubseq();
        System.out.println(longestPalindromeSubseq.longestPalindromeSubseq("bbbab"));
    }
    public int longestPalindromeSubseq(String s){
        int n=s.length();
        int[][] dp = new int[n][n];//dp[i][j]表示i到j的字符串的最长回文子序列的长度
        for(int i=0;i<n;i++){
            dp[i][i]=1;
        }
        for(int i=n-1;i>=0;i--){
            for(int j=i+1;j<n;j++){//j=i的情况已经在初始化中考虑过了。
                if(s.charAt(i)==s.charAt(j)){
                    dp[i][j]=dp[i+1][j-1]+2;
                }
                else
                    dp[i][j]=Math.max(dp[i+1][j],dp[i][j-1]);
            }
        }
//        int max=dp[0][0];
//        for(int i=0;i<n;i++){
//            for(int j=0;j<n;j++){
//                max=Math.max(max,dp[i][j]);
//            }
//        }
        return dp[0][n-1];
    }
}
//class TreeNode{
//    int val;
//    TreeNode left;
//    TreeNode right;
//    public TreeNode(TreeNode left,TreeNode right,int val){
//        this.left=left;
//        this.right=right;
//        this.val=val;
//    }
//    public TreeNode(int val){
//        this.val=val;
//    }
//}