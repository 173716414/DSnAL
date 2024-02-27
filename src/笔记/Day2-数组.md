## 算法-数组

### 二分查找

```java
class Solution {
    public int search(int[] nums, int target) {
        if (target < nums[0] || target > nums[nums.length - 1]) {
            return -1;
        }
        int left = 0;
        int right = nums.length-1;

        while(left <= right) {
            int mid = left + ((right - left) >> 1);
            if(nums[mid] < target) {
                left = mid+1;
            }
            else if(nums[mid] > target) {
                right = mid-1;
            }
            else {
                return mid;
            }
        }
        return -1;
    }
}
```

### 27、数组移除元素

```java
class Solution {
    public int removeElement(int[] nums, int val) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] != val) continue;
            for (int j = i ; j < n-1; j++) {
                nums[j] = nums[j+1];
                
            }
            n--;
            i--;
        }
        return n;
    }
}
```

```java
//相向双指针法
class Solution {
    public int removeElement(int[] nums, int val) {
        int left = 0;
        int right = nums.length - 1;
        while(right >= 0 && nums[right] == val) right--; //将right移到从右数第一个值不为val的位置
        while(left <= right) {
            if(nums[left] == val) { //left位置的元素需要移除
                //将right位置的元素移到left（覆盖），right位置移除
                nums[left] = nums[right];
                right--;
            }
            left++;
            while(right >= 0 && nums[right] == val) right--;
        }
        return left;
    }
}
```

