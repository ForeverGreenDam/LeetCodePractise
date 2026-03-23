package com.greendam.redo;

import java.util.ArrayList;
import java.util.List;

public class T994 {
    private static final int[][] DIRECTIONS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public int orangesRotting(int[][] grid) {
        List<int[]> list = new ArrayList<>();
        int fresh=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    fresh++;
                }
                if(grid[i][j]==2){
                    list.add(new int[]{i,j});
                }
            }
        }

        int ans=0;
        while(fresh>0&&!list.isEmpty()){
            ans++;
            //这里每次我们创建新的列表，将新腐烂的橘子放到新列表，原先的老列表仅用来遍历
            List<int []> temp=list;
            list=new ArrayList<>();
            for (int[] ints : temp) {
                for (int[] direction : DIRECTIONS) {
                    int i=ints[0]+direction[0];
                    int j=ints[1]+direction[1];
                    if(i>=0&&i<grid.length&&j>=0&&j<grid[0].length&&grid[i][j]==1){
                        grid[i][j]=2;
                        fresh--;
                        list.add(new int[]{i,j});
                    }
                }
            }
        }
        return fresh==0?ans:-1;
    }
}
