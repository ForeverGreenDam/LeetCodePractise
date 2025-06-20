package com.greendam;
/**
 * @author ForeverGreenDam
 */
public class T42_HD {
    public static void main(String[] args) {
    int [] height1 = {0,1,0,2,1,0,1,3,2,1,2,1};
    int [] height2 = {4,2,0,3,2,5};
        System.out.println(trap(height1));
        System.out.println(trap(height2));
    }

    /**
     * Trapping Rain Water
     * 思路：先根据数组最大值填充整个矩形空间，然后分别从两端到中间依次遍历到最高点，每次遍历设置当前的高度为左右两边的最小值，
     * 如果最小值小于初始height，则设置当前高度为初始height。最后将我们得到的数组和减去原数组的和即为所求。
     * 本质上是因为接完雨水之后整个数组变成一个从低到高再从高到低的形状。
     * 特殊情况：如果有多个max值，取第一个出现的max值作为最高点。（其实取哪个都行）
     * @param height 墙的高度数组
     * @return 雨水总量
     */
    public static int trap(int[] height) {
        int n = height.length;
        int max=0;
        int index = 0;
        for (int i = 0; i < n; i++) {
           if (height[i] > max) {
                max = height[i];
                index = i;
            }
           }
        //确定好边界
        int [] arr = new int[n];
        arr[0]=height[0];
        arr[index]=max;
        arr[n-1]=height[n-1];
        for(int i = 1;i<index;i++){
            arr[i] = Math.max(arr[i-1], height[i]);
        }
        for (int i = n-2; i >index ; i--) {
            arr[i] = Math.max(arr[i+1], height[i]);
        }
        //计算雨水
        int ans=0;
        for(int i=0;i<n;i++){
            ans=arr[i]-height[i]+ans;
        }
        return ans;
        }

}
