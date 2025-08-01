package com.greendam;

import java.util.HashMap;
import java.util.Iterator;

public class T207_MID {
    public static void main(String[] args) {
        T207_MID t207_mid = new T207_MID();
        int[][] prerequisites2 = {{1, 0}};
        System.out.println(t207_mid.canFinish(2, prerequisites2));
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //map记录每个节点的入度
        HashMap<Integer, Integer> map = new HashMap<>(numCourses);
        for (int i = 0; i < numCourses; i++) {
            map.put(i,0);
        }
        for (int[] prerequisite : prerequisites) {
            map.put(prerequisite[0], map.get(prerequisite[0]) + 1);
        }
        //找入度为0的点，将其移除，在图中寻找其相连节点，将其相连节点的入度减1
       while(map.containsValue(0)){
           Iterator<Integer> iterator = map.keySet().iterator();
           while(iterator.hasNext()){
               Integer key = iterator.next();
               if(map.get(key)==0){
                   //使用迭代器的remove方法，保证在遍历中修改集合时迭代器中集合的状态和实际集合状态一致，防止抛出并发修改异常
                   iterator.remove();
                   map.remove(key);
                   for (int[] prerequisite : prerequisites) {
                       if(prerequisite[1]==key){
                           map.put(prerequisite[0],map.get(prerequisite[0]) - 1);
                       }
                   }
               }
           }
       }
        //如果map中还有元素，说明有环，返回false，否则返回true
        return map.isEmpty();
    }
}
