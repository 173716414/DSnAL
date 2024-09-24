package test;

import java.util.Arrays;
import java.util.Scanner;

public class MinOperations {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // 输入n和x
        int n = scanner.nextInt();
        int x = scanner.nextInt();
        
        // 输入序列A
        int[] A = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = scanner.nextInt();
        }
        
        // 动态规划数组，初始化为最大值
        int[] dp = new int[x];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0; // 初始状态
        
        // 遍历每个元素A[i]
        for (int i = 0; i < n; i++) {
            int modValue = A[i] % x;  // 当前元素对x的模
            
            // 创建一个新的dp数组来存储更新后的结果，防止覆盖
            int[] newDp = dp.clone();
            
            // 遍历当前dp数组，更新newDp数组
            for (int j = 0; j < x; j++) {
                if (dp[j] != Integer.MAX_VALUE) {
                    // 操作1：删除当前元素，意味着我们不使用它，直接继承dp[j]
                    newDp[j] = Math.min(newDp[j], dp[j] + 1);
                    
                    // 操作2：将当前元素加1，更新模值并计算最少操作数
                    int newMod = (j + modValue) % x;
                    newDp[newMod] = Math.min(newDp[newMod], dp[j]);
                }
            }
            
            // 更新dp数组
            dp = newDp;
        }
        
        // 输出dp[0]，即使得和是x倍数的最少操作数
        System.out.println(dp[0]);
        
        scanner.close();
    }
}
