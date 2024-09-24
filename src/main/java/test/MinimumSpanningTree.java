 package test;

import java.util.*;

public class MinimumSpanningTree {

    // 判断是否为质数
    public static boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        if (num == 2 || num == 3) {
            return true;
        }
        if (num % 2 == 0 || num % 3 == 0) {
            return false;
        }
        for (int i = 5; i * i <= num; i += 6) {
            if (num % i == 0 || num % (i + 2) == 0) {
                return false;
            }
        }
        return true;
    }

    // 查找最大连通块
    public static List<Integer> findMaxComponent(Map<Integer, List<Integer>> graph, int n) {
        boolean[] visited = new boolean[n];
        List<Integer> maxComponent = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                List<Integer> component = new ArrayList<>();
                dfs(i, graph, visited, component);
                if (component.size() > maxComponent.size()) {
                    maxComponent = component;
                }
            }
        }
        return maxComponent;
    }

    private static void dfs(int node, Map<Integer, List<Integer>> graph, boolean[] visited, List<Integer> component) {
        visited[node] = true;
        component.add(node);
        for (int neighbor : graph.getOrDefault(node, Collections.emptyList())) {
            if (!visited[neighbor]) {
                dfs(neighbor, graph, visited, component);
            }
        }
    }

    // Kruskal算法实现最小生成树
    public static int kruskal(int n, List<int[]> edges) {
        edges.sort(Comparator.comparingInt(edge -> edge[2]));
        int[] parent = new int[n];
        int[] rank = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        int mstWeight = 0;
        int mstEdges = 0;

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int weight = edge[2];
            if (find(u, parent) != find(v, parent)) {
                union(u, v, parent, rank);
                mstWeight += weight;
                mstEdges++;
                if (mstEdges == n - 1) {
                    break;
                }
            }
        }

        return mstWeight;
    }

    private static int find(int u, int[] parent) {
        if (parent[u] != u) {
            parent[u] = find(parent[u], parent);
        }
        return parent[u];
    }

    private static void union(int u, int v, int[] parent, int[] rank) {
        int rootU = find(u, parent);
        int rootV = find(v, parent);
        if (rootU != rootV) {
            if (rank[rootU] > rank[rootV]) {
                parent[rootV] = rootU;
            } else if (rank[rootU] < rank[rootV]) {
                parent[rootU] = rootV;
            } else {
                parent[rootV] = rootU;
                rank[rootU]++;
            }
        }
    }

    // 主函数
    public static int minSpanningTreeWeight(int n, int[] numbers) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        List<int[]> edges = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (isPrime(numbers[i] + numbers[j])) {
                    graph.computeIfAbsent(i, k -> new ArrayList<>()).add(j);
                    graph.computeIfAbsent(j, k -> new ArrayList<>()).add(i);
                    edges.add(new int[]{i, j, numbers[i] + numbers[j]});
                }
            }
        }

        List<Integer> maxComponent = findMaxComponent(graph, n);
        if (maxComponent.size() <= 1) {
            return 0;
        }

        List<int[]> componentEdges = new ArrayList<>();
        for (int[] edge : edges) {
            if (maxComponent.contains(edge[0]) && maxComponent.contains(edge[1])) {
                componentEdges.add(edge);
            }
        }

        return kruskal(maxComponent.size(), componentEdges);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();
        }
        System.out.println(minSpanningTreeWeight(n, numbers));
    }
}
