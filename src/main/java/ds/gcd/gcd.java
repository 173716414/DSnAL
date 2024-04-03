package ds.gcd;

/*
 *Author：Victor_htq
 *Package：ds.gcd
 *Project：DSnAL
 *name：gcd
 *Date：2024/4/2  20:16
 *Filename：gcd
 */
public class gcd {
    public static void main(String[] args) {
        int[] arr = new int[]{10,8,6, 8, 16};
        int res = arr[0];
        for (int i = 1; i < arr.length; i++) {
            res = gcd2(res, arr[i]);
        }
        System.out.println(res);
    }
    public static int gcd2(int a, int b) {
        int c = a % b;
        while (c != 0) {
            a = b;
            b = c;
            c = a % b;
        }
        return b;
    }
}
