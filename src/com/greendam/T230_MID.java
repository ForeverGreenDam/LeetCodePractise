package com.greendam;

public class T230_MID {
    int k;
    int ans;
    public int kthSmallest(TreeNode root, int k) {
        this.k = k;
       dfs(root);
        return ans;
    }
    public void dfs(TreeNode root){
        if(root==null|| k==0) {
            return;
        }
        dfs(root.left);
        k--;
        if(k==0) {
            ans = root.val;
        }
        dfs(root.right);
    }

}
