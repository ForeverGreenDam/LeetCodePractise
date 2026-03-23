package com.greendam.redo;

import com.greendam.TreeNode;

public class T124 {
    int ans = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return ans;
    }
    public int dfs(TreeNode root){
        if(root==null){
            return 0;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);
        ans=Math.max(ans,root.val+left+right);
        return Math.max(0,root.val+Math.max(left,right));
    }
}
