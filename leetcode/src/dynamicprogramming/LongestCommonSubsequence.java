package dynamicprogramming;

/**
 * @Author:zxp
 * @Description:给定两个长度分别为 N
 *  和 M
 *  的字符串 A
 *  和 B
 * ，求既是 A
 *  的子序列又是 B
 *  的子序列的字符串长度最长是多少。
 *
 * 输入格式
 * 第一行包含两个整数 N
 *  和 M
 * 。
 *
 * 第二行包含一个长度为 N
 *  的字符串，表示字符串 A
 * 。
 *
 * 第三行包含一个长度为 M
 *  的字符串，表示字符串 B
 * 。
 *
 * 字符串均由小写字母构成。
 *
 * 输出格式
 * 输出一个整数，表示最大长度。
 * 给定两个字符串 text1 和 text2，返回这两个字符串的最长 公共子序列 的长度。如果不存在 公共子序列 ，返回 0 。
 *
 * 一个字符串的 子序列 是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。
 *
 * 例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。
 * 两个字符串的 公共子序列 是这两个字符串所共同拥有的子序列。
 *
 *
 *
 * 示例 1：
 *
 * 输入：text1 = "abcde", text2 = "ace"
 * 输出：3
 * 解释：最长公共子序列是 "ace" ，它的长度为 3 。
 * 示例 2：
 *
 * 输入：text1 = "abc", text2 = "abc"
 * 输出：3
 * 解释：最长公共子序列是 "abc" ，它的长度为 3 。
 * 示例 3：
 *
 * 输入：text1 = "abc", text2 = "def"
 * 输出：0
 * 解释：两个字符串没有公共子序列，返回 0 。
 * @Date:14:24 2023/6/26
 */
//public class LongestCommonSubsequence {
//    public static void main(String[] args) {
//        int i = LongestCommonSubsequence.DynamicProgramming("badaacc", "acdbadaab");
////        int[][] ints = LongestCommonSubsequence.DynamicProgramming("abadac", "acdbadacab");
////        for(int i=0;i< ints.length;i++){
////            for(int j=0;j<ints[i].length;j++){
////                System.out.print(ints[i][j]);
////            }
////            System.out.println();
////        }
//        System.out.println(i);
//    }
//    public static int DynamicProgramming(String str1,String str2){
//        int[][] dp = new int[str1.length() + 1][str2.length() + 1];
//        //dp[i][j]代表str1的前i个字符和str2的前j个字符的最长公共字符串的长度
//        //只需要比较ij的最后一个字符是否相等即可，若相等，dp[i][j]=dp[i-1][j-1]+1,若不等，dp[i][j]=max(dp[i-1][j],dp[i][j-1]),
//        // 意思是去掉一个末尾字符，比较剩下的最大的
//        for(int i=1;i<=str1.length();i++){
//            for(int j=1;j<=str2.length();j++){
//                if(str1.charAt(i-1)==str2.charAt(j-1))
//                    dp[i][j]=dp[i-1][j-1]+1;
//                else
//                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
////                dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
////                if(str1.charAt(i-1)==str2.charAt(j-1))
////                    dp[i][j]=Math.max(dp[i][j],dp[i-1][j-1]+1);
//            }
//        }
//        return dp[str1.length()][str2.length()];
//    }
//}
public class LongestCommonSubsequence {
    public static void main(String[] args) {
        String str1 = "abc";
        String str2 = "def";
        int length = dynamicProgramming(str1, str2);
        LongestCommonSubsequence longestCommonSubsequence = new LongestCommonSubsequence();
        System.out.println(longestCommonSubsequence.longestCommonSubsequence(str1, str2));
        System.out.println("最长公共子序列的长度为：" + length);
    }

    public static int dynamicProgramming(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();

        // 创建动态规划表
        int[][] dp = new int[m + 1][n + 1];

        // 填充动态规划表
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[m][n];
    }
    public int longestCommonSubsequence(String text1, String text2){
        int m=text1.length();
        int n=text2.length();
        int[][] dp = new int[m + 1][n + 1];//dp[i][j]表示text1以i-1结尾，text2以j-1结尾的最大公共子序列
//        for(int i=1;i<=m;i++){
//            if(text1.charAt(i-1)==text2.charAt(0))
//                dp[i][1]=1;
//        }
//        for(int i=1;i<=n;i++){
//            if(text2.charAt(i-1)==text1.charAt(0))
//                dp[1][i]=1;
//        }//初始化
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(text1.charAt(i-1)==text2.charAt(j-1))
                    dp[i][j]=dp[i-1][j-1]+1;
                else
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);//这边不能加dp[i-1][j-1]因为这两个值不相等的时候，
                // 只需要一个字符串的下标向前就行，两个都向前会丢失解，这么想，text1.charAt(i-1)!=text2.charAt(j-1)
                // 不代表text1.charAt(i-1)！=text2.charAt(j-2)，或者text1.charAt(i-2)！=text2.charAt(j-1)，因此这两种情况都需要考虑，
                // 而text1.charAt(i-2)==text2.charAt(j-2)就算考虑进去也是最小的。
            }
        }
        return dp[m][n];
    }
}