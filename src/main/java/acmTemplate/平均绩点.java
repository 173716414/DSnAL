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
public class 平均绩点 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] items = line.split(" ");
            int all = 0;
            int flag = 0;
            for (String item : items) {
                if (flag == 1) {
                    break;
                }
                switch (item) {
                    case "A":
                        all += 1;
                        break;
                    case "B":
                        all += 2;
                        break;
                    case "C":
                        all += 3;
                        break;
                    case "D":
                        all += 4;
                        break;
                    case "F":
                        all += 5;
                        break;
                    default:
                        flag = 1;
                        System.out.println("Unknown");
                        break;
                }

            }
            if (flag == 0) {
                System.out.println(all);
            }
        }
        scanner.close();
    }
}
