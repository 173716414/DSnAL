package test;

import java.util.*;

public class ShowMeBug {

    public int[][] solution(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return new int[0][];
        }

        // 首先根据每个区间的起始时间进行排序
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        List<int[]> merged = new ArrayList<>();

        int[] currentInterval = intervals[0];
        merged.add(currentInterval);

        for (int[] interval : intervals) {
            int currentEnd = currentInterval[1];
            int nextBegin = interval[0];
            int nextEnd = interval[1];

            if (currentEnd >= nextBegin) { // 有重叠，合并区间
                currentInterval[1] = Math.max(currentEnd, nextEnd);
            } else { // 没有重叠，添加新的区间
                currentInterval = interval;
                merged.add(currentInterval);
            }
        }

        return merged.toArray(new int[merged.size()][]);
    }

    public static void main(String[] args) {
        ShowMeBug solution = new ShowMeBug();
        
        int[][] intervals1 = {{1, 4}, {2, 6}, {9, 10}};
        int[][] result1 = solution.solution(intervals1);
        System.out.println("合并后的区间: " + Arrays.deepToString(result1));

        int[][] intervals2 = {{1, 2}, {6, 7},{5, 5}};
        int[][] result2 = solution.solution(intervals2);
        System.out.println("合并后的区间: " + Arrays.deepToString(result2));
    }
}
