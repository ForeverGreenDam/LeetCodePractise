package com.greendam;

import java.util.ArrayList;
import java.util.List;

public class T118_EZ {
    public static void main(String[] args) {
    int numRows = 5;
    T118_EZ solution = new T118_EZ();
        System.out.println(solution.generate(numRows));
    }
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> firstRow = new ArrayList<>();
        firstRow.add(1);
        List<Integer> secondRow = new ArrayList<>();
        secondRow.add(1);
        secondRow.add(1);
        if(numRows == 1){
            ans.add(firstRow);
            return ans;
        } else if (numRows == 2) {
            ans.add(firstRow);
            ans.add(secondRow);
            return ans;
        }
        ans.add(firstRow);
        ans.add(secondRow);
        for(int i=3;i<=numRows;i++){
            List<Integer> preRow = ans.get(i-2);
            List<Integer> tempRow= new ArrayList<>();
            tempRow.add(1);
            for(int j=1;j<i-1;j++){
                int temp = preRow.get(j-1)+preRow.get(j);
                tempRow.add(temp);
            }
            tempRow.add(1);
            ans.add(tempRow);
        }
    return ans;
    }
}
