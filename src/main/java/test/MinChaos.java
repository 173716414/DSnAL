import java.util.Arrays;

public class MinChaos {

    public static int minChaos(int[] heights) {
        int n = heights.length;
        if (n <= 1) {
            return 0;
        }

        // 动态规划数组
        int[][] dp = new int[n][3];
        for (int[] row : dp) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        dp[0][0] = 0;

        for (int i = 1; i < n; i++) {
            // 不调整
            dp[i][0] = dp[i - 1][0] + Math.abs(heights[i] - heights[i - 1]);

            // 调整第 i 个鱼缸
            for (int j = 1; j < 3; j++) {
                for (int k = 0; k < i; k++) {
                    dp[i][j] = Math.min(dp[i][j], dp[k][j - 1] + Math.abs(heights[i] - heights[k]));
                }
            }

            // 调整第 i 和第 i-1 个鱼缸
            for (int j = 1; j < 3; j++) {
                for (int k = 0; k < i - 1; k++) {
                    dp[i][j] = Math.min(dp[i][j], dp[k][j - 1] + Math.abs(heights[i] - heights[k]) + Math.abs(heights[i - 1] - heights[k]));
                }
            }
        }

        return dp[n - 1][2];
    }

    public static void main(String[] args) {
        int[] heights1 = {1, 1, 4, 5, 1};
        System.out.println(minChaos(heights1));  // 输出最小混乱度

        int[] heights2 = {4, 1, 5, 1, 4};
        System.out.println(minChaos(heights2));  // 输出最小混乱度
    }
}