package test;

import java.util.Scanner;
import java.util.Arrays;

public class MinimizeRange {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // 读取数组长度
        int n = scanner.nextInt();
        int[] arr = new int[n];
        
        // 读取数组元素
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        
        // 输出最少的操作次数
        System.out.println(minOperationsToMinimizeRange(arr));
        
        scanner.close();
    }

    // 计算最少操作次数以使数组极差最小
    private static int minOperationsToMinimizeRange(int[] arr) {
        // 先对数组排序
        Arrays.sort(arr);
        
        // 我们希望将所有值变成中间的值
        int mid = arr[arr.length / 2];
        int operations = 0;
        
        // 计算总操作次数
        for (int i = 0; i < arr.length; i++) {
            operations += Math.abs(arr[i] - mid);
        }
        
        // 因为每次操作都可以同时使两个元素更接近中间值
        return operations / 2;
    }
}
