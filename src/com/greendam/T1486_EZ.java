package com.greendam;

public class T1486_EZ {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.xorOperation(10, 5));
    }
}
class Solution {
    public int xorOperation(int n, int start) {
        int[] nums=new int[n];
        int ans=start;
        for (int i=0;i<n;i++){
            nums[i]=start+2*i;
            if (i > 0) {
            ans=ans^nums[i];
            }
        }
        return ans;
    }
}