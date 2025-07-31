package com.greendam;

public class T124_HD {
    int max=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
    dfs(root);
    return max;
    }
    public int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);
        max = Math.max(max, root.val + left + right);
        return Math.max( root.val + Math.max(left, right),0);
    }
}
