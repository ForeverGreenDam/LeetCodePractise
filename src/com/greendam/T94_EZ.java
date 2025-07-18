package com.greendam;

import java.util.ArrayList;
import java.util.List;

public class T94_EZ {

    List<Integer> result = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        if(root==null){
            return new ArrayList<>();
        }
            inorderTraversal(root.left);
            result.add(root.val);
            inorderTraversal(root.right);
            return result;
    }
}
