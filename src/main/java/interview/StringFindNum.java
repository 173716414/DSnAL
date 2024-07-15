package interview;

import java.util.Scanner;

/*
 *Author：Victor_htq
 *Package：面试
 *Project：DSnAL
 *name：StringFindNum
 *Date：2024/6/21  11:16
 *Filename：StringFindNum
 */
public class StringFindNum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] words = sc.nextLine().split(",");
        int ans = 0;
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            int j = 0;
            int k = 0;
            while (j < word.length() && k < s.length()) {
                if (word.charAt(j) == s.charAt(k)) {
                    j++;
                }
                k++;
            }
            if (j == word.length()) {
                ans++;
            }
        }
        System.out.println(ans);
    }
}
