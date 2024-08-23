package test;

public class BeanCollector {

    public static int collectBeans(String beans, String commands) {
        int i = 0, j = 0;
        int collected = 0;

        while (i < beans.length() && j < commands.length()) {
            if (commands.charAt(j) == beans.charAt(i)) {
                collected++;
                i++;
            } else if (commands.charAt(j) == '*') {
                // 持续收集当前字符，直到遇到不同的字符
                while (i < beans.length() && beans.charAt(i) == commands.charAt(j - 1)) {
                    collected++;
                    i++;
                }
                j++; // 移动到下一个命令
            } else {
                j++;
            }
        }

        return collected;
    }

    public static void main(String[] args) {
        String beans = "abbbbccdefg";
        String commands = "ab*c*d";
        int result = collectBeans(beans, commands);
        System.out.println("收集到的豆豆数量: " + result);
    }
}
