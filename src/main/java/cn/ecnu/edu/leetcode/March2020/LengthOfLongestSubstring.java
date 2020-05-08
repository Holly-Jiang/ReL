package cn.ecnu.edu.leetcode.March2020;

import java.util.ArrayList;
import java.util.List;
//给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。

public class LengthOfLongestSubstring {
    public static void main(String[] args) {
        String s="pwwkew";
        System.out.println(lengthOfLongestSubstring(s));
    }
    public static int lengthOfLongestSubstring(String s) {
        int max=0,count=0;
        if(s==null||s.length()<=0){
            return 0;
        }
        int left=0,right=0;
        List<Character> list=new ArrayList<>();

        for (;left<=right&&right<s.length();){
            Character temp=s.charAt(right);
            if(!list.contains(temp)){
                list.add(temp);
                count++;
            }else{
                int index=list.indexOf(temp);
                left=index+1;
                list.add(temp);
                list= list.subList(left,list.size());
                count=list.size();
            }

            right++;
            if(max<count){
                max=count;
            }
        }
        return max;
    }
}
