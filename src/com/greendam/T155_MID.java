package com.greendam;

import java.util.ArrayList;
import java.util.List;

public class T155_MID {
    class MinStack {
        Integer min;
        List<Integer> minChain;
        List<Integer> list;
        public MinStack() {
            minChain=new ArrayList<>();
            list=new ArrayList<>();
        }
        public void push(int val) {
            if(min==null || min>=val){
                min=val;
                minChain.add(val);
            }
            list.add(val);
        }
        public void pop() {
            if(list.get(list.size() - 1).equals(min)){
                minChain.remove(minChain.size()-1);
                if(minChain.isEmpty()){
                    min=null;
                } else {
                    min=minChain.get(minChain.size()-1);
                }
            }
            list.remove(list.size()-1);
        }
        public int top() {
            return list.get(list.size()-1);
        }
        public int getMin() {
            return min;
        }
    }
}
