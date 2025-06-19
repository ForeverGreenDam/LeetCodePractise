package com.greendam;

public class T11_MID {
    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(height));
    }

    /**
     *
     * 在底边宽度固定的情况下，由于水的高度由左右两边高度的较小者决定。因此，只有将较小者向中间移动，才有可能遇到更高的木板，使得盛水的容量增大。较高的那块木板往里面走，只可能让盛水越来越少。
     *
     * @author liweiwei1419
     * @link https://leetcode.cn/problems/container-with-most-water/solutions/3695637/shuang-zhi-zhen-java-by-liweiwei1419-xy9t/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public static int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int max=0;
        while(left<right){
            int area = Math.min(height[left],height[right])*(right-left);
            max = Math.max(max,area);
            // 移动较小的那一边
            if(height[left]<=height[right]){
                left++;
            } else {
                right--;
            }
        }
        return max;
    }
}
