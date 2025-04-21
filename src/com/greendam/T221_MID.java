package com.greendam;

public class T221_MID {
    public static void main(String[] args) {
        char[][] matrix={
                {'1','0','1','0','0'},
                {'1','0','1','1','1'},
                {'1','1','1','1','1'},
                {'1','0','0','1','0'}
        };
        System.out.println(maximalSquare(matrix));
    }
    public static int maximalSquare(char[][] matrix) {
        //dp数组含义：以matrix[i][j]为右下角的正方形的边长
        //本题解题关键：以（i，j）为右下角的最大正方形边长，取决于（i，j）这个点左边有多少连续的1以及上边有多少连续的1，以及以（i-1，j-1）为右下角的最大正方形边长
        //因此我们先建两个数组up[][]和left[][]，一个记录的是（i，j）向上有多少连续的1，一个是向左有多少连续的1，注意这里包括（i，j）这个点
        //之后我们写出递推公式：dp[i][j]=min(dp[i-1][j-1],up[i][j]-1,left[i][j]-1)+1
        int x=matrix.length;
        int y=matrix[0].length;
        int[][] up=new int[x][y];
        int[][] left=new int[x][y];
        int[][] dp=new int[x][y];
        //初始化up和left
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if(matrix[i][j]=='0'){
                    up[i][j]=0;
                    left[i][j]=0;
                }else{
                    for( int k=i;k>=0;k--) {
                        if (matrix[k][j] == '1') {
                            up[i][j]++;
                        } else {
                            break;
                        }
                    }
                    for( int k=j;k>=0;k--){
                            if (matrix[i][k]=='1'){
                                left[i][j]++;
                            }else{
                                break;
                            }
                    }
            }
        }
    }
        //初始化dp第一行第一列
        for (int i = 0; i < x; i++) {
            if(matrix[i][0]=='1'){
                dp[i][0]=1;
            }else{
                dp[i][0]=0;
            }
        }
        for (int i = 0; i < y; i++) {
             if(matrix[0][i]=='1'){
                dp[0][i]=1;
            }else{
                dp[0][i]=0;
            }
    }
        //递推
        for (int i = 1; i < x; i++) {
            for (int j = 1; j < y; j++) {
                if(matrix[i][j]=='1'){
                    dp[i][j]=Math.min(Math.min(dp[i-1][j-1],up[i][j]-1),left[i][j]-1)+1;
                }else{
                    dp[i][j]=0;
                }
             }
        }
        //求最大值
        int max=0;
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if(dp[i][j]>max){
                    max=dp[i][j];
                }
            }
        }
        //返回最大值的平方
        return max*max;
    }
}
