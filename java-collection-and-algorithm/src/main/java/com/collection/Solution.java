package com.collection;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int findDuplicate(int[] nums) {
        Map<Integer, Integer> frequency = new HashMap<>();
        for (int i : nums) {
            frequency.put(i, frequency.getOrDefault(i, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : frequency.entrySet()) {
            if (entry.getValue() > 1) {
                return entry.getKey();
            }
        }
        return -1;
    }
}
