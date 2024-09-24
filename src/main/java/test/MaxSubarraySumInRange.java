package test;

import java.util.Scanner;

public class MaxSubarraySumInRange {
    static int n, q;
    static long[] a;
    static long[] prefixSum;
    static long[] maxSumOfLength;
    static int[][] st; // 稀疏表
    static int[] log2; // 预处理 log2

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        q = scanner.nextInt();
        a = new long[n];
        prefixSum = new long[n + 1];
        maxSumOfLength = new long[n + 1]; // 下标从1开始
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextLong();
            prefixSum[i + 1] = prefixSum[i] + a[i];
            maxSumOfLength[i + 1] = Long.MIN_VALUE; // 初始化为负无穷
        }

        // 预处理每个长度的子数组的最大和
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                int len = j - i;
                long sum = prefixSum[j] - prefixSum[i];
                if (sum > maxSumOfLength[len]) {
                    maxSumOfLength[len] = sum;
                }
            }
        }

        // 建立稀疏表
        buildSparseTable();

        // 回答每个询问
        for (int i = 0; i < q; i++) {
            int l = scanner.nextInt();
            int r = scanner.nextInt();
            long answer = query(l, r);
            System.out.println(answer);
        }
        scanner.close();
    }

    // 建立稀疏表
    static void buildSparseTable() {
        int maxLog = (int) (Math.log(n) / Math.log(2)) + 1;
        st = new int[n + 1][maxLog + 1];
        log2 = new int[n + 1];

        // 预处理 log2
        log2[1] = 0;
        for (int i = 2; i <= n; i++) {
            log2[i] = log2[i / 2] + 1;
        }

        // 初始化稀疏表的第一层
        for (int i = 1; i <= n; i++) {
            st[i][0] = i; // 存储下标，方便取值
        }

        // 动态规划填充稀疏表
        for (int j = 1; (1 << j) <= n; j++) {
            for (int i = 1; i + (1 << j) - 1 <= n; i++) {
                int x = st[i][j - 1];
                int y = st[i + (1 << (j - 1))][j - 1];
                st[i][j] = maxSumOfLength[x] >= maxSumOfLength[y] ? x : y;
            }
        }
    }

    // 区间查询，返回最大值
    static long query(int l, int r) {
        int len = r - l + 1;
        int k = log2[len];
        int x = st[l][k];
        int y = st[r - (1 << k) + 1][k];
        return Math.max(maxSumOfLength[x], maxSumOfLength[y]);
    }
}
