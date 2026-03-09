package com.greendam;

import java.util.Arrays;

public class T88_EZ {
    public static void main(String[] args) {

    }
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1=m-1;
        int p2=n-1;
        int i=m+n-1;
        for(;i>=0;i--){
            if(p1<0||p2<0){
                break;
            }
            if(nums1[p1]>=nums2[p2]){
                nums1[i]=nums1[p1];
                p1--;
            }else{
                nums1[i]=nums2[p2];
                p2--;
            }
        }
        while(p2>=0){
            nums1[i]=nums2[p2];
            i--;
            p2--;
        }
        System.out.println(Arrays.toString(nums1));
    }
}
