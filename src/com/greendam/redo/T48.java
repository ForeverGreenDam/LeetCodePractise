package com.greendam.redo;

public class T48 {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        //先沿水平线反转
        //在转置矩阵
        for (int i = 0; i < n/2; i++) {
            for (int j = 0; j < n; j++) {
                int top = matrix[i][j];
                int bottom = matrix[n-i-1][j];
                matrix[i][j] = bottom;
                matrix[n-i-1][j] = top;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
}
