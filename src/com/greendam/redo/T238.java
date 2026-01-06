package com.greendam.redo;

import java.util.Arrays;

public class T238 {
    public static void main(String[] args) {
        int[] nums={1,2,3,4};
        System.out.println(Arrays.toString(solution(nums)));
    }
    public static int[] solution(int[] nums){
        int[] pre=new int[nums.length];
        int[] end = new int[nums.length];
        pre[0]=1;
        end[nums.length-1]=1;
        for (int i=1,j= nums.length-2;i< nums.length;i++,j--){
            pre[i]=pre[i-1]*nums[i-1];
            end[j]=end[j+1]*nums[j+1];
        }
        int[] ans= new int[nums.length];
        for (int i=0;i<nums.length;i++){
            ans[i]=pre[i]*end[i];
        }
        return ans;
    }
}
