package test;

public class MinCostToZeroSum {

    public static int minCostToZeroSum(int[] a, int x, int y, int z) {
        int n = a.length;
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        dp[0] = 0;

        for (int i = 1; i <= n; i++) {
            // Case 1: Delete the first element
            int sum = 0;
            for (int j = 1; j < i; j++) {
                sum += a[j];
            }
            dp[i] = Math.min(dp[i], dp[0] + x + z * sum);

            // Case 2: Delete the last element
            dp[i] = Math.min(dp[i], dp[i - 1] + y);

            // Case 3: Decrease all elements by 1
            dp[i] = Math.min(dp[i], dp[i - 1] + z);
        }

        return dp[n];
    }

    public static void main(String[] args) {
        int[] a = {5, 3, 4, 5, 7};
        int x = 3;
        int y = 3;
        int z = 2;
        System.out.println(minCostToZeroSum(a, x, y, z));  // Output: the minimum cost
    }
}