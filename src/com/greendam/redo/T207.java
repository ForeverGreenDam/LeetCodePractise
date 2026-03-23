package com.greendam.redo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class T207 {
    public static void main(String[] args) {
        T207 t207 = new T207();
        int[][] prerequisites2 = {{1, 0}};
        System.out.println(t207.canFinish(2, prerequisites2));
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //图的出度入度相关问题
        //使用数组来记录每个节点的入度
        //使用hashmap来记录每个节点的出度关联节点
        int [] inDegree = new int[numCourses];
        Map<Integer, List<Integer>> outDegree = new HashMap<>();
        for (int [] pre : prerequisites) {
            inDegree[pre[0]]++;
            List<Integer> temp = outDegree.getOrDefault(pre[1], new ArrayList<>());
            temp.add(pre[0]);
            outDegree.put(pre[1], temp);
        }
        //使用队列来记录入度为0的节点
        List<Integer> queue = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            if(inDegree[i] == 0){
                queue.add(i);
                //标记当前节点已删除
                inDegree[i] = -1;
            }
        }
        //当队列不为空时，取出一个节点，将其相连节点的入度减1，如果相连节点的入度为0，则将其加入队列
        while(!queue.isEmpty()){
            //要移除的节点
            Integer remove = queue.remove(queue.size() - 1);
            //和即将移除的节点关联的节点
            List<Integer> temp = outDegree.remove(remove);
            if(temp!=null){
                for (Integer i : temp) {
                    //这些节点的入度全减一
                    inDegree[i]--;
                    //检查当前入度是否为0，是则加入到queue中
                    if(inDegree[i] == 0){
                        queue.add(i);
                        //标记当前节点已删除
                        inDegree[i] = -1;
                    }
                }
            }
        }
        //当队列为空，则代表没有任何入度为0的节点了，如果还有节点没有被删除，则说明有环，返回false，否则返回true
        for (int i : inDegree) {
            if(i > 0){
                return false;
            }
        }
        return true;
    }
}
