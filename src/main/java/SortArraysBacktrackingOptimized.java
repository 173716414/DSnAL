import java.util.Scanner;

public class SortArraysBacktrackingOptimized {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();  // 读取数据组数

        while (T-- > 0) {
            int n = sc.nextInt();  // 读取数组长度
            int[] a = new int[n];
            int[] b = new int[n];

            // 读取数组 a
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }

            // 读取数组 b
            for (int i = 0; i < n; i++) {
                b[i] = sc.nextInt();
            }

            // 调用优化的回溯方法，判断是否可以使其中一个数组有序
            if (canBeSorted(a, b, 0, n)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }

        sc.close();
    }

    // 回溯函数，判断从index位置开始，是否可以通过交换操作让a或b有序
    private static boolean canBeSorted(int[] a, int[] b, int index, int n) {
        // 剪枝1：如果当前a或b已经有序，提前返回
        if (isSorted(a, n) || isSorted(b, n)) {
            return true;
        }

        // 基础条件：如果已经检查到最后一个元素
        if (index == n) {
            return false;
        }

        // 尝试不交换当前的元素
        if (canBeSorted(a, b, index + 1, n)) {
            return true;
        }

        // 剪枝2：如果 a[i] == b[i]，交换没有意义，跳过
        if (a[index] != b[index]) {
            // 尝试交换当前的元素
            swap(a, b, index);
            if (canBeSorted(a, b, index + 1, n)) {
                return true;
            }
            // 回溯，撤销交换操作
            swap(a, b, index);
        }

        return false;
    }

    // 检查数组是否是有序的（升序或降序）
    private static boolean isSorted(int[] arr, int n) {
        boolean nonDecreasing = true;
        boolean nonIncreasing = true;

        for (int i = 1; i < n; i++) {
            if (arr[i] < arr[i - 1]) {
                nonDecreasing = false;
            }
            if (arr[i] > arr[i - 1]) {
                nonIncreasing = false;
            }
        }

        return nonDecreasing || nonIncreasing;
    }

    // 交换 a[i] 和 b[i] 的元素
    private static void swap(int[] a, int[] b, int i) {
        int temp = a[i];
        a[i] = b[i];
        b[i] = temp;
    }
}
