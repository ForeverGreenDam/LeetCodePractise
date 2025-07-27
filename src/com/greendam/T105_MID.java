package com.greendam;


import java.util.Arrays;

public class T105_MID {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        if (n == 0) {
            return null;
        }
        //preorder的第一个元素一定是根节点，从inorder中找到这个根节点的位置，inorder数组中这个位置以左是左子树的中序遍历，以右同理
        //记录左子树的大小，preorder中取出【1~leftSize】的元素即为左子树的前序遍历，剩下的元素即为右子树的前序遍历
        //递归调用即可求得所求，最后返回的是根节点
        int leftSize = 0;
        for (int i = 0; i < n; i++) {
            if(preorder[0]==inorder[i]){
                leftSize = i;
                break;
            }
        }
        int[] preorderLeft = Arrays.copyOfRange(preorder, 1, leftSize+1);
        int[] preorderRight = Arrays.copyOfRange(preorder, leftSize+1, n);
        int[] inorderLeft = Arrays.copyOfRange(inorder, 0, leftSize);
        int[] inorderRight = Arrays.copyOfRange(inorder, leftSize+1, n);
        TreeNode left = buildTree(preorderLeft, inorderLeft);
        TreeNode right = buildTree(preorderRight, inorderRight);
        return new TreeNode(preorder[0],left,right);
    }
}
