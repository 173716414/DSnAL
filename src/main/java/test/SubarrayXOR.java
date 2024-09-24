package test;

import java.util.Scanner;

public class SubarrayXOR {

    // 计算 f1 ~ fn
    public static void calculateXORs(int[] arr, int n) {
        // 遍历 k 从 1 到 n
        for (int k = 1; k <= n; k++) {
            int fk = 0; // 存储 fk 的异或结果
            
            // 计算所有长度为 k 的子数组
            for (int i = 0; i <= n - k; i++) {
                int xor = 0; // 计算当前子数组的异或值
                // 子数组范围 arr[i] 到 arr[i+k-1]
                for (int j = i; j < i + k; j++) {
                    xor ^= arr[j];
                }
                // 将子数组的异或值加入 fk
                fk ^= xor;
            }
            
            // 输出 fk 的结果
            System.out.print(fk + " ");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 输入数组长度 n
        // System.out.print("请输入数组长度 n: ");
        int n = scanner.nextInt();

        // 输入数组元素
        int[] arr = new int[n];
        // System.out.println("请输入数组元素: ");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        // 计算并输出 f1 ~ fn
        calculateXORs(arr, n);
    }
}
