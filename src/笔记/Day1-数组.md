## 数组

### ACM模式输出输出通用模板

#### A+B

```java
//A+B
import java.util.Scanner;

public class APlusB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // scanner.nextInt();
        int A = scanner.nextInt();
        int B = scanner.nextInt();
        System.out.println("A + B = " + (A + B));
    }
}
```

```java
//A+B II 多组数据，每组第一行为n，之后输入n行两个整数
import java.util.Scanner;

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

```

```java
//A+B问题IV
//每行的第一个数N，表示本行后面有N个数。
//如果N=0时，表示输入结束，且这一行不要计算。
import java.util.Scanner;

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

```

```java
//输入包含若干行，每行输入两个整数a和b，由空格分隔。
//2 4
//11 19
import java.util.Scanner;

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
```

```java
//每门课的成绩分为A、B、C、D、F五个等级，为了计算平均绩点，规定A、B、C、D、F分别代表4分、3分、2分、1分、0分。
//有多组测试样例。每组输入数据占一行，由一个或多个大写字母组成，字母之间由空格分隔。
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
```

