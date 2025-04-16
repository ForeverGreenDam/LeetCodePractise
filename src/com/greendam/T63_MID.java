package com.greendam;

public class T63_MID {
    public static void main(String[] args) {
        int[][] obstacleGrid = {
                {0,0,0},
                {0,1,0},
                {0,0,0}
        };
        System.out.println(uniquePathsWithObstacles(obstacleGrid));
    }
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
    //dp数组含义：到达(i,j)的路径数
        int[][] dp=new int[obstacleGrid.length][obstacleGrid[0].length];
        //本题和T62_MID的区别在于，有障碍物的格子路径数直接为0，其余操作和T62_MID一致
        //初始化时，如果第一行有障碍物，则后面的格子都不能到达，同理第一列也一样
        for (int i = 0; i < obstacleGrid.length; i++) {
            if (obstacleGrid[i][0] == 1){
                break;
            }
            dp[i][0]=1;
        }
        for (int j = 0; j < obstacleGrid[0].length; j++) {
            if (obstacleGrid[0][j] == 1){
                break;
            }
            dp[0][j]=1;
        }
        for(int i=1;i<obstacleGrid.length;i++){
            for(int j=1;j<obstacleGrid[0].length;j++){
                if(obstacleGrid[i][j]==1){
                    dp[i][j]=0;
                }else{
                    dp[i][j]=dp[i-1][j]+dp[i][j-1];
                }
            }
        }
        return dp[obstacleGrid.length-1][obstacleGrid[0].length-1];
    }
}
