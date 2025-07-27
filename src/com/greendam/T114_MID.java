package com.greendam;

import java.util.ArrayList;
import java.util.List;

public class T114_MID {
    List<TreeNode> list = new ArrayList<>();
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        preOrder(root);

        for (int i = 0; i < list.size(); i++) {
            list.get(i).left = null;
            if(i<list.size() - 1) {
                list.get(i).right = list.get(i + 1);
            }
            else {
                list.get(i).right = null;
            }
        }
    }
    public void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        list.add(root);
        preOrder(root.left);
        preOrder(root.right);
    }
}
