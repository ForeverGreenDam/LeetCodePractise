package com.greendam;

public class T108_EZ {
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums == null || nums.length == 0){
            return null;
        }
        if(nums.length==1){
            return new TreeNode(nums[0]);
        }
        int mid = nums.length/2;
        TreeNode root = new TreeNode(nums[mid]);
        int[] left = new int[mid];
        int[] right = new int[nums.length - mid - 1];
        for (int i = 0; i < nums.length; i++) {
            if(i<mid){
                left[i] = nums[i];
            } else if(i>mid){
                right[i - mid - 1] = nums[i];
            }
        }
        root.left = sortedArrayToBST(left);
        root.right = sortedArrayToBST(right);
        return root;
    }
}
