package com.greendam;

public class T74_MID {
    public static void main(String[] args) {
    int[][] matrix = {
            {1, 3, 5, 7},
            {10, 11, 16, 20},
            {23, 30, 34, 50},
            {60, 61, 62, 63}
        };
        int target = 3;
        System.out.println(new T74_MID().searchMatrix(matrix, target));
    }
    public boolean searchMatrix(int[][] matrix, int target) {
        int m=matrix.length-1;
        int n=matrix[0].length-1;
        int right=n,left=0;
        int line=-1;
        for(int i=0;i<=m;i++){
            if(target>=matrix[i][0]&&target<=matrix[i][n]){
                line=i;
                break;
            }
        }
        if(line==-1){
            return false;
        }
        //二分查找
        while(left<=right){
            int mid=(left+right)/2;
            if(matrix[line][mid]==target){
                return true;
            }else if(matrix[line][mid]>target){
                right = mid-1;
            }else{
                left = mid + 1;
            }
        }
        return false;
    }
}
