package test;

import java.util.Arrays;

public class MinNumberConstructor {

    public static void main(String[] args) {
        // 示例输入
        int[] nums1 = {3, 0, 1};
        int[] nums2 = {4, 2, 1};
        int k = 3; // 根据题目要求，k等于两个数组的长度之和

        // 调用构造最小数的方法
        int[] result = constructArray(nums1, nums2, k);

        // 输出结果
        System.out.println(Arrays.toString(result));
    }

    public static int[] constructArray(int[] nums1, int[] nums2, int k) {
        int m = nums1.length, n = nums2.length;
        int[] ans = new int[k];
        int i = 0, j = 0, index = 0;

        // 比较两个数组前k个元素组成的数的大小
        while (i < m && j < n && index < k) {
            if (compare(nums1, nums2, i, j) < 0) {
                ans[index++] = nums1[i++];
            } else {
                ans[index++] = nums2[j++];
            }
        }

        // 如果一个数组已经取完，另一个数组还有剩余元素，直接取出
        while (i < m && index < k) {
            ans[index++] = nums1[i++];
        }
        while (j < n && index < k) {
            ans[index++] = nums2[j++];
        }

        return ans;
    }

    // 比较两个数组从i和j开始，长度为k的元素组成的数的大小
    private static int compare(int[] nums1, int[] nums2, int i, int j) {
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] != nums2[j]) {
                return nums1[i] - nums2[j];
            }
            i++;
            j++;
        }
        return 0;
    }
}
