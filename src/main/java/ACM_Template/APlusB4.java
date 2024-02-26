package ACM_Template;

import java.io.FileOutputStream;
import java.util.Scanner;

/*
 *Author：Victor_htq
 *Package：ACM_Template
 *Project：DSnAL
 *name：APlusB4
 *Date：2024/2/26  10:37
 *Filename：APlusB4
 */
public class APlusB4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            if (n == 0) break;
            int all = 0;
            for (int i = 0; i < n; i++) {
                all += scanner.nextInt();
            }
            System.out.println(all);
        }
    }
}
