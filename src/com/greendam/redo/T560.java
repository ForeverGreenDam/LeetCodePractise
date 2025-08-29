package com.greendam.redo;

import java.util.HashMap;
import java.util.Map;

public class T560 {
    public static void main(String[] args) {

    }
    public int subarraySum(int[] nums, int k){
        int[] preSum = new int[nums.length ];
        preSum[0]=nums[0];
        int ans=0;
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        for (int i = 0; i < nums.length; i++) {
            if(i>0){
                preSum[i]=preSum[i-1]+nums[i];
            }
            int target = preSum[i]-k;
            if(map.containsKey(target)){
                ans+=map.get(target);
            }
            map.put(preSum[i],map.getOrDefault(preSum[i],0)+1);
        }
        return ans;
    }
}
