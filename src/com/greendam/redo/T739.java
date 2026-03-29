package com.greendam.redo;

import java.util.Stack;

public class T739 {
    class Node{
        int temp;
        int index;
        public Node(int temp, int index) {
            this.temp = temp;
            this.index = index;
        }
    }

    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Node> stack = new Stack<>();
        int[] ans = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            if (stack.isEmpty()) {
                stack.push(new Node(temperatures[i], i));
            } else {
                if (stack.peek().temp >= temperatures[i]) {
                    stack.push(new Node(temperatures[i], i));
                } else {
                    while (!stack.isEmpty() && stack.peek().temp < temperatures[i]) {
                        Node pop = stack.pop();
                        ans[pop.index] = i - pop.index;
                    }
                    stack.push(new Node(temperatures[i], i));
                }
            }
        }
        return ans;
    }
}
