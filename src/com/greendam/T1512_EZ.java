package com.greendam;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class T1512_EZ {
    public static void main(String[] args) {
        Solution1512 solution = new Solution1512();
        int[] nums={1,2,3,1,1,3};
        System.out.println(solution.numIdenticalPairs_3(nums));
    }
}
//暴力解法，时间复杂度O(n^2)
class Solution1512 {
    public int numIdenticalPairs_1(int[] nums) {
        int ans=0;
        for (int i = 0; i < nums.length; i++) {
            for (int j=i+1;j<nums.length;j++){
                if (nums[i]==nums[j]){
                    ans++;
                }
            }
        }
        return ans;
    }
    //Count how many times each number appears.
    // If a number appears n times, then n * (n – 1) // 2 good pairs can be made with this number.
    //时间复杂度O(n)，但是速度比暴力解法慢
    public int numIdenticalPairs_2(int[] nums) {
       int ans=0;
       //使用HashMap存储每个数字出现的次数
        HashMap<Integer,Integer> map=new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])){
                map.put(nums[i],map.get(nums[i])+1);
            }else
                map.put(nums[i],1);
        }
//        map.keySet().forEach(key->{
//            ans.addAndGet(map.get(key) * (map.get(key) - 1) / 2);
//        });
        for (Integer i : map.keySet()) {
            ans+=map.get(i)*(map.get(i)-1)/2;
        }
        return ans;
    }
    //时间复杂度O(n)，空间复杂度O(1)，最快，但是不适合大数据
    //题目中说了nums[i]的范围是1-100，所以可以使用数组代替HashMap
    public int numIdenticalPairs_3(int[] nums) {
        int ans=0;
        int[] count=new int[101];
        for (int i = 0; i < nums.length; i++) {
            count[nums[i]]++;
        }
        for (int i = 0; i < count.length; i++) {
            ans+=count[i]*(count[i]-1)/2;
        }
        return ans;
    }
}