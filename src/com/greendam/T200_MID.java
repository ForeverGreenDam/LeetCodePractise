package com.greendam;

public class T200_MID {
    public static void main(String[] args) {
        char[][] grid = {
            {'1', '1', '0', '0', '0'},
            {'1', '1', '0', '0', '0'},
            {'0', '0', '1', '0', '0'},
            {'0', '0', '0', '1', '1'}
        };
        T200_MID solution = new T200_MID();
        System.out.println(solution.numIslands(grid));
    }
    public  int numIslands(char[][] grid) {
        int ans=0;
    for (int i = 0; i < grid.length; i++) {
        for (int j = 0; j < grid[0].length; j++) {
            if(grid[i][j]=='1'){
                ans++;
                dfs(grid,i,j);
            }
        }
    }
        return ans;
    }
    /**
     * 岛屿问题标准深度优先遍历模版
      */
    public void dfs(char[][] grid, int i, int j) {
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] =='0'){
            return;
        }
        grid[i][j] = '0';
        dfs(grid, i+1, j);
        dfs(grid, i-1, j);
        dfs(grid, i, j+1);
        dfs(grid, i, j-1);
    }
}
