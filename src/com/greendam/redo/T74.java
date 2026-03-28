package com.greendam.redo;

public class T74 {
    public static void main(String[] args) {
        T74 t74 = new T74();
        int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        System.out.println(t74.searchMatrix(matrix, 10));
    }
    public boolean searchMatrix(int[][] matrix, int target) {
        int left=0,right=matrix.length-1;
        while(left<=right){
            int mid=(left+right)/2;
            if(matrix[mid][matrix[0].length-1]==target){
                return true;
            } else if (matrix[mid][matrix[0].length-1]>target) {
                right=mid-1;
            }else {
                left=mid+1;
            }
        }
        if(left>matrix.length-1){
            return false;
        }
        //对于left这一行进行二分查找
        int row = left;
        left=0;right=matrix[0].length;
        while(left<right){
            int mid=(left+right)/2;
            if(matrix[row][mid]==target){
                return true;
            } else if (matrix[row][mid]>target) {
                right=mid;
            }else {
                left=mid+1;
            }
        }
        return false;
    }
}
