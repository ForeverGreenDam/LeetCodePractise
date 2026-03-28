package com.greendam.redo;

import java.util.Stack;

public class T20 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char[] charArray = s.toCharArray();
        for (char c : charArray) {
            if(c=='('||c=='['||c=='{'){
                stack.push(c);
            }else if(c==')'&&!stack.isEmpty()){
                Character peek = stack.pop();
                if(peek!='('){
                    return false;
                }
            }else if(c==']'&&!stack.isEmpty()){
                Character peek = stack.pop();
                if(peek!='['){
                    return false;
                }
            }else if(c=='}'&&!stack.isEmpty()){
                Character peek = stack.pop();
                if(peek!='{'){
                    return false;
                }
            }else if(stack.isEmpty()&&(c==')'||c==']'||c=='}')){
                return false;
            }
        }
        return stack.isEmpty();
    }
}
