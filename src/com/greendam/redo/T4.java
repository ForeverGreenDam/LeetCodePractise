package com.greendam.redo;

import java.util.ArrayList;
import java.util.List;

public class T4 {
    public static void main(String[] args) {
        int[] nums1={1,2};
        int[] nums2={3,4};
        T4 t4 = new T4();
        System.out.println(t4.findMedianSortedArrays(nums1, nums2));
    }
            public double findMedianSortedArrays(int[] nums1, int[] nums2) {
                if (nums1.length > nums2.length) {
                    // 交换 nums1 和 nums2，保证下面的 i 可以从 0 开始枚举
                    int[] tmp = nums1;
                    nums1 = nums2;
                    nums2 = tmp;
                }

                int m = nums1.length;
                int n = nums2.length;
                int[] a = new int[m + 2];
                int[] b = new int[n + 2];
                a[0] = b[0] = Integer.MIN_VALUE; // 最左边插入 -∞
                a[m + 1] = b[n + 1] = Integer.MAX_VALUE; // 最右边插入 ∞
                System.arraycopy(nums1, 0, a, 1, m); // 数组没法直接插入，只能 copy
                System.arraycopy(nums2, 0, b, 1, n);

                // 枚举 nums1 有 i 个数在第一组
                // 那么 nums2 有 j = (m + n + 1) / 2 - i 个数在第一组
                int i = 0;
                int j = (m + n + 1) / 2;
                while (true) {
                    if (a[i] <= b[j + 1] && a[i + 1] > b[j]) { // 写 >= 也可以
                        int max1 = Math.max(a[i], b[j]); // 第一组的最大值
                        int min2 = Math.min(a[i + 1], b[j + 1]); // 第二组的最小值
                        return (m + n) % 2 > 0 ? max1 : (max1 + min2) / 2.0;
                    }
                    i++; // 继续枚举
                    j--;
                }
            }
        }
