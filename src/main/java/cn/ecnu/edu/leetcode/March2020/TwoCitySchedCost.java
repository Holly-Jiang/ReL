package cn.ecnu.edu.leetcode.March2020;

import java.util.ArrayList;
import java.util.List;

public class TwoCitySchedCost {

    public static void main(String[] args) {
        int [][] arr2=new int[][] {{518,518},{71,971},{121,862},{967,607},{138,754},{513,337},{499,873},{337,387},{647,917},{76,417}};
        int [][] arr1=new int[][]{{259,770},{448,54},{926,667},{184,139},{840,118},{577,469}};
        int [][] arr=new int[][]{{10,20},{30,200},{400,50},{30,20}};
        System.out.println(twoCitySchedCost(arr1));
    }
    public static int twoCitySchedCost(int[][] costs) {
        int min=0;
        int max=100000;


        List<Integer> res=new ArrayList<>();
        findCosts(min,res,0,costs[0][0],costs,1,0);
        findCosts(min,res,0,costs[0][1],costs,0,1);
      for(int i=0;i<res.size();i++){
          if (max>res.get(i)){
              max=res.get(i);
          }
      }
   return max;
    }

    private static   void findCosts(int min,List<Integer> res, int i, int i1, int[][] costs,int num0, int num1) {
        int N=costs.length/2;
        if (num0>N&&i<costs.length-1){
            findCosts(min+costs[i][1],res,i+1,costs[i+1][1],costs,num0,num1+1);
            if (min==1814){
        System.out.println(i+" "+i1+" "+ num0+" "+num1);
    }
            return;
        }else  if(num1>N&&i<costs.length-1){
            findCosts(min+costs[i][0],res,i+1,costs[i+1][0],costs,num0+1,num1);
            if (min==1814){
                System.out.println(i+" "+i1+" "+ num0+" "+num1);
            }
            return;
        }
        if (i<costs.length-1){
            findCosts(min+costs[i][0],res,i+1,costs[i+1][0],costs,num0+1,num1);
            findCosts(min+costs[i][1],res,i+1,costs[i+1][1],costs,num0,num1+1);
        }

            res.add(min);
    }


}
