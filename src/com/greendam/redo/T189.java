package com.greendam.redo;

import java.util.Arrays;

public class T189 {
    public static void main(String[] args) {
        int[] nums={1,2,3,4,5,6,7};
        int k=3;
        rotate(nums,k);
    }
    public static void rotate(int[] nums, int k) {
        //向前移动k次，如果k大于nums长度，则相当于移动了k%nums.length次
        if (k>=nums.length){
            k=k%nums.length;
        }
        //翻转数组三次
        reverse(nums,0, nums.length-1);
        reverse(nums,0,k-1);
        reverse(nums,k,nums.length-1);
        System.out.println(Arrays.toString(nums));
    }
    public static void reverse(int[] nums,int start,int end){
        if(start<0||end>=nums.length){
            return;
        }
        while (start<end){
            int temp=nums[start];
            nums[start]=nums[end];
            nums[end]=temp;
            start++;
            end--;
        }
    }

}
