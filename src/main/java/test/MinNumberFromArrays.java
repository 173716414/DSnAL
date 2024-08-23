package test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MinNumberFromArrays {

    public static void main(String[] args) {
        int[] nums1 = {3, 5, 1};
        int[] nums2 = {4, 2, 1};
        int k = 3;
        List<Integer> result = get(nums1, nums2, k, 2);
        for (int num : result) {
            System.out.print(num + " ");
        }
    }

    public static List<Integer> get(int[] arr1, int[] arr2, int k, int i) {
        // 从arr1中选出i个数
        List<Integer> selectedFromArr1 = selectKFromArray(arr1, i);
        // 从arr2中选出k-i个数
        List<Integer> selectedFromArr2 = selectKFromArray(arr2, k - i);
        // 合并两个数组
        List<Integer> mergedList = mergeLists(selectedFromArr1, selectedFromArr2);
        // 确保首位不为0
        if (mergedList.get(0) == 0) {
            return Collections.emptyList();
        }
        return mergedList;
    }

    private static List<Integer> selectKFromArray(int[] arr, int k) {
        List<Integer> result = new ArrayList<>();
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            while (!result.isEmpty() && result.size() + len - i > k && result.get(result.size() - 1) > arr[i]) {
                result.remove(result.size() - 1);
            }
            if (result.size() < k) {
                result.add(arr[i]);
            }
        }
        return result;
    }

    private static List<Integer> mergeLists(List<Integer> list1, List<Integer> list2) {
        List<Integer> result = new ArrayList<>();
        int i = 0, j = 0;
        while (i < list1.size() && j < list2.size()) {
            if (list1.get(i) < list2.get(j)) {
                result.add(list1.get(i++));
            } else {
                result.add(list2.get(j++));
            }
        }
        while (i < list1.size()) {
            result.add(list1.get(i++));
        }
        while (j < list2.size()) {
            result.add(list2.get(j++));
        }
        return result;
    }
}
