package com.greendam;

public class T62_MID {
    public static void main(String[] args) {
        System.out.println(uniquePaths(3, 7));
    }
    public static int uniquePaths(int m, int n) {
        //dp数组含义：到第i行j列的路径数
        int [][]dp = new int[m][n];
        //初始化第一行和第一列（重点）
        for (int i = 0; i < m; i++) {
            dp[i][0] =1;
        }
        for (int j = 0; j < n; j++) {
            dp[0][j] =1;
        }
        //递推公式：dp[x][y]=dp[x][y-1]+dp[x-1][y]
        //解释：要到达（x,y）点一定是从（x-1,y）或者（x,y-1）点直接一笔过来的，所以路径数是两者之和
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i][j-1] + dp[i-1][j];
            }
        }
        return dp[m-1][n-1];
    }
}
