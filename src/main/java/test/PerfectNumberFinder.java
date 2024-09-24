package test;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class PerfectNumberFinder {

    // 检查一个数字是否包含0-9的所有数位
    public static boolean containsAllDigits(long number) {
        Set<Character> digits = new HashSet<>();
        String numberStr = String.valueOf(number);
        
        for (char c : numberStr.toCharArray()) {
            digits.add(c);
        }
        
        // 检查是否包含0-9所有数字
        for (char digit = '0'; digit <= '9'; digit++) {
            if (!digits.contains(digit)) {
                return false;
            }
        }
        
        return true;
    }

    // 查找大于x的整数y，使得x * y是一个完美数
    public static long findPerfectNumber(long x) {
        long y = x + 1;
        while (true) {
            long product = x * y;
            if (containsAllDigits(product)) {
                return y;
            }
            y++;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入整数 x: ");
        long x = scanner.nextLong();
        
        long y = findPerfectNumber(x);
        System.out.println("构造的整数 y 为: " + y);
    }
}
