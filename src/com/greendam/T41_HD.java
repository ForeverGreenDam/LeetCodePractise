package com.greendam;

import java.util.Hashtable;
import java.util.Set;
import java.util.TreeSet;

public class T41_HD {
    public static void main(String[] args) {
        int[] arr = { 3,4,-1,1 };
        System.out.println(firstMissingPositive2(arr));
    }
    public static int firstMissingPositive(int[] nums) {
        Set<Integer> set = new TreeSet<>();
        for (int num : nums) {
            if (num > 0) {
                set.add(num);
            }
        }
        int i=1;
        for (Integer num : set) {
            if(num!= i){
                break;
            }
            i++;
        }
        return i;
    }
    public static int firstMissingPositive1(int[] nums) {
        Hashtable<Integer,Integer> ht = new Hashtable<>();
        for (int num : nums) {
            if (num > 0) {
                ht.put(num, 1);
            }
        }
        int i = 1;
        for (; i <=nums.length ; i++) {
            boolean containsKey = ht.containsKey(i);
            if(!containsKey){
              break;
            }
        }
        return i;
    }
    /**
     * 原地hash
     */
    public static int firstMissingPositive2(int[] nums) {
        boolean flag = true;
        //先处理0以及负数
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]==1){
                flag = false;
            }
            if(nums[i]<=0){
                //将0和负数都设置为1
                nums[i] = 1;
            }
        }
        if(flag){
            return 1;
        }
        //遍历整个数组，将元素值作为索引，设置索引处的元素值为负数
        for (int num : nums) {
            int temp = Math.abs(num);
            if(temp<=nums.length){
                nums[temp-1]=-1*Math.abs(nums[temp-1]);
            }
        }
        //遍历整个数组，找到第一个正数的索引，说明该索引+1就是缺失的正数
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]>0){
            return i+1;
          }
        }
        return nums.length+1;
    }
}
