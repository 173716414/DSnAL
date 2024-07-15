package codeDaydream.arrays;

/*
 *Author：Victor_htq
 *Package：codeDaydream
 *Project：DSnAL
 *name：RemoveElement
 *Date：2024/6/17  10:09
 *Filename：RemoveElement
 */
public class RemoveElement {
    public int remove(int[] nums, int val) {
        int slow = 0;
        for (int fast = 0; fast < nums.length; fast++) {
            if (nums[fast] != val) {
                nums[slow++] = nums[fast];
            }
        }
        return slow;
    }
}
