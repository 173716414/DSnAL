package test;

import java.util.Stack;

public class MinNumberFromArray {
    public static String minNumber(int[] nums, int k) {
        Stack<Integer> stack = new Stack<>();
        int toRemove = nums.length - k;

        for (int num : nums) {
            while (!stack.isEmpty() && stack.peek() > num && toRemove > 0) {
                stack.pop();
                toRemove--;
            }
            stack.push(num);
        }

        // 将多余的元素移除以确保栈中仅保留k个元素
        while (stack.size() > k) {
            stack.pop();
        }

        // 构造最终的数字，确保首位不为0
        StringBuilder result = new StringBuilder();
        boolean leadingZero = true;

        for (int digit : stack) {
            // 跳过前导0，确保首位不为0
            if (leadingZero && digit == 0) {
                continue;
            }
            leadingZero = false;
            result.append(digit);
        }

        // 如果最终结果为空，或仅有0存在，返回"0"
        if (result.length() == 0) {
            return "0";
        }

        // 确保结果的长度是k，处理可能因为leadingZero跳过了过多元素
        String finalResult = result.toString();
        if (finalResult.length() > k) {
            return finalResult.substring(0, k);
        } else if (finalResult.length() < k) {
            // 如果leadingZero导致结果不够k个，需要补齐
            int numLeadingZeroes = k - finalResult.length();
            return "0".repeat(numLeadingZeroes) + finalResult;
        }

        return finalResult;
    }

    public static void main(String[] args) {
        int[] nums = {1, 0, 3, 5, 9, 2, 7, 8};
        int k = 4;
        System.out.println(minNumber(nums, k)); // 输出结果应该是 "1035"
    }
}
