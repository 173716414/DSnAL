package test;

import java.util.PriorityQueue;
import java.util.Comparator;

public class CustomerWaitTime {

    public static int customerWaitTime(int[] nums, int m) {
        // 创建优先队列，用于存储服务员的可用时间及对应的服务时间
        PriorityQueue<int[]> availableTimes = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

        // 初始化每个服务员的可用时间为0
        for (int i = 0; i < nums.length; i++) {
            availableTimes.offer(new int[]{0, nums[i]});
        }
        
        int lastWaitTime = 0;
        
        for (int i = 0; i < m; i++) {
            // 取出最早可用的服务员
            int[] earliest = availableTimes.poll();
            int earliestTime = earliest[0];  // 服务员当前的可用时间
            int serviceTime = earliest[1];   // 服务员的服务时间
            
            // 计算该服务员服务当前顾客后的时间
            lastWaitTime = earliestTime + serviceTime;
            // 先写上去吧
            // 将更新后的时间放回堆中
            earliest[0] = lastWaitTime;
            availableTimes.offer(earliest);
        }
        
        // 最后一个顾客等待的时间
        return lastWaitTime;
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 4, 5};
        int m = 30;
        System.out.println(customerWaitTime(nums, m));  // 输出: 25
    }
}
