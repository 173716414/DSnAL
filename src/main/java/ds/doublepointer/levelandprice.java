package ds.doublepointer;

import java.util.Scanner;

/*
 *Author：Victor_htq
 *Package：ds.doublepointer
 *Project：DSnAL
 *name：levelandprice
 *Date：2024/6/12  17:03
 *Filename：levelandprice
 */
public class levelandprice {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = 4;
        int gap = 2;
        int[] level = new int[]{0, 3, 8, 10};
        int[] price = new int[]{14, 16, 9, 18};
        int maxPrice = 0;
        int i = 0;
        int j = 0;
        int tmp = 0;
        while (j < n && i < n){
            while (j < n && level[j] - level[i] <= gap) {
                tmp += price[j];
                j++;
            }
            maxPrice = Math.max(maxPrice, tmp);
            while (i < j && j < n && level[j] - level[i] > gap) {
                tmp -= price[i];
                i++;
            }
        }
        System.out.println(maxPrice);
    }
}
