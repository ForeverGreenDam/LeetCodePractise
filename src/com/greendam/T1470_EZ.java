package com.greendam;

import java.util.Arrays;

public class T1470_EZ {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(shuffle(new int[]{2, 5, 1, 3, 4, 7}, 3)));
    }
    public static int[] shuffle(int[] nums, int n) {
        int ans[]=new int[2*n];
        for(int i=0;i<2*n;i++){
            if (i<n)
                ans[2*i]=nums[i];
            else
                ans[2*(i-n)+1]=nums[i];
        }
        return ans;
    }
}
