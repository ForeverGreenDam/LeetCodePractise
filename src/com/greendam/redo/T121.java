package com.greendam.redo;

public class T121 {
    public int maxProfit(int[] prices) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int price : prices) {
            if(price<min){
                min=price;
            }
            max=Math.max(max,price - min);
        }
        return max;
    }
}
