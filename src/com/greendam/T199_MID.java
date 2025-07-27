package com.greendam;

import java.util.*;

public class T199_MID {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        root.left = node2;
        root.right = node3;
        node2.right = node5;
        node3.right = node4;
        T199_MID t199_mid = new T199_MID();
        List<Integer> rightSideView = t199_mid.rightSideView(root);
        System.out.println(rightSideView);

    }
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        //广度优先搜索
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        int count=0;
        while(!queue.isEmpty()) {
            ans.add(queue.peekLast().val);
            count = queue.size();
            for (int i = 0; i < count; i++) {
                TreeNode poll = queue.poll();
                if (poll.left != null) {
                    queue.addLast(poll.left);
                }
                if (poll.right != null) {
                    queue.addLast(poll.right);
                }
            }
        }
        return ans;
    }
}
