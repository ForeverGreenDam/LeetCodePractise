package com.greendam.redo;

import java.util.Arrays;

public class T42 {
    public static void main(String[] args) {
    int height[]={0,1,0,2,1,0,1,3,2,1,2,1};
        T42 solution=new T42();
        System.out.println(solution.trap(height));
    }
    public int trap(int[] height) {
        int maxIndexLeft =0;
        int max=0;
        for (int i = 0; i <height.length ; i++) {
            if(height[i]>max){
                max=height[i];
                maxIndexLeft =i;
            }
        }
        int[] ans = Arrays.copyOf(height,height.length);
        for(int i=1;i<maxIndexLeft;i++){
            ans[i]=Math.max(ans[i-1],ans[i]);
        }
        for(int i=height.length-2;i>maxIndexLeft;i--){
            ans[i]=Math.max(ans[i+1],ans[i]);
        }
        int sum=0;
        for(int i=0;i<height.length;i++){
            sum+=ans[i]-height[i];
        }
    return sum;
    }
}
