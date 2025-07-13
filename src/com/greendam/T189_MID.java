package com.greendam;

import java.util.Arrays;
import java.util.HashMap;

public class T189_MID {
    public static void main(String[] args) {
        int[] nums={1,2,3,4,5,6,7};
        int k=3;
        rotate(nums,k);
    }
    public static void rotate(int[] nums, int k) {
        //index，num hashmap
        HashMap<Integer,Integer> map=new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(i,nums[i]);
        }
       map.forEach((k1,v1)->{
           int index= (k1+k)%nums.length;
           nums[index]=v1;
       });
        System.out.println(Arrays.toString(nums));
    }
}
