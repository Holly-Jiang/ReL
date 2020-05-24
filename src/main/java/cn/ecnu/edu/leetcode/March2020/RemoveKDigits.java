package cn.ecnu.edu.leetcode.March2020;

import java.math.BigInteger;

/**
 *给定一个以字符串表示的非负整数 num，移除这个数中的 k 位数字，使得剩下的数字最小。
 *
 */
public class RemoveKDigits
{

    public static void main(String[] args) {

        System.out.println(removeKdigits("112",1));
    }
    public static String removeKdigits(String num, int k) {
        StringBuilder sb=new StringBuilder(num);
        while(k>0){
            int index=0;
            boolean flag=false;
            for (int i=0;i<sb.length()-1;i++){
                if (sb.charAt(i)>sb.charAt(i+1)){
                    index=i;
                    flag=true;
                    break;
                }
            }
            if(!flag){
                index=sb.length()-1;
            }
            sb.deleteCharAt(index);
            k--;
        }
        while(sb.length()>0&&sb.charAt(0)=='0'){
            sb.deleteCharAt(0);
        }
        if (sb.length()==0){
            sb.append("0");
        }
        return sb.toString();
    }
}
