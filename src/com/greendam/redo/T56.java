package com.greendam.redo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class T56 {
    public int[][] merge(int[][] intervals){
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        int ansCount=0;
        List<int[]> ans=new ArrayList<>();
        ans.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int start=intervals[i][0];
            int end=intervals[i][1];
            if(start<=ans.get(ansCount)[1]){
                if(end>ans.get(ansCount)[1]){
                    ans.set(ansCount,new int[]{ans.get(ansCount)[0],end});
                }
            }else{
                ans.add(intervals[i]);
                ansCount++;
            }
        }
        return ans.toArray(new int[ansCount][]);
    }
}
