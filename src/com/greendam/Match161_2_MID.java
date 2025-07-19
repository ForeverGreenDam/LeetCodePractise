package com.greendam;

/**
 * 第161场双周赛
 * @author ForeverGreenDam
 */
public class Match161_2_MID {
    public static void main(String[] args) {
        int[][] nums = {{0, 2, 1, 0, 0},
                {0, 5, 0, 0, 5},
                {0, 0, 1, 0, 0},
                {0, 1, 4, 7, 0},
                {0, 2, 0, 0, 8}};

        System.out.println(new Match161_2_MID().countIslands(nums, 5));
    }

     int sum = 0;
    public  int countIslands(int[][] grid, int k) {
        int ans = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] != 0) {
                    dfs(grid, i, j);
                    if (sum % k == 0) {
                        ans++;
                    }
                    sum=0;
                }
            }
        }
        return ans;
    }
    private  void dfs(int[][] grid, int i, int j) {
        // 出界，或者不是 '1'，就不再往下递归
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] ==0) {
            return;
        }

        sum += grid[i][j];
        grid[i][j] =0;
        dfs(grid, i, j - 1);
        dfs(grid, i, j + 1);
        dfs(grid, i - 1, j);
        dfs(grid, i + 1, j);
    }
}
