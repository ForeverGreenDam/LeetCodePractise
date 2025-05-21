package com.greendam;

import java.util.HashSet;
import java.util.Set;

public class T128_MID {
    public static void main(String[] args) {
        int[] nums={100,4,200,1,3,2};
        System.out.println(longestConsecutive(nums));
    }
    public static int longestConsecutive(int[] nums) {
        Set<Integer> set=new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int ans=0;
        for (Integer i : set) {
            if(set.contains(i-1)){
                continue;
            }
            int y=i+1;
            while(set.contains(y)){
                y++;
            }
            ans=Math.max(ans,y-i);
        }
        return ans;
    }
}
