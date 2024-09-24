package test;

public class OddWeightSubstrings {
    
    public static void main(String[] args) {
        String s = "1";
        System.out.println(countOddWeightSubstrings(s));
    }

    // 计算权值为奇数的奇数长度子串的数量
    public static int countOddWeightSubstrings(String s) {
        int n = s.length();
        int count = 0;

        // 遍历所有长度为奇数的子串
        for (int length = 1; length <= n; length += 2) {  // 只考虑奇数长度
            for (int i = 0; i + length <= n; i++) {
                String substring = s.substring(i, i + length);
                int weight = calculateWeight(substring);
                if (weight % 2 == 1) {
                    count++;
                }
            }
        }
        return count;
    }

    // 计算一个子串的权值
    public static int calculateWeight(String substring) {
        int weight = 0;
        char[] chars = substring.toCharArray();
        for (int i = chars.length - 1; i >= 0; i--) {
            if (chars[i] == '0') {
                for (int j = 0; j < i; j++) {
                    if (chars[j] == '0') {
                        chars[j] = '1';
                    } else {
                        chars[j] = '0';
                    }
                }
                weight++;
            }
        }
        return weight;
    }
}
