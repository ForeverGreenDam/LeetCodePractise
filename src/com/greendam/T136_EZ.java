package com.greendam;

public class T136_EZ {
    public static void main(String[] args) {
    int[] a ={2,1,1};
        T136_EZ t = new T136_EZ();
        System.out.println(t.singleNumber(a));
    }
    public int singleNumber(int[] nums) {
        int ans = nums[0];
        for (int i = 1; i < nums.length; i++) {
            ans ^= nums[i];
        }
        return ans;
    }
}
