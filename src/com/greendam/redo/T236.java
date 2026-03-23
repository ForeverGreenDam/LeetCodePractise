package com.greendam.redo;

import com.greendam.TreeNode;
import sun.reflect.generics.tree.Tree;

public class T236 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return dfs(root, p, q);
    }
    public TreeNode dfs(TreeNode root, TreeNode p, TreeNode q){
        if(root==null){
            return null;
        }
        if(p==root||q==root){
            return root;
        }
        TreeNode left = dfs(root.left, p, q);
        TreeNode right = dfs(root.right, p, q);
        if(left==null&&right==null){
            return null;
        }
        if(left!=null&&right!=null){
            return root;
        }
        if(left!=null || right!=null){
            return left!=null?left:right;
        }
      return null;
    }
}
