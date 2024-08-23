public class LongestPalindromicSubsequence {
    public static int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];

        // 初始化单个字符的回文子序列长度为1
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }

        // 动态规划计算dp数组
        for (int length = 2; length <= n; length++) { // 子序列长度从2到n
            for (int i = 0; i <= n - length; i++) {
                int j = i + length - 1;
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[0][n - 1];
    }

    public static void main(String[] args) {
        // 示例1
        String s1 = "bbbab";
        System.out.println(longestPalindromeSubseq(s1));  // 输出: 4

        // 示例2
        String s2 = "cbbd";
        System.out.println(longestPalindromeSubseq(s2));  // 输出: 2
    }
}
