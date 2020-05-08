package cn.ecnu.edu.leetcode.March2020;

import java.util.*;

public class ToLowerCase {
    public static void main(String[] args) {


        System.out.println(toLowerCase("Hello"));
    }
    public static String toLowerCase(String str) {
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<str.length();i++){
            Character c = str.charAt(i);
            if(c>=65&&c<=90){
                sb.append((char)(str.charAt(i)+32));
            }else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

}

