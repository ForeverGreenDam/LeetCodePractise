package com.greendam;

/**
 * 第459场周赛
 * @author ForeverGreenDam
 */
public class Match459_1_EZ {
    public static void main(String[] args) {
        Match459_1_EZ match459_1_ez = new Match459_1_EZ();
        System.out.println(match459_1_ez.checkDivisibility(99));
    }
    public boolean checkDivisibility(int n) {
    int sum=0;
    int x=1;
    int temp=n;
    while(temp!=0){
        sum+=temp%10;
        x=x*(temp%10);
        temp/=10;
    }
    sum+=x;
        return n%sum==0;
    }
}
