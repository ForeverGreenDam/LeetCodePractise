package com.greendam.redo;

import java.util.ArrayList;
import java.util.List;

public class T51 {
    public static void main(String[] args) {
        T51 t=new T51();
        int n=4;
        System.out.println(t.solveNQueens(n));
    }
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j]='.';
            }
        }
        dfs(ans,0,board);
    return ans;
    }
    //判断当前位置放Q是否合法
    public boolean isValid(int x,int y,char[][] board){
        //right
        for (int i = y+1; i <board[0].length; i++) {
            if(board[x][i]=='Q'){
                return false;
            }
        }
        //left
        for (int i = 0; i <y; i++) {
            if(board[x][i]=='Q'){
                return false;
            }
        }
        //up
        for (int i = 0; i <x; i++) {
            if(board[i][y]=='Q'){
                return false;
            }
        }
        //down
        for (int i = x+1; i < board.length ; i++) {
            if(board[i][y]=='Q'){
                return false;
            }
        }
        //右上
        for (int i = x-1,j=y+1; i >=0&&j<board[0].length ; i--,j++) {
            if(board[i][j]=='Q'){
                return false;
            }
        }
        //右下
        for (int i = x+1,j=y+1; i <board.length&&j<board[0].length ; i++,j++) {
            if(board[i][j]=='Q'){
                return false;
            }
        }
        //左上
        for (int i = x-1,j=y-1; i >=0&&j>=0 ; i--,j--) {
            if(board[i][j]=='Q'){
                return false;
            }
        }
        //左下
        for (int i = x-1,j=y-1; i >=0&&j>=0 ; i--,j--) {
            if(board[i][j]=='Q'){
                return false;
            }
        }
        return true;
    }
    public void dfs(List<List<String>> ans ,int row,char[][] board){
        if(row==board.length){
            //收集棋盘
            List<String> res = new ArrayList<>();
            for (int x = 0; x < board.length; x++) {
                StringBuilder sb=new StringBuilder();
                for (int y = 0; y < board[0].length; y++) {
                    sb.append(board[x][y]);
                }
                String line = sb.toString();
                res.add(line);
            }
            ans.add(new ArrayList<>(res));
            return;
        }
        for(int i=0;i<board[0].length;i++){
            if(isValid(row,i,board)){
                board[row][i]='Q';
                dfs(ans,row+1,board);
                board[row][i]='.';
            }
        }

    }
}
