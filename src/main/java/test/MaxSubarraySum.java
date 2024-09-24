package test;

import java.util.*;

public class MaxSubarraySum {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 输入 n 和 q
        int n = sc.nextInt();
        int q = sc.nextInt();

        // 输入数组 a
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        // 前缀和数组
        long[] prefixSum = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            prefixSum[i] = prefixSum[i - 1] + a[i - 1];
        }

        // 存储每个长度的最大子数组和
        long[] maxSumForLength = new long[n + 1];
        Arrays.fill(maxSumForLength, Long.MIN_VALUE);

        // 计算每个长度的最大子数组和
        for (int length = 1; length <= n; length++) {
            long maxSum = Long.MIN_VALUE;
            // 使用滑动窗口遍历每个子数组
            for (int i = length; i <= n; i++) {
                long subarraySum = prefixSum[i] - prefixSum[i - length];
                maxSum = Math.max(maxSum, subarraySum);
            }
            maxSumForLength[length] = maxSum;
        }

        // 预处理每个长度的最大子数组和前缀最大值
        long[] maxSumPrefix = new long[n + 1];
        maxSumPrefix[0] = maxSumForLength[0];
        for (int i = 1; i <= n; i++) {
            maxSumPrefix[i] = Math.max(maxSumPrefix[i - 1], maxSumForLength[i]);
        }

        // 处理每个查询
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < q; i++) {
            int l = sc.nextInt();
            int r = sc.nextInt();

            // 查询 l 到 r 的最大值
            sb.append(maxSumPrefix[r] + "\n");
        }

        // 输出结果
        System.out.print(sb.toString());

        sc.close();
    }
}
