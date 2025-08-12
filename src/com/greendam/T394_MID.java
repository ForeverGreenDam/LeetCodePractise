package com.greendam;

import java.util.Map;
import java.util.Stack;

public class T394_MID {
    class Entry{
        int num;
        String s;
        Entry(int num, String s){
            this.num=num;
            this.s=s;
        }
    }
    public static void main(String[] args) {
        String s="3[a2[c]]";
        T394_MID solution = new T394_MID();
        System.out.println(solution.decodeString(s));
    }
    //模拟
    public String decodeString(String s) {
        StringBuilder ans = new StringBuilder();
        Stack<Entry> stack = new Stack<>();
        int multi=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)>='0'&&s.charAt(i)<='9'){
                multi=multi*10+(s.charAt(i)-'0');
            }else if(s.charAt(i)=='['){
                Entry entry = new Entry(multi,ans.toString());
                stack.push(entry);
                multi=0;
                ans=new StringBuilder();
            }else if(s.charAt(i)==']'){
                Entry entry = stack.pop();
                int num = entry.num;
                String temp= entry.s;
                StringBuilder sb=new StringBuilder(temp);
                String tempAns= ans.toString();
                for(int j=0;j<num-1;j++){
                    ans.append(tempAns);
                }
                ans=sb.append(ans);
            }else{
                ans.append(s.charAt(i));
            }
        }
        return ans.toString();
    }
}
