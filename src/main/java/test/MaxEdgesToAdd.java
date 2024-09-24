package test;

import java.util.Scanner;

public class MaxEdgesToAdd {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] degree = new int[n + 1]; // Degrees of nodes
        for (int i = 0; i < n - 1; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            degree[u]++;
            degree[v]++;
        }
        long sum = 0;
        for (int i = 1; i <= n; i++) {
            long d = degree[i];
            sum += d * (d - 1) / 2;
        }
        System.out.println(sum);
        scanner.close();
    }
}
