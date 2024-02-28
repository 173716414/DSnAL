package acmTemplate;

import java.util.Scanner;

/*
 *Author：Victor_htq
 *Package：ACM_Template
 *Project：DSnAL
 *name：APlusB2
 *Date：2024/2/26  10:18
 *Filename：APlusB2
 */
public class APlusB2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            int A = scanner.nextInt();
            int B = scanner.nextInt();
            System.out.println(A+B);
        }
    }
}
