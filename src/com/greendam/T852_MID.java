package com.greendam;

public class T852_MID {
    public static void main(String[] args) {
        System.out.println(peakIndexInMountainArray(new int[]{3,5,3,2,0}));
    }
    //二分法,时间复杂度O(log n)
    public static int  peakIndexInMountainArray(int[] arr) {
            int mid = (arr.length-1)/2;
            int left=0;
            int right=arr.length-1;
            while(!(arr[mid]>=arr[mid -1]&&arr[mid]>=arr[mid +1])){
                //山峰在右边
              if(arr[mid]<arr[mid +1]){
                  left=mid;
                  mid=(left+right)/2;
              } else //山峰在左边
                  if (arr[mid] < arr[mid - 1]) {
                  right=mid;
                  mid=(left+right)/2;
              }
            }
            return mid;
    }
}
