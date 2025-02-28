package com.greendam;

public class T709_EZ {
    public static void main(String[] args) {
        Solution709 s= new Solution709();
        String str="Hello";
        System.out.println(s.toLowerCase(str));
    }
}
class Solution709 {
    public String toLowerCase(String s) {
        char[] chars=s.toCharArray();
        for (int i=0;i<chars.length;i++){
            if (chars[i]>='A' && chars[i]<='Z'){
                chars[i]+=32;
            }
        }
        return new String(chars);
    }
}