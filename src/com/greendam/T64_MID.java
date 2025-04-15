package com.greendam;

public class T64_MID {
    public static void main(String[] args) {
            int[][] grid = {
                    {1,3,1},
                    {1,5,1},
                    {4,2,1}
            };
        System.out.println(minPathSum(grid));
    }
    public static int minPathSum(int[][] grid) {
        //和T62类似
        //dp数组含义：到第i行j列的最短路径
        int [][]dp = new int[grid.length][grid[0].length];
        //初始化第一行和第一列（重点）
        dp[0][0] = grid[0][0];
        for (int i = 1; i < grid.length; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        for (int i = 1; i < grid[0].length; i++) {

            dp[0][i]=dp[0][i-1]+grid[0][i];
        }
        //递推公式：dp[x][y]=min(dp[x][y-1],dp[x-1][y])+grid[x][y];
        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid[0].length; j++) {
                dp[i][j] = Math.min(dp[i][j - 1], dp[i - 1][j]) + grid[i][j];
            }
        }
        return dp[grid.length-1][grid[0].length-1];
    }
}
