package com.greendam;

public class T1534_EZ {
    public static void main(String[] args) {
        Solution1534 s= new Solution1534();
        int[] arr = {3,0,1,1,9,7};
        int a = 7, b = 2, c = 3;
        System.out.println(s.countGoodTriplets_1(arr, a, b, c));
    }
}
class Solution1534 {
    //暴力求解
    public int countGoodTriplets_1(int[] arr, int a, int b, int c) {
        int ans=0;
        for (int i=0;i<arr.length-2;i++){
            for (int j=i+1;j<arr.length-1;j++){
                for (int k=j+1;k<arr.length;k++){
                    if (Math.abs(arr[i]-arr[j])<=a
                    && Math.abs(arr[j]-arr[k])<=b
                    && Math.abs(arr[i]-arr[k])<=c){
                        ans++;
                    }
                }
            }
        }

        return ans;
    }
}