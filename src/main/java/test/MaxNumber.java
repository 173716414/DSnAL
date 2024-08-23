package test;

import java.util.ArrayList;
import java.util.List;

public class MaxNumber {
    public static void main(String[] args) {
        int[] nums1 = {3, 0, 1};
        int[] nums2 = {4, 2, 1};
        int k = 2;
        
        int[] result = maxNumber(nums1, nums2, k);
        for (int num : result) {
            System.out.print(num + " ");
        }
    }

    public static int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int[] maxCombination = new int[k];
        
        for (int i = Math.max(0, k - nums2.length); i <= Math.min(k, nums1.length); i++) {
            int[] candidate = merge(maxArray(nums1, i), maxArray(nums2, k - i));
            if (greater(candidate, 0, maxCombination, 0)) {
                maxCombination = candidate;
            }
        }
        
        return maxCombination;
    }

    private static int[] maxArray(int[] nums, int k) {
        int[] result = new int[k];
        int length = nums.length;
        int j = 0;
        
        for (int i = 0; i < length; i++) {
            while (length - i + j > k && j > 0 && result[j - 1] < nums[i]) {
                j--;
            }
            if (j < k) {
                result[j++] = nums[i];
            }
        }
        
        return result;
    }

    private static int[] merge(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length + nums2.length];
        int i = 0, j = 0, r = 0;
        
        while (i < nums1.length || j < nums2.length) {
            if (greater(nums1, i, nums2, j)) {
                result[r++] = nums1[i++];
            } else {
                result[r++] = nums2[j++];
            }
        }
        
        return result;
    }

    private static boolean greater(int[] nums1, int i, int[] nums2, int j) {
        while (i < nums1.length && j < nums2.length && nums1[i] == nums2[j]) {
            i++;
            j++;
        }
        return j == nums2.length || (i < nums1.length && nums1[i] > nums2[j]);
    }
}
