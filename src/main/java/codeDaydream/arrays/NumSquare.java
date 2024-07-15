package codeDaydream.arrays;

import java.util.Arrays;

/*
 *Author：Victor_htq
 *Package：codeDaydream.arrays
 *Project：DSnAL
 *name：NumSquare
 *Date：2024/6/17  10:23
 *Filename：NumSquare
 */
public class NumSquare {
    public int[] sortedSquares(int[] nums) {
        int[] ans = new int[nums.length];
        int left = 0;
        int right = nums.length - 1;
        int i = nums.length - 1;
        while (left <= right) {
            if (nums[left] * nums[left] < nums[right] * nums[right]) {
                ans[i--] = nums[right] * nums[right];
                right--;
            } else {
                ans[i--] = nums[left] * nums[left];
                left++;
            }
        }
        return ans;
    }
}
