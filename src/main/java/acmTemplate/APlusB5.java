package acmTemplate;

import java.util.Scanner;

/*
 *Author：Victor_htq
 *Package：ACM_Template
 *Project：DSnAL
 *name：APlusB4
 *Date：2024/2/26  10:37
 *Filename：APlusB4
 */
public class APlusB5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            System.out.println(a + b);
        }
        scanner.close();
    }
}
