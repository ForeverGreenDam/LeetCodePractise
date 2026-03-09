package com.greendam.redo;

public class T240 {
    public boolean searchMatrix(int[][] matrix, int target) {
        boolean flag = false;
        int m= matrix.length;
        int n= matrix[0].length;
        int x=0;
        int y= n-1;
        int rightTop = matrix[x][y];
        while(x<m && y>=0){
           if(rightTop==target){
               flag = true;
               break;
           }
           if(rightTop<target){
               x++;
               if(x<m){
                   rightTop = matrix[x][y];
               }
           }else if(rightTop>target){
               y--;
               if(y>=0){
                   rightTop = matrix[x][y];
               }
           }
        }

        return flag;
    }
}
