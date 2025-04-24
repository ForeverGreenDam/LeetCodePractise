package com.greendam;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;


public class T2799_MID {
    public static void main(String[] args) {
    int [] nums = {1,3,1,2,2};
        System.out.println(countCompleteSubarrays(nums));
    }
    public static int countCompleteSubarrays(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int notSame = set.size();
        int left=0;
        int right=nums.length-1;
        int ans=0;
        for(;right>=left&&right-left+1>=notSame;right--){
            HashMap<Integer,Integer> map = new HashMap<>();
            for(int i=left;i<=right;i++){
                if(map.containsKey(nums[i])){
                    map.put(nums[i],map.get(nums[i])+1);
                }
                else{
                    map.put(nums[i],1);
                }
            }
            while(map.size()==notSame){
               left++;
                if(left>right){
                    break;
                }
              if(map.containsKey(nums[left-1])){
                  map.put(nums[left-1],map.get(nums[left-1])-1);
                  if(map.get(nums[left-1])<=0){
                        map.remove(nums[left-1]);
                  }
                }
            }
            ans+=left;
            left=0;
        }
        return ans;
    }
}
