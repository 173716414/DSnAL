package test;

import java.util.Scanner;

public class XiaoHongOrganizingItems {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 读取物品数量 n
        int n = scanner.nextInt();

        // 读取每个物品的类别
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        // 读取每个物品是否可以移动
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            b[i] = scanner.nextInt();
        }

        // 初始美观度计算
        int initialBeauty = 0;
        for (int i = 0; i < n - 1; i++) {
            if (a[i] != a[i + 1]) {
                initialBeauty++;
            }
        }

        // 尝试通过移动可移动的物品，降低美观度
        int minBeauty = initialBeauty;
        for (int i = 0; i < n - 1; i++) {
            if (b[i] == 1 || b[i + 1] == 1) {
                // 假设交换 a[i] 和 a[i+1]，检查美观度变化
                if (a[i] == a[i + 1]) continue;

                // 交换元素
                int temp = a[i];
                a[i] = a[i + 1];
                a[i + 1] = temp;

                // 重新计算美观度
                int currentBeauty = 0;
                for (int j = 0; j < n - 1; j++) {
                    if (a[j] != a[j + 1]) {
                        currentBeauty++;
                    }
                }

                // 更新最小美观度
                minBeauty = Math.min(minBeauty, currentBeauty);

                // // 还原交换
                // temp = a[i];
                // a[i] = a[i + 1];
                // a[i + 1] = temp;
            }
        }

        // 输出最小美观度
        System.out.println(minBeauty);
    }
}
