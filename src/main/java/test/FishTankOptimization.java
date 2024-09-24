package test;

import java.util.Arrays;
import java.util.Scanner;

public class FishTankOptimization {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // 输入鱼缸数量
        int n = scanner.nextInt();
        int[] heights = new int[n];
        
        // 输入每个鱼缸的水位高度
        for (int i = 0; i < n; i++) {
            heights[i] = scanner.nextInt();
        }
        
        // 调用计算最小混乱度的方法
        System.out.println(calculateMinimumChaos(heights, n));
    }

    public static int calculateMinimumChaos(int[] heights, int n) {
        // 计算当前的混乱度
        int currentChaos = calculateChaos(heights, n);
        
        // 记录初始的混乱度
        int minChaos = currentChaos;
        
        // 尝试移除一个元素后重新计算混乱度
        for (int i = 1; i < n - 1; i++) {
            int originalValue = heights[i]; // 保存原始值
            heights[i] = heights[i - 1]; // 调整值为前一个高度
            minChaos = Math.min(minChaos, calculateChaos(heights, n));
            heights[i] = originalValue; // 恢复原始值
        }
        
        return minChaos;
    }

    // 计算当前鱼缸数组的混乱度
    public static int calculateChaos(int[] heights, int n) {
        int chaos = 0;
        for (int i = 1; i < n; i++) {
            chaos += Math.abs(heights[i] - heights[i - 1]);
        }
        return chaos;
    }
}
