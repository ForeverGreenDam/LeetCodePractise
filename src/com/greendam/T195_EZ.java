package com.greendam;

public class T195_EZ {
    public static void main(String[] args) {
        int[] arr = {12,345,2,6,7896};
        System.out.println(findNumbers(arr));
    }
    public static int findNumbers(int[] nums) {
        int ans=0;
        for(int num: nums){
            if((num>=10&&num<100) ||
                    (num>=1000&&num<10000)||
                num==100000){
                ans++;
            }
        }
        return ans;
    }

}
