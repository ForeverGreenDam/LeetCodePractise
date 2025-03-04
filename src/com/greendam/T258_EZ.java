package com.greendam;
//简单递归实现
public class T258_EZ {
    public static void main(String[] args) {
            Solution258 s= new Solution258();
            int str=38;
            System.out.println(s.addDigits(str));
        }
    }
class Solution258 {
    public int addDigits(int num) {
        int ans=0;
        while(num/10>0){
            ans=ans+num%10;
            num=num/10;
        }
        ans=ans+num;
        if(ans>=10){
            ans = addDigits(ans);
        }
        return ans;
    }

}
