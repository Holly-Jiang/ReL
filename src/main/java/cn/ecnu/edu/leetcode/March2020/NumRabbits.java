package cn.ecnu.edu.leetcode.March2020;

import java.util.Arrays;

public class NumRabbits {

    public static void main(String[] args) {
        int []ans=new int[]{1,2,4,2,2};
        System.out.println(numRabbits(ans));
    }
    public static  int numRabbits(int[] answers) {

        int res=0;
        Arrays.sort(answers);
        for (int i=0;i<answers.length;i++){
            int j=answers[i];
            res++;

            while(j>0){
                if (i+1<answers.length&&answers[i]==answers[1+i]){
                    res++;
                    j--;
                    i++;
                }else{
                    res+=j;
                    break;
                }
            }

        }
        return res;
    }
}
