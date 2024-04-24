package codeDaydream;

public class Day1 {
    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3, 4, 5};
        int target = 3;
        System.out.println(new BinarySearch().search(array, target));
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

