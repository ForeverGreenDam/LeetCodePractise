package com.greendam;

public class T70_EZ {
    public static void main(String[] args) {
        System.out.println(climbStairs(3));
    }
    //动态规划 斐波那契数列类型
    public static int climbStairs(int n) {
        if(n==0) return 0;
        if(n<=2) return n;
        int ans = 0;
        int pre1 = 1;
        int pre2 = 2;
        for(int i=3;i<=n;i++){
            ans = pre1 + pre2;
            pre1=pre2;
            pre2=ans;
        }
        return ans;
    }
}
