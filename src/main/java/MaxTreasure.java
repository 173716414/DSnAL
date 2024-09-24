import java.util.Scanner;

public class MaxTreasure {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int q = scanner.nextInt();
        for (int query = 0; query < q; query++) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int k = scanner.nextInt();

            long maxT = 0;
            int maxS = n + m - 2;
            int limitS = Math.min(k, maxS);

            for (int s = 0; s <= limitS; s++) {
                int i = Math.min(n - 1, s);
                int j = s - i;
                if (j > m - 1) {
                    j = m - 1;
                    i = s - j;
                    if (i < 0 || i > n - 1) {
                        continue;
                    }
                }

                long stepsRemaining = k - s;
                long visits = stepsRemaining + 1; // Initial visit plus revisits

                long cellValue = (long) i * m + j;

                long totalTreasure = visits * cellValue;

                if (totalTreasure > maxT) {
                    maxT = totalTreasure;
                }
            }

            System.out.println(maxT);
        }
        scanner.close();
    }
}
