package ds.graph;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*
 *Author：Victor_htq
 *Package：ds.graph
 *Project：DSnAL
 *name：IPConnectivity
 *Date：2024/6/20  15:58
 *Filename：IPConnectivity
 */
public class IPConnectivity {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] graph = new int[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                graph[i][j] = (i == j) ? 0 : Integer.MAX_VALUE;
            }
        }

        Map<String, Integer> ipToNumber = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String ip = sc.next();
            int number = sc.nextInt();
            ipToNumber.put(ip, number);
        }

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph[a][b] = 1;
            graph[b][a] = 1;
        }

        for (int k = 1; k <= n; k++) {
            for (int j = 1; j <= n; j++) {
                for (int i = 1; i <= n; i++) {
                    if (graph[i][k] != Integer.MAX_VALUE && graph[k][j] != Integer.MAX_VALUE && graph[i][j] > graph[i][k] + graph[k][j]) {
                        graph[i][j] = graph[i][k] + graph[k][j];
                    }
                }
            }
        }

        int q = sc.nextInt();
        for (int i = 0; i < q; i++) {
            String ip1 = sc.next();
            String ip2 = sc.next();
            int num1 = ipToNumber.getOrDefault(ip1, -1);
            int num2 = ipToNumber.getOrDefault(ip2, -1);
            if (num1 == -1 || num2 == -1 || graph[num1][num2] == Integer.MAX_VALUE) {
                System.out.println(-1);
            } else {
                System.out.println(graph[num1][num2]);
            }

        }
        sc.close();
    }


}
