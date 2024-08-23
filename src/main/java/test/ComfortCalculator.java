package test;

import java.util.*;

public class ComfortCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 读取输入
        int t = scanner.nextInt();
        int k = scanner.nextInt();
        scanner.nextLine(); // 消耗换行符

        List<int[]> a = new ArrayList<>();
        for (int i = 0; i < t; i++) {
            String[] parts = scanner.nextLine().split(" ");
            int m = Integer.parseInt(parts[0]);
            int n = Integer.parseInt(parts[1]);
            int x = Integer.parseInt(parts[2].replace("(", ""));
            int y = Integer.parseInt(parts[3].replace(")", ""));
            a.add(new int[]{m, n, x, y});
        }

        // 计算并输出结果
        double result = calculateComfort(t, k, a);
        System.out.printf("%.6f%n", result);

        scanner.close();
    }

    public static double calculateComfort(int t, int k, List<int[]> a) {
        double maxComfort = -1;

        // 生成所有可能的组合
        List<List<int[]>> combinations = new ArrayList<>();
        generateCombinations(a, k, 0, new ArrayList<>(), combinations);

        for (List<int[]> combo : combinations) {
            List<int[]> route = new ArrayList<>();
            route.add(new int[]{0, 0});
            for (int[] spot : combo) {
                route.add(new int[]{spot[2], spot[3]});
            }
            route.add(new int[]{0, 0});

            int cm = calculateFatigue(route) + combo.stream().mapToInt(spot -> spot[0]).sum();
            int cn = combo.stream().mapToInt(spot -> spot[1]).sum();
            double comfort = (double) cn / cm;
            maxComfort = Math.max(maxComfort, comfort);
        }

        return maxComfort;
    }

    public static int calculateFatigue(List<int[]> route) {
        int fatigue = 0;
        for (int i = 1; i < route.size(); i++) {
            fatigue += Math.abs(route.get(i)[0] - route.get(i - 1)[0]) + Math.abs(route.get(i)[1] - route.get(i - 1)[1]);
        }
        return fatigue;
    }

    public static void generateCombinations(List<int[]> a, int k, int start, List<int[]> current, List<List<int[]>> combinations) {
        if (current.size() == k) {
            combinations.add(new ArrayList<>(current));
            return;
        }

        for (int i = start; i < a.size(); i++) {
            current.add(a.get(i));
            generateCombinations(a, k, i + 1, current, combinations);
            current.remove(current.size() - 1);
        }
    }
}