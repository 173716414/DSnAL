package test;

import java.util.*;

public class ChoirStrength {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int l = scanner.nextInt();
        int[] abilities = new int[n];
        int minAbility = Integer.MAX_VALUE;
        int maxAbility = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            abilities[i] = scanner.nextInt();
            minAbility = Math.min(minAbility, abilities[i]);
            maxAbility = Math.max(maxAbility, abilities[i]);
        }

        int result = binarySearch(abilities, n, k, l, minAbility, maxAbility);
        System.out.println(result);
    }

    private static int binarySearch(int[] abilities, int n, int k, int l, int low, int high) {
        int result = low;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (isPossible(abilities, n, k, l, mid)) {
                result = mid;
                low = mid + 1; // 尝试更大的最小能力值
            } else {
                high = mid - 1;
            }
        }
        return result;
    }

    private static boolean isPossible(int[] abilities, int n, int k, int l, int m) {
        List<Integer> positions = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (abilities[i] < m) {
                positions.add(i);
            }
        }

        int count = 0;
        int index = 0;
        while (index < positions.size()) {
            count++;
            if (count > k) {
                return false;
            }
            int end = positions.get(index) + l - 1;
            while (index < positions.size() && positions.get(index) <= end) {
                index++;
            }
        }
        return true;
    }
}
