package com.greendam;

import java.util.Arrays;
import java.util.Stack;

public class T739_MID {
    public static void main(String[] args) {
    int[] temperatures = {73,74,75,71,69,72,76,73};
    T739_MID solution = new T739_MID();
        System.out.println(Arrays.toString(solution.dailyTemperatures(temperatures)));
    }
    public int[] dailyTemperatures(int[] temperatures) {
        int[] ans = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < temperatures.length; i++) {
            if (stack.isEmpty()) {
                stack.push(i);
            } else {
                Integer top = stack.peek();
                if (temperatures[i] > temperatures[top]) {
                    while (temperatures[i] > temperatures[top]) {
                        ans[top] = i - top;
                        stack.pop();
                        if (stack.isEmpty()) {
                            break;
                        }
                        top = stack.peek();
                    }
                }
                stack.push(i);
            }
        }
        return ans;
    }
}
