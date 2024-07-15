package codeDaydream.arrays;

public class Day1 {
    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3, 4, 5};
        int target = 3;
        System.out.println(new BinarySearch().search(array, target));
        String userDir = System.getProperty("user.dir");
        System.out.println(userDir);
    }

    public int removeElement(int[] nums, int val) {
        int res = nums.length;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) {
                for (int j = i; j < nums.length - 1; j++) {
                    nums[j] = nums[j+1];
                }
                res--;
            }
        }
        return res;
    }

    public int removeElement2(int[] nums, int val) {
        int slowIndex = 0;
        for (int fastIndex = 0; fastIndex < nums.length; fastIndex++) {
            if (nums[fastIndex] != val) {
                nums[slowIndex] = nums[fastIndex];
                slowIndex++;
            }
        }
        return slowIndex;
    }
}

class BinarySearch{
    public int search(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (array[mid] > target) {
                right = mid - 1;
            } else if (array[mid] < target) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}

