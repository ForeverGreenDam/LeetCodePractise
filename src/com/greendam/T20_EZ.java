package com.greendam;

import java.util.Stack;

public class T20_EZ {
    public static void main(String[] args) {
        String s = "([)]";
        T20_EZ solution = new T20_EZ();
        System.out.println(solution.isValid(s));
    }
    public boolean isValid(String s) {
        if(s.isEmpty()){
            return true;
        }
        if(s.length()%2!=0){
            return false;
        }
        Stack<Character> stack = new Stack<>();
        stack.push(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            if(stack.isEmpty()){
                stack.push(s.charAt(i));
                continue;
            }
            Character peek = stack.peek();
            Character now = s.charAt(i);
            if((peek=='(' && now==')')||
                    (peek=='{' && now=='}')||
                    (peek=='[' && now==']')){
                stack.pop();
            }else{
                stack.push(now);
            }
        }
        if(stack.isEmpty()){
            return true;
        }
        return false;
    }
}
