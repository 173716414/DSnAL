package test;

import java.util.Arrays;

public class MinKSubsequence {
    public static String findMinSequence(int[] nums, int k) {
        int m = nums.length;
        String[][] dp = new String[m + 1][k + 1];
        
        // 初始化dp数组
        for (int i = 0; i <= m; i++) {
            Arrays.fill(dp[i], "");
        }

        for (int i = 0; i <= m; i++) {
            dp[i][0] = ""; // 选0个数时，结果是空字符串
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= Math.min(i, k); j++) {
                // 不选择nums[i-1]
                dp[i][j] = dp[i - 1][j];
                
                // 选择nums[i-1]，并且首位不为0的情况
                if (j == 1 && nums[i - 1] == 0) {
                    continue;
                }

                // 构造选择nums[i-1]的情况
                String selected = dp[i - 1][j - 1] + nums[i - 1];
                
                // 选择较小的子序列
                if (dp[i][j].isEmpty() || selected.compareTo(dp[i][j]) < 0) {
                    dp[i][j] = selected;
                }
            }
        }

        // 找到最小且首位不为0的子序列
        String result = "";
        for (int i = 1; i <= m; i++) {
            if (!dp[i][k].isEmpty() && dp[i][k].charAt(0) != '0') {
                if (result.isEmpty() || dp[i][k].compareTo(result) < 0) {
                    result = dp[i][k];
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {3,0,1,4,2};
        int k = 2;
        String result = findMinSequence(nums, k);
        System.out.println("最小的子序列是: " + result);

        Solution2 solution2 = new Solution2();
        solution2.print();
    }


}
class Solution2 {
    public void print() {
        System.out.println("hello world");
    }
}
