package com.greendam.redo;

public class T55 {
    public boolean canJump(int[] nums) {
        int maxLength=0;
        for (int i = 0; i <nums.length ; i++) {

            //如果I比maxLength大，说明我根本到不了i,返回false
            if(i>maxLength){
                return false;
            }
            maxLength=Math.max(maxLength,i+nums[i]);
        }
        //i能走到最后一格子，说明能到
        return true;
    }
}
