package com.greendam;

public class T236_MID {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q) {
            return root;
        }
        //分类讨论：1. 如果左子树找到了p或q，右子树也找到了p或q，则公共祖先是root
        //2. 如果左子树找到了p或q，右子树没有找到，则公共祖先在左子树，即递归左子树的返回值
        //3. 如果左子树没有找到，右子树找到了p或q，则公共祖先在右子树，即递归右子树的返回值
        //两边只需要找到一个p或q就不必再往下递归了，因为此时仅需判断另一半是否找到p或q即可
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if(left != null && right != null) {
            return root;
        }else if(left == null && right != null) {
            return right;
        } else {
            return left;
        }
    }
}
