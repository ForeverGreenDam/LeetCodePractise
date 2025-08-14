package com.greendam;

public class T121_EZ {
    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        int[] price2={7,6,4,3,1};
        System.out.println(new T121_EZ().maxProfit(price2));
    }
    public int maxProfit(int[] prices) {
        int min=Integer.MAX_VALUE;
        int max=0;
        for (int price : prices) {
            if (price < min) {
                min = price;
            }
            max = Math.max(max, price - min);
        }
        return max;
    }
}
