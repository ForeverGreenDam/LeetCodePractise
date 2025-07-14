package com.greendam;

public class T240_MID {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 3}
        };
        int target =3;
        System.out.println(searchMatrix1(matrix, target));
    }
    public static boolean searchMatrix(int[][] matrix, int target) {
      //分治法,排除
        int i=0;
        int j=matrix[0].length-1;
        while(i<matrix.length && j>=0){
            if(matrix[i][j]==target){
                return true;
            } else if (matrix[i][j] > target) {
                j--;
            }else{
                i++;
            }
        }
        return false;
    }
    public static boolean searchMatrix1(int[][] matrix, int target) {
        //二分法，依次对每一行进行二分查找
        for (int i = 0; i < matrix.length; i++) {
            int left=0;
            int right=matrix[0].length-1;
            int mid=(left+right)/2;
            while(left<=right){
                if(matrix[i][mid]==target){
                    return true;
                } else if (matrix[i][mid]>target) {
                    right=mid-1;
                    mid=(left+right)/2;
                }else {
                    left=mid+1;
                    mid=(left+right)/2;
                }
            }
        }
    return false;
    }
}
