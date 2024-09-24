package test;

import java.util.Arrays;
import java.util.Scanner;

public class ArraySelection {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        // 示例数组
        int[] a = {6, 2, 8, 5, 4, 7};
        int[] b = {8, 3, 9, 1, 6, 5};

        int max = 0;
        int left = 0, right = a.length;
        
        Arrays.sort(a); // 先对数组排序
        Arrays.sort(b);

        while (left <= right) {
            int mid = left + (right - left) / 2;

            int[] c = selectSortedArray(a, mid); // 选择前 mid 个元素
            int[] d = selectSortedArray(b, mid); // 选择前 mid 个元素

            if (checkCondition(c, d, mid)) {
                max = mid; // 更新 max 为当前的 mid
                left = mid + 1; // 尝试更大的 m
            } else {
                right = mid - 1; // 尝试更小的 m
            }
        }

        System.out.println("Maximum m that satisfies the condition: " + max);
    }

    // 选择排序后的前 m 个元素
    private static int[] selectSortedArray(int[] array, int m) {
        return Arrays.copyOf(array, m);
    }

    // 检查条件是否满足
    private static boolean checkCondition(int[] c, int[] d, int m) {
        int sumC = 0, sumD = 0, sumProduct = 0;
        for (int i = 0; i < m; i++) {
            sumC += c[i];
            sumD += d[i];
            sumProduct += c[i] * d[i];
        }
        return sumC * sumD == m * sumProduct;
    }
}
