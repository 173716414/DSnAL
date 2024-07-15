package algorithm;

/*
 *Author：Victor_htq
 *Package：algorithm
 *Project：DSnAL
 *name：mergeSort
 *Date：2024/6/6  14:32
 *Filename：mergeSort
 */
public class merge_sort {
    static void merge(int[] nums, int left, int mid, int right) {
        int[] tmp = new int[right - left + 1];
        int i = left, j = mid + 1, k = 0;
        while (i <= mid && j <= right) {
            if (nums[i] <= nums[j]) {
                tmp[k++] = nums[i++];
            } else {
                tmp[k++] = nums[j++];
            }
        }
        while (i <= mid) {
            tmp[k++] = nums[i++];
        }
        while (j <= right) {
            tmp[k++] = nums[j++];
        }
        for (k = 0; k < tmp.length; k++) {
            nums[left + k] = tmp[k];
        }
    }

    static void mergeSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = left + (right - left) / 2;
        mergeSort(nums, left, mid);
        mergeSort(nums, mid + 1, right);
        merge(nums, left, mid, right);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{5, 1, 3, 2, 4};
        // System.out.println(nums.toString());
        mergeSort(nums, 0, 4);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}
