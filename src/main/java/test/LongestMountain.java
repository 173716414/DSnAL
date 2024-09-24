package test;

public class LongestMountain {
    public static int longestMountain(int[] arr) {
        int n = arr.length;
        if (n < 3) return 0;

        int longest = 0;

        for (int i = 1; i < n - 1; i++) {
            // 找到山峰的顶点
            if (arr[i - 1] < arr[i] && arr[i] > arr[i + 1]) {
                int left = i - 1;
                int right = i + 1;

                // 向左扩展山峰
                while (left > 0 && arr[left - 1] < arr[left]) {
                    left--;
                }

                // 向右扩展山峰
                while (right < n - 1 && arr[right + 1] < arr[right]) {
                    right++;
                }

                // 计算当前山峰的长度
                int currentLength = right - left + 1;
                longest = Math.max(longest, currentLength);
            }
        }

        return longest;
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 4, 5, 1, 4};
        System.out.println(longestMountain(arr)); // 输出 5
    }
}
