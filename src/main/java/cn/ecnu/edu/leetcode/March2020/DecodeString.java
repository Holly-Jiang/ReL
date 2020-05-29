package cn.ecnu.edu.leetcode.March2020;

import java.util.Stack;

public class DecodeString {
    public static void main(String[] args) {
        System.out.println(decodeString("100[leetcode]"));
    }
    public static String decodeString(String s) {
        StringBuilder sb=new StringBuilder(s);
        Integer [][] stack=new Integer[s.length()][3];
        int num=0,j=0;
        for (int i=0;i<sb.length()||j!=0;i++){
            if (sb.charAt(i)>=48&&sb.charAt(i)<=57){
                stack[j][1]=i;
                while (i<sb.length()&&sb.charAt(i)>=48&&sb.charAt(i)<=57){
                    num=num*10+sb.charAt(i)-48;
                    i++;
                }
                stack[j][2]=i+1;
                stack[j++][0]=num;
                num=0;
            }

            if (sb.charAt(i)==']'){
                int temp=stack[j-1][0];
                String sub=sb.substring(stack[j-1][2],i);
                StringBuffer sb1=new StringBuffer();
                while(temp>0){
                    sb1.append(sub);
                    temp--;
                }
                sb.replace(stack[j-1][1],i+1,sb1.toString());
                i=stack[j-1][1];
                j--;
            }
        }
        return sb.toString();
    }
}
