package com.greendam;

public class T1007_MID {
    public static void main(String[] args) {
        int[] tops = {3,5,1,2,3};
        int[] bottoms = {3,6,3,3,4};
        System.out.println(minDominoRotations(tops, bottoms));
    }
    public static int minDominoRotations(int[] tops, int[] bottoms) {
        int[] ans= {-1,-1,-1,-1,-1,-1,-1};
        for(int i=1;i<=6;i++){
            ans[i]=check(tops,bottoms,i);
        }
        int min = Integer.MAX_VALUE;
        for(int i=1;i<=6;i++){
            if(ans[i]!=-1){
                min = Math.min(min,ans[i]);
            }
        }
        if(min==Integer.MAX_VALUE){
            min=-1;
        }
        return min;
    }
    public static int check(int[] tops,int[] bottoms,int i){
        int ansUp=0;
        int ansDown=0;
        for(int j = 0; j <tops.length; j++){
            if(tops[j]!= i && bottoms[j]!= i){
                return -1;
            }else if(tops[j]== i && bottoms[j]!=i){
                ansDown++;
            }else if(tops[j]!= i && bottoms[j]==i){
                ansUp++;
            }
        }
        return Math.min(ansUp,ansDown);
    }
}
