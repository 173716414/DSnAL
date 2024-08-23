package test;

import java.util.Scanner;

public class stringBuildoptimizer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String target = scanner.nextLine();
        int minoperations = Integer.MAX_VALUE;
// 遍历所有可能的复制点
        for (int i = 1; i < target.length(); i++) {
// 检查从0到1-1的子串是否等于从1到2*i-1的子串
            if (i * 2 <= target.length() && target.substring(0, i).equals(target.substring(i, 2 * i))) {// 计算操作次数:添加字符1次，复制粘贴1次，再添加剩余字符int operations =i+1+(target.length()-2 *i);minoperations = Math.min(min0perations,operations);

                if (minoperations == Integer.MAX_VALUE) {
                    minoperations = target.length();
                    System.out.println(minoperations);
                }
            }
            if (minoperations == Integer.MAX_VALUE) {
                minoperations = target.length();
            }
            System.out.println(minoperations);
        }
    }
}