package com.greendam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class T2845_MID {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(1);
        list.add(9);
        list.add(6);
        int modulo = 3;
        int k=0;
        System.out.println(countInterestingSubarrays1(list,modulo,k));
    }
    public static long countInterestingSubarrays(List<Integer> nums, int modulo, int k) {
        //先将nums转为数组
        int n = nums.size();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = nums.get(i);
        }
        //定义dp[i][j]表示在[i,j]范围内满足arr[i]%modulo==k的索引i的数量，要满足i>=j，这是个三角数组
        //递推公式：dp[i][j]=dp[i][j-1]+(arr[j]%modulo==k?1:0)
        //由递推公式可知，要想知道当前dp值必须知道左边的dp值，索引要从左往右遍历
        //初始化仅用初始化每一行的开头第一个元素，也就是对角线的元素
        //最后遍历dp数组，如果dp[i][j]%modulo==k，则ans++，返回ans
        int[][] dp = new int[n][n];
        //初始化
        for (int i = 0; i < n; i++) {
            dp[i][i] = arr[i] % modulo == k ? 1 : 0;
        }
        //递推
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                dp[i][j]=dp[i][j-1]+(arr[j]%modulo==k?1:0);
            }
        }
        //遍历dp数组
        int ans=0;
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                if(dp[i][j]%modulo==k){
                    ans++;
                }
            }
        }
        return ans;
    }
    public static long countInterestingSubarrays1(List<Integer> nums, int modulo, int k) {
        //先将nums转为数组
        int n = nums.size();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = nums.get(i);
        }
        //上一个内存溢出，将二维上三角矩阵转为一维数组
        int[]dp=new int [n*(n+1)/2];
        //换算对角线的元素下标为mn-m*(m-1)/2（m=0,1,2...n-1）
        //初始化
        int m=0;
        int ans=0;
        int temp=0;
        for (int i = 0; i < n*(n+1)/2; i++) {
            if(i==m*n-m*(m-1)/2){
                dp[i]=arr[m] % modulo == k ? 1 : 0;
                m++;
                temp=0;
            }else{
                dp[i]=dp[i-1]+(arr[m+temp]%modulo==k?1:0);
                temp++;
            }
            if(dp[i]%modulo==k){
                ans++;
            }
        }
       return ans;
    }
    public static long countInterestingSubarrays2(List<Integer> nums, int modulo, int k) {
        //改为一维数组仍然超出内存限制，以下是官方题解
        //使用前缀和+哈希表
        int n = nums.size();
        HashMap<Integer, Integer> cnt = new HashMap<>();
        long ans = 0;
        int prefix = 0;
        cnt.put(0, 1);
        for (int i = 0; i < n; i++) {
            prefix += nums.get(i) % modulo == k ? 1 : 0;
            ans += cnt.getOrDefault((prefix - k + modulo) % modulo, 0);
            cnt.put(prefix % modulo, cnt.getOrDefault(prefix % modulo, 0) + 1);
        }
        return ans;

    }
}
