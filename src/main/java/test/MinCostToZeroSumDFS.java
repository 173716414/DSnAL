import java.util.HashMap;
import java.util.Map;

public class MinCostToZeroSumDFS {

    public static int minCostToZeroSum(int[] a, int x, int y, int z) {
        Map<String, Integer> memo = new HashMap<>();
        return dfs(a, x, y, z, 0, 0, memo);
    }

    private static int dfs(int[] a, int x, int y, int z, int index, int currentSum, Map<String, Integer> memo) {
        // Base case: if the currentSum is 0 and we have processed all elements
        if (currentSum == 0 && index == a.length) {
            return 0;
        }
        // If we have processed all elements but the sum is not 0, this path is invalid
        if (index == a.length) {
            return Integer.MAX_VALUE;
        }

        // Create a unique key for memoization
        String key = index + "-" + currentSum;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        // Option 1: Delete the first element
        int costDeleteFirst = Integer.MAX_VALUE;
        if (index == 0) {
            costDeleteFirst = x + dfs(a, x, y, z, index + 1, currentSum - a[index], memo);
        }

        // Option 2: Delete the last element
        int costDeleteLast = Integer.MAX_VALUE;
        if (index == a.length - 1) {
            costDeleteLast = y + dfs(a, x, y, z, index + 1, currentSum - a[index], memo);
        }

        // Option 3: Decrease all elements by 1
        int newSum = currentSum;
        for (int i = index; i < a.length; i++) {
            if (a[i] > 0) {
                a[i]--;
                newSum--;
            }
        }
        int costDecreaseAll = z + dfs(a, x, y, z, index, newSum, memo);
        for (int i = index; i < a.length; i++) {
            if (a[i] >= 0) {
                a[i]++;
            }
        }

        // Find the minimum cost of the three options
        int minCost = Math.min(costDeleteFirst, Math.min(costDeleteLast, costDecreaseAll));
        memo.put(key, minCost);
        return minCost;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5};
        int x = 1;
        int y = 1;
        int z = 1;
        System.out.println(minCostToZeroSum(a, x, y, z));  // Output: the minimum cost
    }
}