import java.util.Scanner;

public class SortArraysGreedy {
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

            // 调用贪心方法，判断是否可以使其中一个数组有序
            if (canBeSortedGreedy(a, b, n)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }

        sc.close();
    }

    // 贪心算法：判断是否可以通过交换操作让a或b有序
    private static boolean canBeSortedGreedy(int[] a, int[] b, int n) {
        boolean canSortA = true;  // a[]能否保持有序
        boolean canSortB = true;  // b[]能否保持有序

        for (int i = 1; i < n; i++) {
            // 用临时变量来记录当前是否可以通过不交换或者交换继续保持有序
            boolean newCanSortA = false;
            boolean newCanSortB = false;

            // 检查不交换是否可以让 a[] 和 b[] 继续有序
            if (canSortA && a[i] >= a[i - 1] && b[i] >= b[i - 1]) {
                newCanSortA = true;
            }
            if (canSortB && a[i] >= b[i - 1] && b[i] >= a[i - 1]) {
                newCanSortA = true;
            }

            // 检查交换是否可以让 a[] 和 b[] 继续有序
            if (canSortA && a[i] >= b[i - 1] && b[i] >= a[i - 1]) {
                newCanSortB = true;
            }
            if (canSortB && b[i] >= b[i - 1] && a[i] >= a[i - 1]) {
                newCanSortB = true;
            }

            // 更新 canSortA 和 canSortB
            canSortA = newCanSortA;
            canSortB = newCanSortB;

            // 如果两者都不可行，则提前返回NO
            if (!canSortA && !canSortB) {
                return false;
            }
        }

        // 如果遍历结束后，仍然有一种方式可以保持有序，返回YES
        return true;
    }
}
