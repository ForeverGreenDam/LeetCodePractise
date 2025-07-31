package com.greendam;

import java.util.HashMap;
import java.util.Map;

public class T437_MID {
    int ans=0;
    public int pathSum(TreeNode root, int targetSum) {
        Map<Long, Integer> cnt = new HashMap<>();
        cnt.put(0L, 1);
        dfs(root, 0, targetSum, cnt);
        return ans;
    }
    public void dfs(TreeNode root, long s, int targetSum, Map<Long,Integer> cnt) {
        if (root == null) {
            return;
        }
        //这里的s相当于是T560_MID中的pre[i]，即前缀和
        //我们用递归的形式类比560的for循环
        s += root.val;
        long target=  s- targetSum;
        if(cnt.containsKey(target)){
            ans += cnt.get(target);
        }
        cnt.put(s, cnt.getOrDefault(s, 0) + 1);
        dfs(root.left, s, targetSum, cnt);
        dfs(root.right, s, targetSum, cnt);
        //回溯
        cnt.put(s, cnt.get(s) - 1);
    }
}
