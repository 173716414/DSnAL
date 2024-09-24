package test;

import java.util.*;

public class SubsequenceWeightSum {
    private static final int MOD = 1000000007; // 10^9

    public static void main(String[] args) {
        // System.out.println(-3 % 100);
        // 示例输入
        int n = 6; // 数组长度
        int k = 2; // 子序列长度
        int[] arr = {1, 1, 4, 5, 1, 4};

        // 调用函数计算权值之和
        long sumOfWeights = calculateSumOfWeights(n, k, arr);
        if (sumOfWeights < 0) {
            sumOfWeights += MOD;
        }
        System.out.println("总权值之和（取模后）: " + sumOfWeights);
    }

    private static long calculateSumOfWeights(int n, int k, int[] arr) {
        List<int[]> subsequences = new ArrayList<>();
        generateSubsequences(arr, new int[k], 0, 0, k, subsequences);

        long totalWeight = 0;
        for (int[] subseq : subsequences) {
            long weight = calculateWeight(subseq);
            totalWeight = (totalWeight + weight) % MOD;
        }

        return totalWeight;
    }

    private static void generateSubsequences(int[] arr, int[] temp, int start, int index, int k, List<int[]> subsequences) {
        if (index == k) {
            subsequences.add(temp.clone());
            return;
        }

        for (int i = start; i <= arr.length - k + index; i++) {
            temp[index] = arr[i];
            generateSubsequences(arr, temp, i + 1, index + 1, k, subsequences);
        }
    }

    private static long calculateWeight(int[] subseq) {
        int minDiff = Integer.MAX_VALUE;
        int maxSum = Integer.MIN_VALUE;
        
        for (int i = 0; i < subseq.length; i++) {
            for (int j = 0; j < subseq.length; j++) {

                    minDiff = Math.min(minDiff, subseq[i] - subseq[j]);
                    maxSum = Math.max(maxSum, subseq[i] + subseq[j]);


            }
        }

        return (long) minDiff * maxSum;
    }
}
