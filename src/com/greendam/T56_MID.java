package com.greendam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class T56_MID {
    public static void main(String[] args) {
    int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
        System.out.println(Arrays.deepToString(merge(intervals)));
    }
    public static int[][] merge(int[][] intervals) {
        //先按照左端点进行排序
       Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
       int[][]  ans= new int[intervals.length][2];
       List<int[]> ansList = new ArrayList<>();
       //将第一个区间赋值给结果数组的第一个位置
       ansList.add(intervals[0]);
       int ansIndex=0;
       //遍历后面的区间，查看和ans区间最后一个区间是否有重叠
        for(int i=1;i<intervals.length;i++){
            int start= intervals[i][0];
            int end= intervals[i][1];
            //判断该区间的左端点是否在ans的最后一个区间的右端点内
            if(start>ansList.get(ansIndex)[1]){
                //如果不在，则将该区间添加到结果数组中，ansIndex+1
                ansList.add(intervals[i]);
                ansIndex++;
            }else{
                //如果有重叠，则判断该区间的右端点是否大于ans最后一个区间的右端点
                if(end>ansList.get(ansIndex)[1]){
                    //如果大于，则更新ans最后一个区间的右端点
                    ansList.set(ansIndex, new int[]{ansList.get(ansIndex)[0], end});
                    //如果不大于，则不需要做任何操作，因为该区间已经被包含在ans的最后一个区间内，相当于包含关系
                }
            }
        }
        return ansList.toArray(new int[ansList.size()][]);
    }
}
