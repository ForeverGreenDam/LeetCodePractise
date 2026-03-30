package com.greendam.redo;

import java.util.PriorityQueue;

public class T295 {
    class MedianFinder {
        PriorityQueue<Integer> a;
        PriorityQueue<Integer> b;
        public MedianFinder() {
            a=new PriorityQueue<>();
            b=new PriorityQueue<>((n1,n2)->{
                return n2-n1;
            });
        }

        public void addNum(int num) {
                if(a.size()==b.size()){
                    b.offer(num);
                    a.offer(b.poll());
                }else{
                    a.offer(num);
                    b.offer(a.poll());
                }
        }

        public double findMedian() {
            if (a.size()==b.size()){
                return (a.peek()+b.peek())/2.0;
            }else{
              return   a.size()>b.size()?a.peek():b.peek();
            }
        }
    }

}
