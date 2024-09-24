package test;

import java.util.ArrayList;
import java.util.Scanner;

public class MaxAdditionalEdges {

    // 用于存储树的邻接表
    static ArrayList<ArrayList<Integer>> tree;
    // 存储每个节点的子节点数
    static int[] childCount;

    // 深度优先搜索 (DFS) 函数
    public static void dfs(int node, int parent) {
        int children = 0;
        for (int neighbor : tree.get(node)) {
            if (neighbor != parent) {
                dfs(neighbor, node); // 递归访问子节点
                children++;
            }
        }
        childCount[node] = children; // 记录该节点的子节点数
    }

    // 主函数：计算最多可以添加的边数
    public static int maxAdditionalEdges(int n, int[][] edges) {
        // 初始化邻接表和子节点计数数组
        tree = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            tree.add(new ArrayList<>());
        }
        childCount = new int[n + 1];

        // 构建邻接表
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            tree.get(u).add(v);
            tree.get(v).add(u);
        }

        // 从节点1开始DFS，假设1为树的根节点
        dfs(1, -1);

        // 计算可以添加的边数
        int additionalEdges = 0;
        for (int i = 1; i <= n; i++) {
            int count = childCount[i];
            if (count > 1) {
                additionalEdges += count * (count - 1) / 2;
            }
        }

        return additionalEdges;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // 输入节点数
        int n = sc.nextInt();
        
        // 输入树的边
        int[][] edges = new int[n - 1][2];
        for (int i = 0; i < n - 1; i++) {
            edges[i][0] = sc.nextInt();
            edges[i][1] = sc.nextInt();
        }

        // 计算并输出结果
        System.out.println(maxAdditionalEdges(n, edges));
        
        sc.close();
    }
}
