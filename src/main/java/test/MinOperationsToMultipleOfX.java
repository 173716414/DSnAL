package test;

import java.util.Arrays;
import java.util.Scanner;

public class MinOperationsToMultipleOfX {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // 输入 n 和 x
        int n = scanner.nextInt();
        int x = scanner.nextInt();
        
        // 输入序列 A
        int[] A = new int[n];
        int sum = 0;  // 计算总和
        for (int i = 0; i < n; i++) {
            A[i] = scanner.nextInt();
            sum += A[i];  // 计算序列的总和
        }
        
        // 如果总和已经是 x 的倍数，则不需要操作
        if (sum % x == 0) {
            System.out.println(0);
            return;
        } else {
            System.out.println(1);
        }
        
        // 当前序列的余数
        int remainder = sum % x;
        int minOperations = Integer.MAX_VALUE;
        Arrays.sort(A);
        for (int i = 0; i < n; i++) {

        }

        scanner.close();
    }
}
