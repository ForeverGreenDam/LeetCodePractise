package com.greendam;

import java.util.ArrayList;

import java.util.List;

public class T994_MID {
    public static void main(String[] args) {

    }
    public static final int[][] DIRS = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public int orangesRotting(int[][] grid) {
    //首先记录腐烂橘子的位置以及新鲜橘子的个数
        int m = grid.length;
        int n = grid[0].length;
        int fresh=0;
        List<int[]> bad = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    fresh++;
                } else if (grid[i][j] == 2) {
                    bad.add(new int[]{i, j});
                }
            }
        }
        int ans = 0;
        while(fresh>0&&!bad.isEmpty()){
            ans++;
            //取出这一层的结果
            List<int[]> tmp = bad;
            //清空bad列表，准备下一层
            bad= new ArrayList<>();
            //下面执行BFS
            for (int[] pos : tmp) {
                for (int[] dir : DIRS) {
                    int x = pos[0] + dir[0];
                    int y = pos[1] + dir[1];
                    //如果新鲜橘子被腐烂
                    if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == 1) {
                        grid[x][y] = 2;
                        //新鲜橘子数量减少
                        fresh--;
                        //加入到下一层的待处理列表
                        bad.add(new int[]{x, y});
                    }
                }
            }
        }
        return fresh>0? -1 : ans;
    }
}
