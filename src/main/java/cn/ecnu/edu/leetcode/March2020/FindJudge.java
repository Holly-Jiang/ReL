package cn.ecnu.edu.leetcode.March2020;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class FindJudge {
    public static void main(String[] args) {
        System.out.println(findJudge(4,new int[][]{{1,2},{1,3},{2,1},{2,3},{1,4},{4,3},{4,1}}));
    }
    public static int findJudge(int N, int[][] trust) {
        if(trust.length==1){
            return trust[0][1];
        }else if(N==1&&trust.length==0){
            return N;
        }
        Arrays.sort(trust, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1]>o2[1]){
                    return 1;
                }else if(o1[1]<o2[1]){
                    return -1;
                }
                return 0;
            }
        });
        int count=1;
        List<Integer> judge=new ArrayList<>();
        for(int i=1;i<trust.length;i++){
            if(trust[i][1]==trust[i-1][1]){
                count++;
                if(count==N-1){
                    judge.add(trust[i][1]) ;
                }
            }else{
                count=1;
            }
        }
        for(int i=0;i<trust.length;i++){
            if(judge.contains(trust[i][0])){
                judge.remove((Integer)trust[i][0]);
            }
        }
        if (!judge.isEmpty()&&judge.size()==1){
            return judge.get(0);
        }
        return -1;
    }
}
