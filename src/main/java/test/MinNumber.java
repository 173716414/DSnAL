package test;

import java.util.*;

public class MinNumber {
    
    public static int[] minNumber(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        int m = nums2.length;
        int[] result = new int[k];
        Arrays.fill(result, Integer.MAX_VALUE);
        
        for (int i = Math.max(0, k - m); i <= Math.min(k, n); i++) {
            int[] candidate = merge(pickMin(nums1, i), pickMin(nums2, k - i));
            if (isSmaller(candidate, result)) {
                result = candidate;
            }
        }
        
        return result;
    }
    
    private static int[] pickMin(int[] nums, int length) {
        int[] stack = new int[length];
        int top = 0;
        int drop = nums.length - length;
        
        for (int num : nums) {
            while (drop > 0 && top > 0 && stack[top - 1] > num) {
                top--;
                drop--;
            }
            if (top < length) {
                stack[top++] = num;
            } else {
                drop--;
            }
        }
        
        return stack;
    }
    
    private static int[] merge(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length + nums2.length];
        int i = 0, j = 0, k = 0;
        
        while (i < nums1.length && j < nums2.length) {
            if (isSmaller(Arrays.copyOfRange(nums1, i, nums1.length), Arrays.copyOfRange(nums2, j, nums2.length))) {
                result[k++] = nums1[i++];
            } else {
                result[k++] = nums2[j++];
            }
        }
        
        while (i < nums1.length) {
            result[k++] = nums1[i++];
        }
        
        while (j < nums2.length) {
            result[k++] = nums2[j++];
        }
        
        return result;
    }
    
    private static boolean isSmaller(int[] nums1, int[] nums2) {
        int n = Math.min(nums1.length, nums2.length);
        for (int i = 0; i < n; i++) {
            if (nums1[i] != nums2[i]) {
                return nums1[i] < nums2[i];
            }
        }
        return nums1.length < nums2.length;
    }

    public static void main(String[] args) {
        int[] nums1 = {3, 9};
        int[] nums2 = {8, 9};
        int k = 3;
        int[] result = minNumber(nums1, nums2, k);
        System.out.println(Arrays.toString(result));  // 输出 [3, 8, 9]
    }
}
