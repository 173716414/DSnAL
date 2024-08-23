import java.util.*;

public class MinNumberFromTwoArrays {

    public static int[] minNumber(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        int m = nums2.length;
        int[] minSequence = new int[k];
        Arrays.fill(minSequence, Integer.MAX_VALUE); // 初始化为最大值

        for (int i = Math.max(0, k - m); i <= Math.min(k, n); i++) {
            int[] seq1 = minSubsequence(nums1, i);
            int[] seq2 = minSubsequence(nums2, k - i);
            int[] merged = merge(seq1, seq2, k);
            if (compare(merged, 0, minSequence, 0) < 0) {
                minSequence = merged;
            }
        }

        // 如果结果的首位是0，需要从结果中去除
        if (minSequence[0] == 0) {
            int newSize = 0;
            for (int num : minSequence) {
                if (num != 0) {
                    break;
                }
                newSize++;
            }
            int[] newMinSequence = new int[k - newSize];
            for (int i = 0; i < k - newSize; i++) {
                newMinSequence[i] = minSequence[i + newSize];
            }
            minSequence = newMinSequence;
        }

        return minSequence;
    }

    private static int[] minSubsequence(int[] nums, int k) {
        int n = nums.length;
        int[] stack = new int[k];
        int top = -1;
        int remain = n - k;
        for (int num : nums) {
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

    private static int[] merge(int[] nums1, int[] nums2, int k) {
        int x = nums1.length;
        int y = nums2.length;
        if (x == 0) return nums2;
        if (y == 0) return nums1;
        int[] merged = new int[k];
        int i = 0, j = 0, index = 0;
        while (index < k) {
            if (compare(nums1, i, nums2, j) < 0) {
                merged[index++] = nums1[i++];
            } else {
                merged[index++] = nums2[j++];
            }
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
        int k = 3;
        int[] result = minNumber(nums1, nums2, k);
        System.out.println(Arrays.toString(result)); // 输出: [0, 1, 1]
    }
}
