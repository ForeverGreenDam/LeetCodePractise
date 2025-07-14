package com.greendam;

import java.util.ArrayList;
import java.util.List;

public class T54_MID {
    public static void main(String[] args) {
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        System.out.println(spiralOrder(matrix));
    }
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans= new ArrayList<>();
        // 右 下 左 上
       int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};
       int step = 0;
       int i=0;
       int j=0;
       int count = matrix.length* matrix[0].length;
       while(count>0){
           //添加当前元素
           if(matrix[i][j]!= Integer.MAX_VALUE) {
               ans.add(matrix[i][j]);
               // 标记已访问
               matrix[i][j] = Integer.MAX_VALUE;
               count--;
               i+= dirs[step][0];
                j+= dirs[step][1];
           }
           //判断是否需要转向
           if(i>=matrix.length||j>=matrix[0].length
                   || i<0||j<0
                   ||matrix[i][j]==Integer.MAX_VALUE){
                // 回退到上一个位置
                i-= dirs[step][0];
                j-= dirs[step][1];
                // 转向
               step++;
               // 保证step在0-3之间循环
               step%=4;
               // 再次移动到下一个位置
               i+= dirs[step][0];
               j+= dirs[step][1];
           }
       }
        return ans;
    }
}
