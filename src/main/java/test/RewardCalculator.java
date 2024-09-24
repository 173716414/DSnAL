package test;

public class RewardCalculator {

    public static long getMaxReward(long n, long m, long k) {
        long i = 0, reward = 0;
        long x = 0, y = 0;
        while (i < k) {
            if (x < n - 1) {
                x += 1;
            } else {
                if (y < m - 1) {
                    y += 1;
                } else {
                    y -= 1;
                }
            }
            reward += (y + x * m);
            i += 1;
        }
        return reward;
    }

    public static void main(String[] args) {
        int n = 4; // 示例值
        int m = 5; // 示例值
        int k = 10; // 示例值

        // int result = getMaxReward(n, m, k);
        // System.out.println("Maximum Reward: " + result);
    }
}
