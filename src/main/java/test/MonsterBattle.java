package test;

import java.util.Scanner;

public class MonsterBattle {
    
    public static boolean canPass(int[] monsters, int initialLevel) {
        int currentLevel = initialLevel;
        for (int monster : monsters) {
            if (monster > currentLevel) {
                currentLevel--;
            } else if (monster < currentLevel) {
                currentLevel++;
            }
            if (currentLevel < 0) {
                return false;
            }
        }

        return currentLevel > initialLevel;
    }
    
    public static int findMinimumInitialLevel(int[] monsters) {
        int low = 1;
        int high = (int) 1e9;
        int answer = high;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (canPass(monsters, mid)) {
                answer = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] monsters = new int[n];
        for (int i = 0; i < n; i++) {
            monsters[i] = sc.nextInt();
        }
        System.out.println(findMinimumInitialLevel(monsters));
    }
}
