package com.greendam.redo;

import java.util.Stack;

public class T155 {
    class MinStack {
        private class Node{
            int val;
            int min;
            public Node(int val,int min){
                this.val=val;
                this.min=min;
            }
        }
        Stack<Node> stack;
        public MinStack() {
           this.stack = new Stack<Node>();
        }

        public void push(int val) {
            int min =val;
            if(!stack.isEmpty()){
                Node peek = stack.peek();
                 min = peek.min;
                if(val<min){
                    min=val;
                }
            }
            Node node = new Node(val,min);
            stack.push(node);
        }

        public void pop() {
            stack.pop();
        }

        public int top() {
            return   stack.peek().val;
        }

        public int getMin() {
            return stack.peek().min;
        }
    }
}
