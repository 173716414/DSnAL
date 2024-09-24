package test;

public class MatrixRecreation {
    public static void recreateMatrix(int n, int m, int[] rows, int[] cols) {
        int tempRow = 0, tempCol = 0;
        for (int i = 0; i < n; i++) {
            tempRow ^= rows[i];
        }
        for (int j = 0; j < m; j++) {
            tempCol ^= cols[j];
        }
        if (tempRow != tempCol) {
            System.out.println("NO");
            return;
        }
        System.out.println("YES");
        int[][] result = new int[n][m];
        int s = tempRow ^ rows[n - 1] ^ cols[m - 1];
        for (int i = 0; i < n; i++) {
            result[i][m - 1] = rows[i];
        }
        for (int j = 0; j < m; j++) {
            result[n - 1][j] = cols[j];
        }
        result[n - 1][m - 1] = s;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int n = 3;
        int m = 3;
        int[] rows = {0, 7, 6};
        int[] cols = {2, 15, 12};
        recreateMatrix(n, m, rows, cols);
    }
}
