package com.greendam;

public class T101_EZ {
    public boolean isSymmetric(TreeNode root) {
        if(root == null) {
            return true;
        }
        return isSame(root.left, root.right);
    }
    public boolean isSame(TreeNode t1, TreeNode t2) {
        if(t1 == null && t2 == null) {
            return true;
        }
        if(t1 == null || t2 == null) {
            return false;
        }
        return t1.val==t2.val&& isSame(t1.left,t2.right) && isSame(t1.right,t2.left);
    }
}
