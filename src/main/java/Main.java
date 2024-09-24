import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int T = scanner.nextInt();  // 读取数据组数
        for (int t = 0; t < T; t++) {
            int N = scanner.nextInt();  // 箱子的容量
            int n = scanner.nextInt();  // 玩具的数量
            int C = scanner.nextInt();  // 填充物的数量
            
            int[] toys = new int[n];
            for (int i = 0; i < n; i++) {
                toys[i] = scanner.nextInt();  // 读取每个玩具的大小
            }
            
            // 动态规划数组，dp[j]表示容量为j时是否能被恰好填满
            boolean[] dp = new boolean[N + 1];
            dp[0] = true;  // 初始化，容量为0的箱子可以不放东西，直接填满
            
            // 处理玩具
            for (int i = 0; i < n; i++) {
                for (int j = N; j >= toys[i]; j--) {
                    dp[j] = dp[j] || dp[j - toys[i]];
                }
            }
            
            // 处理填充物
            for (int i = 1; i <= C; i++) {
                for (int j = N; j >= 1; j--) {
                    if (dp[j - 1]) {
                        dp[j] = true;
                    }
                }
            }
            
            // 输出结果
            if (dp[N]) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
        
        scanner.close();
    }
}
