package test;

import java.util.*;

public class EdgeSelectionOptimized {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); // 读取节点数（虽然本问题中并不直接使用）
        int m = scanner.nextInt(); // 读取边的数量

        List<int[]> edges = new ArrayList<>(); // 存储每条边的两个节点
        Map<Integer, Set<Integer>> adjacency = new HashMap<>();

        // 读入所有边，同时构建每个节点的邻接表
        for (int i = 0; i < m; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            edges.add(new int[]{u, v});

            adjacency.computeIfAbsent(u, k -> new HashSet<>()).add(v);
            adjacency.computeIfAbsent(v, k -> new HashSet<>()).add(u);
        }

        int count = 0;
        // 选择两条不相交的边
        for (int i = 0; i < m - 1; i++) {
            for (int j = i + 1; j < m; j++) {
                int[] edge1 = edges.get(i);
                int[] edge2 = edges.get(j);
                if (areDistinct(adjacency, edge1, edge2)) {
                    count++;
                }
            }
        }

        System.out.println(count);
    }

    // 检查两条边的四个节点是否互不相同
    private static boolean areDistinct(Map<Integer, Set<Integer>> adjacency, int[] edge1, int[] edge2) {
        int a = edge1[0];
        int b = edge1[1];
        int c = edge2[0];
        int d = edge2[1];

        // 利用邻接表快速检查是否有共同节点
        return !adjacency.get(a).contains(c) && !adjacency.get(a).contains(d) &&
               !adjacency.get(b).contains(c) && !adjacency.get(b).contains(d);
    }
}
