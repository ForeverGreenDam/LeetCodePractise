package com.greendam.redo;

import java.util.ArrayList;
import java.util.List;

public class T54 {
    public static void main(String[] args) {
        int[][] matrix = {
                {2,5},
                {8,4},
                {0,-1}
        };
        List<Integer> result= spiralOrder(matrix);
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
    public static List<Integer> spiralOrder(int[][] matrix) {
        int left = 0, right = matrix[0].length - 1, top = 0, bottom = matrix.length - 1;
        List<Integer> result = new ArrayList<>();
        if (right < 0 || bottom < 0) {
            return result;
        }
        while (left <= right && top <= bottom) {
            for (int i = left; i <= right; i++) {
                result.add(matrix[top][i]);
            }
            top++;
            for (int i = top; i <= bottom; i++) {
                result.add(matrix[i][right]);
            }
            right--;
            //注意边界条件，防止重复添加
            //向右和向左的进行条件判断，向下和向上的进行条件判断
            //这里取等号是因为top已经向下移动了一行，top所在行还没被录入，因此如果此时top和bottom重合了，那就说明这行需要录入
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    result.add(matrix[bottom][i]);
                }
                bottom--;
            }
            if (left <= right ) {
                for (int i = bottom; i >= top; i--) {
                    result.add(matrix[i][left]);
                }
                left++;
            }
        }
            return result;
        }
    }
