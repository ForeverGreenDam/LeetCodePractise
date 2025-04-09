package com.greendam;

public class T231_EZ {
    public static void main(String[] args) {
        System.out.println(isPowerOfTwo(2048));// 2^11
        System.out.println(isPowerOfThree(27));//
    }

    /**
     * 思路：如果一个数是2的幂，则她的二进制表示只有一个1，他减一之后该位后面的就全变成1，两者进行与运算结果为0
     */
    public static boolean isPowerOfTwo(int n) {
       if(n<1)
           return false;
       else
           return (n&(n-1))==0;
    }

    /**
     * 递归
     */
    public static boolean isPowerOfThree(int n) {
        if(n<1) return false;
        if(n==1) return true;
        if (n%3 !=0) return false;
      if(n/3==1) return true;

      return  isPowerOfThree(n/3);
    }
}
