package test;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();

        while (T-- > 0) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            int x = scanner.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n - 1; i++) {
                a[i] = scanner.nextInt();
            }

            System.out.println(getMinCost(n, k, x, a));
        }

        scanner.close();
    }

    public static int getMinCost(int n, int k, int x, int[] a) {
        int[] dp = new int[n];
        dp[0] = 0;  // 初始化起始位置的成本为0

        Deque<Integer> deque = new ArrayDeque<>();
        deque.offer(0); // 初始索引入队

        for (int j = 1; j < n; j++) {
            if (!deque.isEmpty() && deque.peekFirst() < j - k) {
                deque.pollFirst(); // 移除超出范围的索引
            }

            dp[j] = dp[deque.peekFirst()] + x; // 使用当前最小成本索引更新dp[j]

            // 直接从前一个元素转移的情况
            dp[j] = Math.min(dp[j], dp[j-1] + a[j-1]);

            // 维护deque，保证队列从小到大排序
            while (!deque.isEmpty() && dp[deque.peekLast()] > dp[j]) {
                deque.pollLast();
            }
            deque.offer(j);
        }

        return dp[n - 1];
    }
}
