package com.greendam;

public class T543_EZ {
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null) {
            return 0;
        }
        //经过根节点的情况
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        int diameter = leftDepth + rightDepth;
        //未经过根节点的情况
        int leftDiameter = diameterOfBinaryTree(root.left);
        int rightDiameter = diameterOfBinaryTree(root.right);
        return Math.max(diameter, Math.max(leftDiameter, rightDiameter));
    }
    /**
     * 返回左右子树的最大深度
    **/
    public int maxDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }
}
