package com.greendam;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Match448_1 {
    public static void main(String[] args) {
        System.out.println(maxProduct(1234));
    }
    public static int maxProduct(int n) {
        List<Integer> nums = new ArrayList<Integer>();
        while (n>0){
            nums.add(n%10);
            n/=10;
        }

        Integer max1 = Collections.max(nums);
        nums.remove(max1);
        Integer max2 = Collections.max(nums);
        return max1*max2;
    }
}
