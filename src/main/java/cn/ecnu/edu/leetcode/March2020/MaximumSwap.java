package cn.ecnu.edu.leetcode.March2020;

import javax.security.auth.login.AccountException;
import java.util.Arrays;
import java.util.Comparator;

public class MaximumSwap {
    public static void main(String[] args) {
        System.out.println(maximumSwap(1993));
    }

    public static int maximumSwap(int num) {
        StringBuilder s=new StringBuilder(num+"");
        Integer [][] nums=new Integer [s.length()][2];
        for(int i=0;i<s.length();i++){
            nums[i][0]=s.charAt(i)-48;
            nums[i][1]=i;
        }
        Arrays.sort(nums, new Comparator<Integer[]>() {
            @Override
            public int compare(Integer[] o1, Integer[] o2) {
                return o2[0]-o1[0];
            }
        });
       for (int i=0;i<s.length();i++){
           char temp=s.charAt(i);
           if (temp==nums[i][0]+48){
               continue;
           }else{
               int j=i;
               while(j<s.length()&&nums[j][0]==nums[j+1][0]){
                   j++;
               }
            s.replace(i,i+1,nums[j][0]+"");
            s.replace(nums[j][1],nums[j][1]+1,temp+"");
            break;
           }
       }
           return Integer.parseInt(s.toString());



    }
}
