package com.greendam;

public class T1422_EZ {
    public static void main(String[] args) {
        System.out.println(maxScore("1111"));
    }
    public static int maxScore(String s) {
        int idx=s.length()-1;
        int maxScore=0;
        int left=0;
        int right=0;
        for (int i = 0; i <idx ; i++) {
            //遍历left
            for(int j=0;j<=i;j++){
                if(s.charAt(j)=='0'){
                    left++;
                }
            }
            //遍历right
            for(int j=i+1;j<=idx;j++){
                if(s.charAt(j)=='1'){
                    right++;
                }
            }
                //求和
                maxScore=maxScore>left+right?maxScore:left+right;
                //重置左右分数，进行下一种情况判断
                left=0;
                right=0;
        }
        return maxScore;
    }
}
