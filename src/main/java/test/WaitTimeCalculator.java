import java.util.PriorityQueue;

public class WaitTimeCalculator {
    public static int calculateWaitTime(int[] nums, int m) {
        // 优先队列（小顶堆）用来模拟服务员的可用时间
        PriorityQueue<Integer> waitTimes = new PriorityQueue<>();

        // 初始化每个服务员的初始可用时间为0
        for (int num : nums) {
            waitTimes.offer(0); // 每个服务员开始时的可用时间是0
        }

        // 分配 m 个顾客
        for (int i = 0; i < m; i++) {
            // 获取当前最早可用的服务员
            int earliestAvailableTime = waitTimes.poll();
            // 计算该服务员的新的可用时间
            int newAvailableTime = earliestAvailableTime + nums[i % nums.length];
            // 将更新后的服务员可用时间放回队列
            waitTimes.offer(newAvailableTime);
        }

        // 最后一个顾客等待的时间是队列中最早可用时间
        return waitTimes.peek();
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 2}; // 服务员的服务时间
        int m = 4; // 顾客的数量

        int waitTime = calculateWaitTime(nums, m);
        System.out.println("最后一个顾客等待的时间: " + waitTime); // 输出：1
    }
}
