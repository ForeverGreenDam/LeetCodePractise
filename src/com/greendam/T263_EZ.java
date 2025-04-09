package com.greendam;

public class T263_EZ {
    public static void main(String[] args) {
        System.out.println(isUgly(6));
        System.out.println(isUgly(8));
        System.out.println(isUgly(14));
        System.out.println(isUgly(1));
    }
    /**
     * 263. 丑数
     *递归验证这个数是不是能被2,3,5整除（注意非正整数要额外判断）
     * @param n
     * @return
     */
    public  static boolean isUgly(int n){
        if(n<1) return false; //单独判断
        //出口
        if(n==1) return true;
        if(n%2==0){
            return isUgly(n/2);
        }else if(n%3==0){
            return isUgly(n/3);
        }else if(n%5==0){
            return isUgly(n/5);
        }else //出口
            return false;
    }
}
