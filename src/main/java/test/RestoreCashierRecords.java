package test;

import java.util.Scanner;

public class RestoreCashierRecords {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 读取人数 n 和商品数量 m
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        // 读取商品的初始保质期数组
        int[] shelfLife = new int[m];
        for (int i = 0; i < m; i++) {
            shelfLife[i] = scanner.nextInt();
        }

        // 对于每一个顾客，处理其购物行为
        for (int i = 0; i < n; i++) {
            int day = scanner.nextInt(); // 到店的天数
            int l = scanner.nextInt() - 1; // 货架区间的左端点，转换为 0 索引
            int r = scanner.nextInt() - 1; // 货架区间的右端点，转换为 0 索引

            int chosenItem = -1; // 默认值为 -1，如果没有合适的商品则保持为 -1
            int maxShelfLife = -1; // 用于记录区间内保质期最大值

            // 遍历顾客选定的货架区间 [l, r]
            for (int j = l; j <= r; j++) {
                int currentShelfLife = shelfLife[j] - day; // 商品在到店日时的剩余保质期

                // 如果商品的保质期没有过期，且剩余保质期比当前最大保质期大
                if (currentShelfLife >= 0 && currentShelfLife > maxShelfLife) {
                    maxShelfLife = currentShelfLife;
                    chosenItem = j + 1; // 记录商品的编号（转换为 1 索引）
                }
            }

            // 输出顾客选择的商品编号，或者 -1 如果没有合适的商品
            System.out.print(chosenItem + " ");
        }

        scanner.close();
    }
}
