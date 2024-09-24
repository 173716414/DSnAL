package test;

import java.util.Arrays;

public class CoinChange {
    public static int coinChange(int[] coins, int amount) {
        // 定义dp数组，并初始化为最大值
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);  // 用一个不可能的大值填充，代表无法组成
        dp[0] = 0;  // 金额为0时，硬币数为0

        // 动态规划，逐步计算最少硬币数
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i - coin >= 0) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }

        // 如果dp[amount]没有被更新，说明无法组成该金额
        return dp[amount] > amount ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        int[] coins1 = {1, 2, 5};
        int amount1 = 11;
        System.out.println("最少硬币数: " + coinChange(coins1, amount1)); // 输出 3

        int[] coins2 = {2};
        int amount2 = 3;
        System.out.println("最少硬币数: " + coinChange(coins2, amount2)); // 输出 -1

        int[] coins3 = {1};
        int amount3 = 0;
        System.out.println("最少硬币数: " + coinChange(coins3, amount3)); // 输出 0
    }
}
