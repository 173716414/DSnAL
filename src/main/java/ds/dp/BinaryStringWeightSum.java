package ds.dp;

public class BinaryStringWeightSum {
    public static void main(String[] args) {
        int n = 100000000; // 例如，长度为 6
        System.out.println("Total weight of binary strings of length " + n + ": " + totalWeightOfBinaryStrings(n));
    }

    public static long totalWeightOfBinaryStrings(int n) {
        if (n < 2) {
            return 0; // 如果 n < 2，没有相邻的对，权值和为 0
        }

        long[][] dp = new long[n + 1][2];

        // 初始化
        dp[1][0] = 0;
        dp[1][1] = 0;
        dp[2][1] = 1;
        dp[2][0] = 0;
        // 填充 dp 表
        for (int i = 3; i <= n; i++) {
            dp[i][0] = dp[i - 1][0] + dp[i - 1][1] % 1000000007;
            dp[i][1] = (long) (dp[i - 1][0] + dp[i - 1][1] + Math.pow(2, i-2)) % 1000000007;

        }

        // 总权值是以 0 和 1 结尾的长度为 n 的串的权值之和
        return (dp[n][0] + dp[n][1])% 1000000007;
    }
}
