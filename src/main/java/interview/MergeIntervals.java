package interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {
    public static int[][] merge(int[][] grid) {
        if (grid.length <= 1) {
            return grid;
        }

        // 按照区间的起始位置排序
        Arrays.sort(grid, Comparator.comparingInt(a -> a[0]));

        // 用来存储合并后的区间
        List<int[]> merged = new ArrayList<>();

        // 初始化当前区间为第一个区间
        int[] currentInterval = grid[0];
        merged.add(currentInterval);

        for (int[] interval : grid) {
            // 检查当前区间的结束位置与下一个区间的起始位置
            if (currentInterval[1] >= interval[0]) { // 区间重叠或相邻
                currentInterval[1] = Math.max(currentInterval[1], interval[1]); // 合并
            } else {
                currentInterval = interval; // 不重叠，加入新的区间
                merged.add(currentInterval);
            }
        }

        return merged.toArray(new int[merged.size()][]);
    }

    public static void main(String[] args) {
        int[][] grid = {{1, 4}, {4, 5}, {5, 8}, {9, 10}};
        int[][] result = merge(grid);

        // 输出合并后的区间
        for (int[] interval : result) {
            System.out.println(Arrays.toString(interval));
        }
    }
}
