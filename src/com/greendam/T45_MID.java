package com.greendam;

public class T45_MID {
    public static void main(String[] args) {
        int[] nums = {2,1};
        T45_MID t = new T45_MID();
        System.out.println(t.jump(nums));
    }
    public int jump(int[] nums) {
        //贪心：搜寻覆盖范围内的下一步最远距离
       int maxReach=nums[0];
         int step=1;
         int i=0;
         if(nums.length==1){
             return 0;
         }
         while(true){
             if(maxReach>=nums.length-1){
                 break;
             }
             int temp=i+1+nums[i];
             for(int j=i+1;j<temp;j++){
                 if(j>=nums.length){break;}
                 if(j+nums[j]>maxReach){
                     maxReach=j+nums[j];
                        i=j;
                 }
             }
             step++;
         }
         return step;
    }
}
