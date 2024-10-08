package codeDaydream.arrays;

/*
 *Author：Victor_htq
 *Package：codeDaydream
 *Project：DSnAL
 *name：BinarySearch
 *Date：2024/6/17  10:01
 *Filename：BinarySearch
 */
public class BinarySearch2 {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
