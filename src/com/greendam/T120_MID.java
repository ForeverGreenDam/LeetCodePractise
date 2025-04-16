package com.greendam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class T120_MID {
    public static void main(String[] args) {
        List<List<Integer>> grid = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        list1.add(2);
        List<Integer> list2 = new ArrayList<>();
        list2.add(3);
        list2.add(4);
        List<Integer> list3 = new ArrayList<>();
        list3.add(6);
        list3.add(5);
        list3.add(7);
        List<Integer> list4 = new ArrayList<>();
        list4.add(4);
        list4.add(1);
        list4.add(8);
        list4.add(3);
        grid.add(list1);
        grid.add(list2);
        grid.add(list3);
        grid.add(list4);
        System.out.println(minimumTotal(grid));
    }
   public static final  int MAX= 10001;
    public static int minimumTotal(List<List<Integer>> triangle) {
        //dp数组含义：到达(i,j)的最小路径和
        //本题和T64_MID类似，不过是将原来的矩形数组变成了直角三角形数组，其余部分用MAX填充
        //dp[x][y]=min(dp[x-1][y],dp[x-1][y-1])+grid[x][y];
        int length= triangle.get(triangle.size()-1).size();
        //将list转化为数组
        int [][] grid = new int[triangle.size()][length];
        for (int i=0;i<grid.length;i++){
            for (int j=0;j<grid[0].length;j++){
                grid[i][j] = MAX;
            }
        }
        for (int i = 0; i < triangle.size(); i++) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                grid[i][j] = triangle.get(i).get(j);
            }
        }
            int [][] dp = new int[grid.length][grid[0].length];
            //初始化
            dp[0][0]=grid[0][0];
            for (int k = 1; k < grid.length; k++) {
                dp[k][0] = grid[k][0]+dp[k-1][0];
            }
            for (int k = 1; k < grid[0].length; k++) {
                dp[0][k]=grid[0][k]+dp[0][k-1];
            }
            //动态规划
            for (int i = 1; i < grid.length ; i++) {
                for (int j = 1; j < grid[0].length ; j++) {
                dp[i][j] = Math.min(dp[i-1][j],dp[i-1][j-1])+grid[i][j];
                }
            }
            //找出最后一行的最小值
        return Arrays.stream(dp[grid.length - 1]).min().getAsInt();
        }
}
