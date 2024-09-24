package test;

import java.util.Scanner;
import java.util.ArrayList;

public class EdgeSelection {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); // 读取节点数（虽然本问题中并不直接使用）
        int m = scanner.nextInt(); // 读取边的数量

        int[][] edges = new int[m][2]; // 存储每条边的两个节点

        for (int i = 0; i < m; i++) {
            edges[i][0] = scanner.nextInt();
            edges[i][1] = scanner.nextInt();
        }

        int count = 0;
        // 选择两条不相交的边
        for (int i = 0; i < m - 1; i++) {
            for (int j = i + 1; j < m; j++) {
                if (areDistinct(edges[i], edges[j])) {
                    count++;
                }
            }
        }

        System.out.println(count);
    }

    // 检查两条边的四个节点是否互不相同
    private static boolean areDistinct(int[] edge1, int[] edge2) {
        int a = edge1[0];
        int b = edge1[1];
        int c = edge2[0];
        int d = edge2[1];

        // 确保没有重复的节点
        return a != c && a != d && b != c && b != d;
    }
}
