package com.greendam;

/**
 * 第161场双周赛
 * @author ForeverGreenDam
 */
public class Match161_1_MID {
    public static void main(String[] args) {
        int[] nums = {2,3,4};
        System.out.println(splitArray(nums));
    }
        public static long splitArray(int[] nums) {
            long sumA=0,sumB=0;
            for (int i = 0; i < nums.length; i++) {
                if(i == 1 || (i % 2 == 0&& i != 2)){
                    sumB+=nums[i];
                    continue;
                }
                boolean flag=false;
                for (int j =2; j <= Math.pow(i,0.5); j++) {
                    if(i % j == 0){
                        flag=true;
                        break;
                    }
                }
                if(flag){
                    sumB+=nums[i];
                }else {
                    sumA+=nums[i];
                }
            }
            return Math.abs(sumA-sumB);
        }
}
