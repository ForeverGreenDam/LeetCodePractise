package com.greendam.redo;

import com.greendam.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class T102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> ans = new ArrayList<>();
        if (root==null) {
            return new ArrayList<>();
        }
        queue.add(root);
        while(queue.size()>0) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                if(queue.peek()!=null) {
                    TreeNode node = queue.poll();
                    list.add(node.val);
                    if (node.left!=null) {
                        queue.add(node.left);
                    }
                    if (node.right!=null) {
                        queue.add(node.right);
                    }
                }
            }
            ans.add(list);
        }
        return ans;
    }
}
