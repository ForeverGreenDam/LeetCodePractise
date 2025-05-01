package com.greendam;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class T2071_HD {
    public static void main(String[] args) {
        int [] tasks = {3, 2,1};
        int [] workers = {0,3,3};
        int pills = 1;
        int strength = 1;
        System.out.println(maxTaskAssign(tasks, workers, pills, strength));
    }
    public static int maxTaskAssign(int[] tasks, int[] workers, int pills, int strength) {
        //假设最多可以安排k个任务
        //调用check函数判断是否可以安排k个任务，如果可以，k++，如果不可以，记录当前k-1的值即为答案
        //先给数组排序
//        Arrays.sort(tasks);
//        Arrays.sort(workers);
//        int i=1;
//        for(;i<=Math.min(tasks.length,workers.length);i++){
//           if(!check(tasks,workers,pills,strength,i)){
//               break;
//           }
//        }
//        return i-1;
        //不用二分会超时
       int left=1;
       int ans=0;
       int right=Math.min(tasks.length,workers.length);
         while(left<=right){
              int mid=(left+right)/2;
              if(check(tasks,workers,pills,strength,mid)){
                left=mid+1;
                ans=mid;
              }else{
                right=mid-1;
              }
         }
        return ans;
    }
    public static  boolean check(int[] tasks, int[] workers, int pills, int strength,int k){
        //k表示当前安排的任务数
        //pills表示当前剩余的药丸数
        //strength表示当前工人的体力值
        //tasks表示任务数组
        //workers表示工人数组
        //选取最强的k个工人，最弱的k个任务，遍历每个工人，将其吃药之后能完成的任务暂存在一个双端队列中
        int n=workers.length;
        int pi=pills;
        Deque<Integer> deque=new ArrayDeque<>();
        int j=0;
        for(int i=0;i<k;i++){
            int worker=workers[n-k+i]+strength;
            //这里将j的值暂时保存，是为了保证整个tasks数组只遍历一次，防止重复做一个任务
           while(j<k&&tasks[j]<=worker){
                deque.addLast(tasks[j]);
                j++;
            }
            if(deque.isEmpty()){return false;}

            if(worker-strength>=deque.peekFirst()){
                deque.pollFirst();
                continue;
            }
            if(pi<=0){return false;}
            pi--;
            deque.pollLast();
        }
        return true;
    }
}
