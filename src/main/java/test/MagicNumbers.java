package test;

import java.util.Scanner;

public class MagicNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        System.out.println(findMaxMagicSum(nums, n, k));
    }

    public static int findMaxMagicSum(int[] nums, int n, int k) {
        int[] dp = new int[n];
        dp[0] = nums[0];

        int maxSum = dp[0];

        for (int i = 1; i < n; i++) {
            dp[i] = nums[i];
            if (i >= k) {
                dp[i] = Math.max(dp[i], nums[i] + dp[i - k]);
            }
            dp[i] = Math.max(dp[i], dp[i - 1]);
            maxSum = Math.max(maxSum, dp[i]);
        }

        return maxSum;
    }
}
