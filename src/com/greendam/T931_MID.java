package com.greendam;

public class T931_MID {
    //也是基础的矩阵dp，直接秒了
    public static void main(String[] args) {
    int[][] matrix = {
            {2,1,3},
            {6,5,4},
            {7,8,9}
    };
        System.out.println(minFallingPathSum(matrix));
        //输出：13

    }
    public static int minFallingPathSum(int[][] matrix) {
        int [][] dp = new int[matrix.length][matrix[0].length];
        //初始化第一行
        for (int i = 0; i < matrix[0].length; i++) {
            dp[0][i]=matrix[0][i];
        }
        //从第二行开始
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if(j==0){
                    dp[i][j]=Math.min(dp[i-1][j],dp[i-1][j+1])+matrix[i][j];
                } else if (j==matrix[0].length-1) {
                    dp[i][j]=Math.min(dp[i-1][j],dp[i-1][j-1])+matrix[i][j];
                }
                else{
                    dp[i][j]=Math.min(Math.min(dp[i-1][j],dp[i-1][j-1]),Math.min(dp[i-1][j],dp[i-1][j+1]))+matrix[i][j];
                }
            }
        }
        //找出最后一行的最小值
        int min = dp[matrix.length-1][0];
        for (int i = 1; i < matrix[0].length; i++) {
            min=min<dp[matrix.length-1][i]?min:dp[matrix.length-1][i];
        }
        return min;
    }
}
