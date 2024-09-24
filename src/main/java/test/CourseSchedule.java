package test;

import java.util.*;

public class CourseSchedule {
    
    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        // 创建图和入度表
        List<List<Integer>> graph = new ArrayList<>();
        int[] indegree = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] pre : prerequisites) {
            graph.get(pre[1]).add(pre[0]);
            indegree[pre[0]]++;
        }

        // 使用队列记录入度为 0 的课程
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }

        // 进行拓扑排序
        int[] result = new int[numCourses];
        int index = 0;
        while (!queue.isEmpty()) {
            int course = queue.poll();
            result[index++] = course;
            for (int nextCourse : graph.get(course)) {
                indegree[nextCourse]--;
                if (indegree[nextCourse] == 0) {
                    queue.add(nextCourse);
                }
            }
        }

        // 如果排序后的结果数量等于课程数量，说明可以完成
        return index == numCourses ? result : new int[0];
    }

    public static void main(String[] args) {
        // 示例 1
        int numCourses1 = 4;
        int[][] prerequisites1 = {{1, 0}, {2, 1}};
        System.out.println("示例 1 输出: " + Arrays.toString(findOrder(numCourses1, prerequisites1)));

        // 示例 2
        int numCourses2 = 3;
        int[][] prerequisites2 = {{1, 0}, {2, 1}};
        System.out.println("示例 2 输出: " + Arrays.toString(findOrder(numCourses2, prerequisites2)));

        // 示例 3
        int numCourses3 = 2;
        int[][] prerequisites3 = {{1, 0}, {0, 1}};
        System.out.println("示例 3 输出: " + Arrays.toString(findOrder(numCourses3, prerequisites3)));
    }
}
