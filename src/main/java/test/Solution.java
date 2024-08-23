package test;

import java.util.Arrays;

public class Solution {
    public int[] minNumber(int[] nums1, int[] nums2, int k) {
        int m = nums1.length, n = nums2.length;
        int[] minSubsequence = new int[k];
        Arrays.fill(minSubsequence, Integer.MAX_VALUE); // 初始化为最大值，便于比较
        int start = Math.max(0, k - n), end = Math.min(k, m);
        
        for (int i = start; i <= end; i++) {
            int[] subsequence1 = minSubsequence(nums1, i);
            int[] subsequence2 = minSubsequence(nums2, k - i);
            int[] curMinSubsequence = merge(subsequence1, subsequence2);
            if ((curMinSubsequence[0] != 0 && compare(curMinSubsequence, 0, minSubsequence, 0) < 0) ||
                (minSubsequence[0] == 0)) {
                System.arraycopy(curMinSubsequence, 0, minSubsequence, 0, k);
            }
        }
        
        // 如果最小序列以0开头，寻找非0的最小数为开头
        if (minSubsequence[0] == 0) {
            for (int i = 1; i < k; i++) {
                if (minSubsequence[i] != 0) {
                    // 将第一个非0数与第一个数字交换
                    int temp = minSubsequence[0];
                    minSubsequence[0] = minSubsequence[i];
                    minSubsequence[i] = temp;
                    break;
                }
            }
        }
        
        return minSubsequence;
    }

    public int[] minSubsequence(int[] nums, int k) {
        int length = nums.length;
        int[] stack = new int[k];
        int top = -1;
        int remain = length - k;
        for (int i = 0; i < length; i++) {
            int num = nums[i];
            while (top >= 0 && stack[top] > num && remain > 0) {
                top--;
                remain--;
            }
            if (top < k - 1) {
                stack[++top] = num;
            } else {
                remain--;
            }
        }
        return stack;
    }

    public int[] merge(int[] subsequence1, int[] subsequence2) {
        int x = subsequence1.length, y = subsequence2.length;
        if (x == 0) {
            return subsequence2;
        }
        if (y == 0) {
            return subsequence1;
        }
        int mergeLength = x + y;
        int[] merged = new int[mergeLength];
        int index1 = 0, index2 = 0;
        for (int i = 0; i < mergeLength; i++) {
            if (compare(subsequence1, index1, subsequence2, index2) < 0) {
                merged[i] = subsequence1[index1++];
            } else {
                merged[i] = subsequence2[index2++];
            }
        }
        return merged;
    }

    public int compare(int[] subsequence1, int index1, int[] subsequence2, int index2) {
        int x = subsequence1.length, y = subsequence2.length;
        while (index1 < x && index2 < y) {
            int difference = subsequence1[index1] - subsequence2[index2];
            if (difference != 0) {
                return difference;
            }
            index1++;
            index2++;
        }
        return (x - index1) - (y - index2);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums1 = {3, 0, 1};
        int[] nums2 = {4, 2};
        int k = 3;
        int[] result = solution.minNumber(nums1, nums2, k);
        System.out.println(Arrays.toString(result));  // 输出应避免 [0, 1, 2] 以外的结果
    }
}
