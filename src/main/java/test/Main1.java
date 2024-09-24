package test;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt(); // 读取测试用例数量
        while (t-- > 0) {
            int n = scanner.nextInt(); // 数组长度
            int x = scanner.nextInt(); // 删除第一个元素的花费
            int y = scanner.nextInt(); // 删除最后一个元素的花费
            int z = scanner.nextInt(); // 将所有元素减 1 的花费

            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = scanner.nextInt();
            }

            System.out.println(dfs(arr, x, y, z, 0, n - 1));
        }
        scanner.close();
    }

    public static int dfs(int[] arr, int x, int y, int z, int left, int right) {
        if (left > right) {
            return 0; // 如果左指针越过右指针，说明数组已经处理完毕
        }
        if (left == right) { // 只有一个元素的情况
            return arr[left] * z;
        }

        // 删除左边元素
        int removeLeft = dfs(arr, x, y, z, left + 1, right) + x;
        // 删除右边元素
        int removeRight = dfs(arr, x, y, z, left, right - 1) + y;

        // 减少所有元素
        int minElement = Integer.MAX_VALUE;
        for (int i = left; i <= right; i++) {
            minElement = Math.min(minElement, arr[i]);
        }
        for (int i = left; i <= right; i++) {
            arr[i] -= minElement;
        }
        int reduceAll = dfs(arr, x, y, z, left, right) + minElement * z;
        // 恢复数组元素，避免对后续递归产生影响
        for (int i = left; i <= right; i++) {
            arr[i] += minElement;
        }

        // 取三者中的最小值
        return Math.min(removeLeft, Math.min(removeRight, reduceAll));
    }
}
