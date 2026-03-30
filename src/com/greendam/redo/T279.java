package com.greendam.redo;

public class T279 {

    public int numSquares(int n) {
        int[] bp=new int[n+1];
        bp[0]=0;
        for (int i = 1; i < n+1; i++) {
            bp[i]=i;
            for (int j = 1; j <= Math.sqrt(i); j++) {
                bp[i]=Math.min(bp[i],bp[i-j*j]+1);
            }
        }
        return bp[n];
    }
}
