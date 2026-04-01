package com.greendam.redo;

public class T287 {
    public int findDuplicate(int[] nums) {
        //思路借鉴T142环形链表
        int slow=0,fast=0;
        while(true){
            slow=nums[slow];
            fast=nums[nums[fast]];
            if(slow==fast){
                break;
            }
        }
        //找到相遇点
        fast=0;
        while(slow!=fast){
            slow=nums[slow];
            fast=nums[fast];
        }
        return fast;
    }
}
