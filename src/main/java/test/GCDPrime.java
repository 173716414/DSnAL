package test;

import java.util.Scanner;

public class GCDPrime {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // 读取询问次数
        int t = scanner.nextInt();
        
        // 处理每个询问
        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            System.out.println(n /

                    findMWithPrimeGCD(n));
        }
        
        scanner.close();
    }

    // 查找一个m，使得gcd(n, m)为素数
    private static int findMWithPrimeGCD(int n) {
        for (int m = 2; m <= n; m++) {
            int gcd = gcd(n, m);
            if (isPrime(gcd)) {
                return m;
            }
        }
        return -1; // 理论上应该总能找到m，因此不会执行到这里
    }

    // 计算两个数的最大公约数
    private static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    // 判断一个数是否为素数
    private static boolean isPrime(int num) {
        if (num < 2) return false;
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
