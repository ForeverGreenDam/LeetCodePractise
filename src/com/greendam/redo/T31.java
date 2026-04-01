package com.greendam.redo;

public class T31 {
    public void nextPermutation(int[] nums) {
        if(nums.length<2){
            return;
        }
            int p1=nums.length-2;
            int p2=nums.length-1;
    while(p1>=0&&p2>=0&&nums[p1]>=nums[p2]){
            p1--;
            p2--;
    }
    if(p1<0||p2<0){
        fanzhuan(nums,0,nums.length-1);
    }else{
        //找从p2到末尾的大于nums[p1]的最小数
        int min=nums[p2];
        int index=p2;
        for(int i=p2;i< nums.length;i++){
            if(nums[i]>nums[p1]){
                if(nums[i]<=min){
                    min=nums[i];
                    index=i;
                }
            }
        }
        //交换
        int temp=nums[p1];
        nums[p1]=nums[index];
        nums[index]=temp;
        //反转p2到末尾
        //如果交换的正好是p2，说明后半部分已经是最小的了，则不用反转了
            fanzhuan(nums,p2,nums.length-1);
      }
    }
    public void fanzhuan(int[] nums,int start,int end){
         while(start<end){
             int temp=nums[start];
             nums[start]=nums[end];
             nums[end]=temp;
             start++;
             end--;
         }
        }
    }
