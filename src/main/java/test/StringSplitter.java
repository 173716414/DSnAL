package test;

import java.util.ArrayList;
import java.util.Scanner;

public class StringSplitter {

    // 自定义实现的字符串分割函数
    public static String[] splitString(String str, String delimiter) {
        if (str == null || delimiter == null || delimiter.isEmpty()) {
            return new String[]{str}; // 如果字符串或分隔符为空，返回原字符串
        }

        ArrayList<String> result = new ArrayList<>();
        int start = 0; // 子字符串的起始位置
        int index;     // 当前找到的分隔符位置

        while ((index = indexOf(str, delimiter, start)) != -1) {
            // 提取子字符串，并将其添加到结果列表中
            result.add(str.substring(start, index));
            // 更新起始位置到分隔符的后一个字符
            start = index + delimiter.length();
        }

        // 添加最后一个分割后的部分（或者原始字符串的最后部分）
        result.add(str.substring(start));

        // 将ArrayList转换为数组并返回
        return result.toArray(new String[0]);
    }

    public static int indexOf(String s, String target, int startIndex) {
        // 如果起始位置大于或等于s的长度，直接返回-1
        if (startIndex >= s.length() || startIndex < 0) {
            return -1;
        }

        // 如果目标字符串为空，返回起始位置
        if (target.isEmpty()) {
            return startIndex;
        }

        // 遍历主字符串，从startIndex开始搜索
        for (int i = startIndex; i <= s.length() - target.length(); i++) {
            // 检查从i开始的子串是否与目标字符串匹配
            int j = 0;
            while (j < target.length() && s.charAt(i + j) == target.charAt(j)) {
                j++;
            }
            if (j == target.length()) {
                return i;  // 找到匹配，返回索引
            }
        }

        // 没有找到，返回-1
        return -1;
    }
    public static int customIndexOf(String str, String subStr) {
        int strLen = str.length();
        int subStrLen = subStr.length();

        // 遍历主字符串
        for (int i = 0; i <= strLen - subStrLen; i++) {
            int j;

            // 比较主字符串和子字符串中的字符
            for (j = 0; j < subStrLen; j++) {
                if (str.charAt(i + j) != subStr.charAt(j)) {
                    break;
                }
            }

            // 如果子字符串完全匹配
            if (j == subStrLen) {
                return i;
            }
        }

        // 如果没有找到子字符串，返回-1
        return -1;
    }
    public static void main(String[] args) {
        // 示例字符串
        String str = "apple|banana|orange|grape";
        // 分隔符
        String delimiter = "|";

        // 调用分割函数
        String[] result = splitString(str, delimiter);

        // 输出结果
        for (String part : result) {
            System.out.println(part);
        }
    }
}
