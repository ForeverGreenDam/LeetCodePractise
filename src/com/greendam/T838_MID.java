package com.greendam;

public class T838_MID {
    public static void main(String[] args) {
        String dominoes=".L.R...LR..L..";
        System.out.println(pushDominoes(dominoes));
    }
    public  static String pushDominoes(String dominoes) {
        //四种情况：L...L中间全变成L，R...R中间全变成R，R...L中间一半变成R一半变成L，L...R中间不变
         char[] s=new char[dominoes.length()+2];
            s[0]='L';
            s[s.length-1]='R';
            for(int i=0;i<dominoes.length();i++){
                s[i+1]=dominoes.charAt(i);
            }
            int pre=0;
            for(int i=1;i<s.length;i++){
                if(s[pre]=='L'&& s[i]=='L')
                {
                    for(int temp=pre+1;temp<i;temp++){
                        s[temp]='L';
                    }
                    pre=i;
                } else if (s[pre]=='R'&&s[i]=='R')
                {
                    for(int temp=pre+1;temp<i;temp++){
                        s[temp]='R';
                    }
                    pre=i;
                } else if (s[pre] == 'R' && s[i] == 'L') {
                    if((i+pre)%2==0){
                        for(int temp=0;temp<(i-pre)/2;temp++){
                            s[pre+temp]='R';
                            s[i-temp]='L';
                        }
                    }else {
                        for(int temp=0;temp<(i-pre+1)/2;temp++){
                            s[pre+temp]='R';
                            s[i-temp]='L';
                        }
                    }
                    pre=i;
                }else if(s[pre] == 'L' && s[i] == 'R'){
                    pre=i;
                }
            }
            StringBuilder sb=new StringBuilder();
            for(int i=1;i<s.length-1;i++){
                sb.append(s[i]);
            }
            return sb.toString();
    }
}
