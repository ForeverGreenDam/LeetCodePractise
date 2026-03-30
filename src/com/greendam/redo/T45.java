package com.greendam.redo;

public class T45 {
    public static void main(String[] args) {
        T45 t45 = new T45();
        int[] nums={2,3,1,1,4};
        System.out.println(t45.jump(nums));
    }
    public int jump(int[] nums) {
            int curMax=0;
            int nextMax=0;
            int ans=0;
        for (int i = 0; i < nums.length-1; i++) {
            nextMax=Math.max(nextMax,i+nums[i]);
            if(curMax==i){
                curMax=nextMax;
                ans++;
            }
        }
        return ans-1;
    }
}
