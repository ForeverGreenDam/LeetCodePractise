package com.greendam;

import java.util.Arrays;

public class T48_MID {
    public static void main(String[] args) {
    int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}};
        rotate(matrix);
    }

    public static void rotate(int[][] matrix) {
        //先变换为转置矩阵
        int temp;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i; j < matrix[0].length; j++) {
                temp = matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=temp;
            }
        }
        //再镜像操作
        int mid = matrix[0].length / 2;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < mid; j++) {
                int target=0;
                if(matrix[0].length%2==0){
                    //偶数坐标计算方法
                    target=2*mid-j-1;
                }else {
                    //奇数坐标计算方法
                    target=2*mid-j;
                }
                temp = matrix[i][j];
                matrix[i][j]=matrix[i][target];
                matrix[i][target]=temp;
            }
        }
        //输出结果
        System.out.println(Arrays.deepToString(matrix));
    }
}
