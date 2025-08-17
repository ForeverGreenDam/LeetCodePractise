package com.greendam;

import java.util.Arrays;

public class T287_MID {
    public static void main(String[] args) {
        int[] nums = {1, 3, 4, 2, 2};
        T287_MID solution = new T287_MID();
        System.out.println(solution.findDuplicate(nums));
    }
    public int findDuplicate(int[] nums) {
        Arrays.sort(nums);
        int temp = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (temp != nums[i]) {
                temp = nums[i];
            } else {
                break;
            }
        }
        return temp;
    }
    public int findDuplicate1(int[] nums) {
        int slow = 0, fast = 0;
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);
        slow = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}
