package test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TravelRouteOptimization {

    static class Point {
        int m;  // 疲劳值
        int n;  // 兴奋值
        int x;  // x坐标
        int y;  // y坐标

        Point(int m, int n, int x, int y) {
            this.m = m;
            this.n = n;
            this.x = x;
            this.y = y;
        }
    }

    // 计算两点之间的曼哈顿距离
    public static int calculateDistance(Point p1, Point p2) {
        return Math.abs(p1.x - p2.x) + Math.abs(p1.y - p2.y);
    }

    // 计算舒适值
    public static double calculateComfort(List<Point> combination) {
        Point home = new Point(0, 0, 0, 0);
        int cm = 0;  // 总疲劳值
        int cn = 0;  // 总兴奋值

        // 从家到第一个景点的疲劳值
        cm += calculateDistance(home, combination.get(0));

        // 计算景点之间的疲劳值及总兴奋值
        for (int i = 0; i < combination.size() - 1; i++) {
            cm += calculateDistance(combination.get(i), combination.get(i + 1));
        }

        // 从最后一个景点返回家的疲劳值
        cm += calculateDistance(combination.get(combination.size() - 1), home);

        // 计算所有景点的兴奋值之和
        for (Point point : combination) {
            cn += point.n;
        }

        // 计算舒适值
        if (cm == 0) {
            return 0;
        }
        return (double) cn / cm;
    }

    // 生成所有可能的景点组合，并计算最大舒适值
    public static void generateCombinations(List<Point> points, int k, int start, List<Point> currentCombination, double[] bestComfort) {
        if (currentCombination.size() == k) {
            double comfort = calculateComfort(currentCombination);
            if (comfort > bestComfort[0]) {
                bestComfort[0] = comfort;
            }
            return;
        }

        for (int i = start; i < points.size(); i++) {
            currentCombination.add(points.get(i));
            generateCombinations(points, k, i + 1, currentCombination, bestComfort);
            currentCombination.remove(currentCombination.size() - 1);
        }
    }

    public static double findBestRoute(List<Point> points, int k) {
        double[] bestComfort = {0.0};
        generateCombinations(points, k, 0, new ArrayList<>(), bestComfort);
        return bestComfort[0];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt();  // 景点总数
        int k = scanner.nextInt();  // 选择的景点数
        List<Point> points = new ArrayList<>();

        for (int i = 0; i < t; i++) {
            int m = scanner.nextInt();  // 疲劳值
            int n = scanner.nextInt();  // 兴奋值
            int x = scanner.nextInt();  // x坐标
            int y = scanner.nextInt();  // y坐标
            points.add(new Point(m, n, x, y));
        }

        // 计算最优路线的舒适值
        double result = findBestRoute(points, k);
        System.out.printf("%.6f", result);

        scanner.close();
    }
}
