package com.greendam;

public class T79_MID {
    public static void main(String[] args) {
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        String word = "SEE";
        T79_MID t = new T79_MID();
        System.out.println(t.exist(board, word));
    }
    public boolean exist(char[][] board, String word) {
        char[] words = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board,i,j,0,words)) {
                    return true;
                }
            }
        }
        return false;
    }
    public boolean dfs(char[][] board,int i,int j,int k,char[] word){
        if(word[k]=='0'|| i<0||j<0
                ||i>=board.length||j>=board[0].length
        ||board[i][j]!=word[k]){
            return false;
        }
        if(k==word.length-1){
            return true;
        }
        board[i][j] = '0';
        boolean flag = dfs(board,i+1,j,k+1,word)||dfs(board,i,j+1,k+1,word)
                ||dfs(board,i-1,j,k+1,word)||dfs(board,i,j-1,k+1,word);
        //回溯
        board[i][j] = word[k];
        return flag;
    }
}
