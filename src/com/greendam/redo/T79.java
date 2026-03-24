package com.greendam.redo;

public class T79 {
    public static void main(String[] args) {
        T79 t=new T79();
        char[][] board={{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word="ABCB";
        System.out.println(t.exist(board,word));
    }
    Boolean ans=false;
    public boolean exist(char[][] board, String word) {
        boolean[][] used=new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                //遍历每个点，让其从每个点开始蔓延寻找，直到找到ans为true或者遍历完所有点为止
                dfs(board,word,i,j,0,used);
                if(ans){
                    break;
                }
            }
        }
        return ans;
    }
    //从一个点开始蔓延寻找，找到就把ans设置为true
    public void dfs(char[][] board, String word,int x,int y,int now,boolean used[][]){
        if(x<0||x>=board.length||y<0||y>=board[0].length){
            return;
        }
        if(board[x][y]!=word.charAt(now)){
            return;
        }
        if(used[x][y]){
            return;
        }
        if(board[x][y]==word.charAt(now)&&now==word.length()-1){
            ans=true;
            return;
        }
        used[x][y]=true;
        dfs(board,word,x+1,y,now+1,used);
        dfs(board,word,x-1,y,now+1,used);
        dfs(board,word,x,y+1,now+1,used);
        dfs(board,word,x,y-1,now+1,used);
        used[x][y]=false;
        }
}
