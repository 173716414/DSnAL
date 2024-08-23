package test;

import java.util.Scanner;

public class TouristRoute {

    static int t, k;
    static int[] m;
    static int[] n;
    static int[][] pos;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 读取t和k
        t = scanner.nextInt();
        k = scanner.nextInt();

        m = new int[t];
        n = new int[t];
        pos = new int[t][2];

        // 读取每个旅游景点的属性
        for (int i = 0; i < t; i++) {
            m[i] = scanner.nextInt();
            n[i] = scanner.nextInt();
            pos[i][0] = scanner.nextInt();
            pos[i][1] = scanner.nextInt();
        }

        double maxComfort = Double.NEGATIVE_INFINITY;

        // 枚举所有可能的k个景点的组合
        int[] combination = new int[k];
        maxComfort = findBestCombination(0, 0, combination, maxComfort);

        System.out.printf("%.6f\n", maxComfort);
    }

    // 递归方法，用于搜索最优组合
    public static double findBestCombination(int start, int depth, int[] combination, double maxComfort) {
        if (depth == k) {
            int totalM = 0;
            int totalN = 0;

            // 计算当前组合的总疲劳值和总兴趣值
            for (int i = 0; i < k; i++) {
                int index = combination[i];
                totalM += m[index];
                totalN += n[index];

                // 从(0,0)出发的曼哈顿距离
                totalM += Math.abs(pos[index][0]) + Math.abs(pos[index][1]);
            }

            // 计算舒适度
            double comfort = (double) totalN / totalM;
            if (comfort > maxComfort) {
                maxComfort = comfort;
            }
            return maxComfort;
        }

        for (int i = start; i < t; i++) {
            combination[depth] = i;
            maxComfort = findBestCombination(i + 1, depth + 1, combination, maxComfort);
        }

        return maxComfort;
    }
}
