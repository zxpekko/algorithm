package dynamicprogramming;

/**
 * @Author:zxp
 * @Description:给两个整数数组 nums1 和 nums2 ，返回 两个数组中 公共的 、长度最长的子数组的长度 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums1 = [1,2,3,2,1], nums2 = [3,2,1,4,7]
 * 输出：3
 * 解释：长度最长的公共子数组是 [3,2,1] 。
 * 示例 2：
 * <p>
 * 输入：nums1 = [0,0,0,0,0], nums2 = [0,0,0,0,0]
 * 输出：5
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums1.length, nums2.length <= 1000
 * 0 <= nums1[i], nums2[i] <= 100
 * @Date:9:49 2023/10/18
 */
public class FindLength {
    public static void main(String[] args) {
        int[] nums1 = {0, 0, 0, 0, 0};
        int[] nums2 = {0, 0, 0, 0, 0};
        FindLength findLength = new FindLength();
        System.out.println(findLength.findLengthⅢ(nums1, nums2));
    }

    public int findLength(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int[][] dp = new int[n1][n2];
        for (int i = n1 - 1; i >= 0; i--) {
            for (int j = n2 - 1; j >= 0; j--) {
                if (i == n1 - 1 || j == n2 - 1) {
                    if (nums1[i] == nums2[j])
                        dp[i][j] = 1;
                } else {
                    if (nums1[i] == nums2[j]) {
                        dp[i][j] = dp[i + 1][j + 1] + 1;
                    }
                }
            }
        }
        int max = dp[0][0];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                if (max < dp[i][j])
                    max = dp[i][j];
            }
        }
        return max;
    }

    public int findLengthⅡ(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int[][] dp = new int[n1][n2];
        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < n2; j++) {
                if (i == 0 || j == 0) {
                    if (nums1[i] == nums2[j])
                        dp[i][j] = 1;
                } else {
                    if (nums1[i] == nums2[j])
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                }
            }
        }
        int max = dp[0][0];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if (max < dp[i][j])
                    max = dp[i][j];
            }
        }
        return max;
    }

    public int findLengthⅢ(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            if (nums1[i - 1] == nums2[0])
                dp[i][1] = 1;
        }
        for (int i = 1; i <= n; i++) {
            if (nums2[i - 1] == nums1[0])
                dp[1][i] = 1;
        }//以上是初始化。dp[0][i]和dp[i][0]没有实际意义，可以赋值成0；dp[1][i]意思是关于nums中下标为0的情况。
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (nums1[i - 1] == nums2[j - 1])
                    dp[i][j] = dp[i - 1][j - 1] + 1;//关键,此处比较严格，因为else的情况不用考虑，这是因为它是严格的连续子序列，else的情况可以考虑的是子序列，不用连续的情况。
            }
        }
        int max = dp[0][0];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                max = Math.max(max, dp[i][j]);
            }
        }
        return max;
    }
}
