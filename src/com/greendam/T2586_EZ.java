package com.greendam;

public class T2586_EZ {
    public static void main(String[] args) {
    String[] words = {"hey","aeo","mu","ooo","artro"};
        System.out.println(vowelStrings(words,1,4));

    }
    public static int vowelStrings(String[] words, int left, int right) {
        int ans=0;
        for (int i = left; i <=right ; i++) {
            String word=words[i];
            if(isVowel(word.charAt(0))&&isVowel(word.charAt(word.length()-1)))
                ans++;
        }
        return ans;
    }
    public static boolean isVowel(char c){
        return c=='a'||c=='e'||c=='i'||c=='o'||c=='u';
    }
}
