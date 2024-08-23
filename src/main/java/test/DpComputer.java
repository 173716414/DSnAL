package test;

/*
 *Author：Victor_htq
 *Package：test
 *Project：DSnAL
 *name：DpComputer
 *Date：2024/8/23  17:07
 *Filename：DpComputer
 */
import java.util.Scanner;

public class DpComputer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); // 零件数量
        int m = scanner.nextInt(); // 最大预算
        int[][] dp = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            int models = scanner.nextInt(); // 该零件的型号数量
            int[] prices = new int[models];
            int[] performances = new int[models];
            for (int j = 0; j < models; j++) {
                prices[j] = scanner.nextInt();
            }
            for (int j = 0; j < models; j++) {
                performances[j] = scanner.nextInt();
            }

            // 动态规划更新
            for (int budget = m; budget >= 0; budget--) {
                for (int j = 0; j < models; j++) {
                    if (budget >= prices[j]) {
                        dp[i][budget] = Math.max(dp[i][budget], dp[i - 1][budget - prices[j]] + performances[j]);
                    }
                }
            }
        }

        // 找到最大性能
        int result = 0;
        for (int budget = 0; budget <= m; budget++) {
            result = Math.max(result, dp[n][budget]);
        }

        // 判断是否可以组装
        if (result == 0) {
            System.out.println(-1);
        } else {
            System.out.println(result);
        }
    }
}

