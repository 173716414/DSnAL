package test;

import java.util.*;

public class CountingPairs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // 读取数组长度
        int n = scanner.nextInt();
        int[] a = new int[n];
        
        // 读取数组元素
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        
        // 用来存储左侧计数和右侧计数的映射
        Map<Integer, Integer> leftCounts = new HashMap<>();
        Map<Integer, Integer> rightCounts = new HashMap<>();
        
        // 初始化右侧计数
        for (int i = 0; i < n; i++) {
            rightCounts.put(a[i], rightCounts.getOrDefault(a[i], 0) + 1);
        }
        
        long result = 0;
        // 遍历每个元素，更新左侧和右侧计数，并计算满足条件的对数
        for (int i = 0; i < n; i++) {
            // 当前元素从右侧计数移除
            rightCounts.put(a[i], rightCounts.get(a[i]) - 1);
            if (rightCounts.get(a[i]) == 0) {
                rightCounts.remove(a[i]);
            }
            
            for (int j = i + 1; j < n; j++) {
                // 检查是否满足 f(l, i, ai) > f(j, n, aj)
                int leftCount = leftCounts.getOrDefault(a[i], 0);
                int rightCount = rightCounts.getOrDefault(a[j], 0);
                if (leftCount > rightCount) {
                    result++;
                }
            }
            
            // 当前元素加入左侧计数
            leftCounts.put(a[i], leftCounts.getOrDefault(a[i], 0) + 1);
        }
        
        System.out.println(result);
        scanner.close();
    }
}
