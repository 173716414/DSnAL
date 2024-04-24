package ds.dp;

/*
 *Author：Victor_htq
 *Package：ds.dp
 *Project：DSnAL
 *name：BagProblem
 *Date：2024/4/22  14:42
 *Filename：BagProblem
 */
public class BagProblem {
    public static void main(String[] args) {
        int[] weight = {1, 3, 4};
        int[] value = {15, 20, 30};
        int bagSize = 4;
        testWeightBagProblem(weight, value, bagSize);
    }

    private static void testWeightBagProblem(int[] weight, int[] value, int bagSize) {
        int goods = weight.length;
        int[][] dp = new int[goods][bagSize + 1];

        for (int i = weight[0]; i <= bagSize; i++) {
            dp[0][i] = value[0];
        }

        for (int i = 1; i < goods; i++) {
            for (int j = 1; j <= bagSize; j++) {
                if (j < weight[i]) {
                    dp[i][j] = dp[i-1][j];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-weight[i]] + value[i]);
                }
            }
        }

        for (int i = 0; i < goods; i++) {
            for (int j = 0; j <= bagSize; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
    }
}
