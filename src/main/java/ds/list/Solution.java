package ds.list;

import java.util.*;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] res =new int[k];
        Map<Integer, Integer> map = new HashMap<>();
        for(int n: nums) map.put(n, map.getOrDefault(n,0) + 1);
        List<int[]> list = new ArrayList<int[]>();
        for (int i : map.keySet()) {
            list.add(new int[]{i, map.get(i)});
        }
        Collections.sort(list, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[1] - o1[1];
            }
        });
        for (int i = 0; i < k; i++) {
            res[i] = list.get(i)[0];
        }
        return res;
    }
}