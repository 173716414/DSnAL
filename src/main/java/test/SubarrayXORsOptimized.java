package test;

import java.util.Scanner;

public class SubarrayXORsOptimized {

    // 计算从 f1 到 fn 的所有异或结果
    public static void calculateXORs(int[] arr, int n) {
        // 遍历每个子数组的长度 k
        for (int k = 1; k <= n; k++) {
            int fk = 0; // 存储 fk 的异或结果
            int xor = 0; // 当前窗口的异或值

            // 初始化第一个窗口的异或值（长度为 k）
            for (int i = 0; i < k; i++) {
                xor ^= arr[i];
            }

            // 将第一个窗口的异或值累加到 fk 中
            fk ^= xor;

            // 滑动窗口，计算后续的子数组的异或值
            for (int i = k; i < n; i++) {
                // 移除窗口最左边的元素，加入窗口最右边的元素
                xor ^= arr[i - k]; // 移除 arr[i-k]
                xor ^= arr[i];     // 加入 arr[i]
                fk ^= xor;         // 将当前窗口的异或值累加到 fk 中
            }

            // 输出 fk 的结果
            System.out.print(fk + " ");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 输入数组长度 n
        int n = scanner.nextInt();

        // 输入数组元素
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        // 计算并输出 f1 ~ fn
        calculateXORs(arr, n);
    }
}
