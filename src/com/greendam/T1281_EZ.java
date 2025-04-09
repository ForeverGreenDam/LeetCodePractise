package com.greendam;
//简单递归实现
public class T1281_EZ {
    public static void main(String[] args) {
            Solution1281 s= new Solution1281();
            int str=234;
            System.out.println(s.subtractProductAndSum(str));
        }
    }
class Solution1281 {
    public int subtractProductAndSum(int n) {
        int sum=0;
        int x=1;
        while(n/10>0){
            sum+=n%10;
            x*=n%10;
            n/=10;
        }
        sum+=n;
        x*=n;
        return x-sum;
    }
}
