package com.collection;

import java.util.HashMap;
import java.util.Map;

public class Bai5 {
    public static void main(String[] args) {
        int[] nums = new int[] { 3, 1, 3, 4, 2 };
        int result;
        Solution solution = new Solution();
        result = solution.findDuplicate(nums);
        System.out.println(result);
    }
}

// class Solution {
// public int findDuplicate(int[] nums) {

// // Phase 1: Find the intersection point
// int slow = nums[0];
// int fast = nums[0];

// do {
// slow = nums[slow];
// fast = nums[nums[fast]];
// } while (slow != fast);

// // Phase 2: Find the entrance of the cycle
// slow = nums[0];

// while (slow != fast) {
// slow = nums[slow];
// fast = nums[fast];
// }

// return slow;
// }
// }