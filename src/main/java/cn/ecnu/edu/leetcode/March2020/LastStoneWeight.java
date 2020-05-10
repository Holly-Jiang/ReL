package cn.ecnu.edu.leetcode.March2020;

import java.util.Comparator;
import java.util.PriorityQueue;

public class LastStoneWeight {


    public int lastStoneWeight(int[] stones) {
        int len=stones.length;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(len, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                // TODO Auto-generated method stub
                return o2.compareTo(o1);
            }
        });
        for(int i=0;i<stones.length;i++){
                maxHeap.add(stones[i]);
            }
        while(maxHeap.size()>1){
            int y=maxHeap.poll();
            int x=maxHeap.poll();
            if (x!=y){
               maxHeap.add(y-x);
            }
        }
        if (maxHeap.size()>0){
            return maxHeap.peek();
        }
        return 0 ;
    }
}
