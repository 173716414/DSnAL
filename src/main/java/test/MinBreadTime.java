package test;

import java.util.Scanner;

public class MinBreadTime {
    
    // 计算最少的制作时间
    public static int minBreadTime(int n, int[] a, int[] b) {
        int minTime = Integer.MAX_VALUE;
        
        // 选择同一个面包机制作两种面包
        for (int i = 0; i < n; i++) {
            minTime = Math.min(minTime, a[i] + b[i]);
        }
        
        // 选择不同的面包机分别制作面包a和面包b
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    minTime = Math.min(minTime, Math.max(a[i], b[j]));
                }
            }
        }
        
        return minTime;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 输入n
        int n = scanner.nextInt();

        // 输入面包机制作面包a的时间
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        // 输入面包机制作面包b的时间
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            b[i] = scanner.nextInt();
        }

        // 计算最少的制作时间并输出
        System.out.println(minBreadTime(n, a, b));
        
        scanner.close();
    }
}
