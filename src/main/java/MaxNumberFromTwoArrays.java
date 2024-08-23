import java.util.*;

public class MaxNumberFromTwoArrays {

    public static int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        int m = nums2.length;
        int[] maxSequence = new int[k];
        for (int i = Math.max(0, k - m); i <= Math.min(k, n); i++) {
            int[] seq1 = maxSubsequence(nums1, i);
            int[] seq2 = maxSubsequence(nums2, k - i);
            int[] merged = merge(seq1, seq2);
            if (compare(merged, 0, maxSequence, 0) > 0) {
                maxSequence = merged;
            }
        }
        return maxSequence;
    }

    private static int[] maxSubsequence(int[] nums, int k) {
        int n = nums.length;
        int[] stack = new int[k];
        int top = -1;
        int remain = n - k;
        for (int num : nums) {
            while (top >= 0 && stack[top] < num && remain > 0) {
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

    private static int[] merge(int[] nums1, int[] nums2) {
        int x = nums1.length;
        int y = nums2.length;
        if (x == 0) return nums2;
        if (y == 0) return nums1;
        int[] merged = new int[x + y];
        int i = 0, j = 0, k = 0;
        while (i < x && j < y) {
            if (compare(nums1, i, nums2, j) > 0) {
                merged[k++] = nums1[i++];
            } else {
                merged[k++] = nums2[j++];
            }
        }
        while (i < x) {
            merged[k++] = nums1[i++];
        }
        while (j < y) {
            merged[k++] = nums2[j++];
        }
        return merged;
    }

    private static int compare(int[] nums1, int i, int[] nums2, int j) {
        int x = nums1.length;
        int y = nums2.length;
        while (i < x && j < y) {
            int diff = nums1[i] - nums2[j];
            if (diff != 0) return diff;
            i++;
            j++;
        }
        return (x - i) - (y - j);
    }

    public static void main(String[] args) {
        int[] nums1 = {3, 0, 1};
        int[] nums2 = {4, 2, 1};
        int k = 1;
        int[] result = maxNumber(nums1, nums2, k);
        System.out.println(Arrays.toString(result)); // 输出: [4]
    }
}
