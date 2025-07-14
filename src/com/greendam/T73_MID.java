package com.greendam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class T73_MID {
    public static void main(String[] args) {
        int[][] matrix={{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        setZeroes1(matrix);
    }
    public static void setZeroes0(int[][] matrix) {
        //首先把所有的0都变成-1
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
               if(matrix[i][j]==0){
                   matrix[i][j]=-1;
               }
            }
        }
        //然后遍历一遍，找到-1所在的行和列,替换为0
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
               if(matrix[i][j]==-1){
                   //替换行
                   for(int k=0;k<matrix[0].length;k++){
                       if(matrix[i][k]==-1){
                           continue;
                       }
                       matrix[i][k]=0;
                   }
                     //替换列
                     for(int k=0;k<matrix.length;k++){
                          if(matrix[k][j]==-1){
                            continue;
                          }
                          matrix[k][j]=0;
               }
            }
        }
    }
        //最后把所有的-1都变成0
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
               if(matrix[i][j]==-1){
                   matrix[i][j]=0;
               }
            }
        }
        System.out.println(Arrays.deepToString(matrix));
    }
    public static void setZeroes1(int[][] matrix) {
        List<Integer> m=new ArrayList<>();
        List<Integer> n=new ArrayList<>();
      for(int i=0;i<matrix.length;i++){
          for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]==0){
                    m.add(i);
                    n.add(j);
                }
          }
      }
        for(int i=0;i<m.size();i++){
            int row=m.get(i);
            int col=n.get(i);
            //替换行
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[row][j]==0){
                    continue;
                }
                matrix[row][j]=0;
            }
            //替换列
            for(int j=0;j<matrix.length;j++){
                if(matrix[j][col]==0){
                    continue;
                }
                matrix[j][col]=0;
            }
        }
            System.out.println(Arrays.deepToString(matrix));

    }
}
