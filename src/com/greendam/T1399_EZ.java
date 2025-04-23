package com.greendam;

public class T1399_EZ {
    public static void main(String[] args) {
        System.out.println(countLargestGroup(13)); // 4
    }
    public static int countLargestGroup(int n) {
        //创建一个结果集数组，记录相同数位和数的个数
        //如果n>=10,则创建的数组长度为18，如果n>=100，则创建的数组长度为27,以此类推
        int[] ans = new int[0];
        if (n<=10) { ans=new int[9]; }
        else if(n<=100) {ans=new int[18];}
        else if(n<=1000) {ans=new int[27];}
        else if(n<=10000) { ans=new int[36];}
        for(int i=1;i<=n;i++) {
            //获取数位和
            int sum=0;
            int num=i;
            while(num>0){
                sum+=num%10;
                num=num/10;
            }
            ans[sum-1]++;
        }
        //获取最大值
        int max=0;
        int result=1;
        for(int i=0;i<ans.length;i++){
            if(ans[i]==max){
                result++;
            }else if(ans[i]>max){
                max=ans[i];
                result=1;
            }
        }
        return result;
    }
}
