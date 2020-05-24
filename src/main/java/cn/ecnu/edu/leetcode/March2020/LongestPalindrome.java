package cn.ecnu.edu.leetcode.March2020;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 */
public class LongestPalindrome {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad"));
    }

    public  static String longestPalindrome(String s) {
        int maxx=0;
        Map<Integer,String> res=new HashMap<>();
        if (s==null||s.length()==1||s.equals("")){
            return s;
        }
        int l=0,r=0;
        res.put(1,s.substring(0,1));
        maxx=1;
        //奇
        for(int i=0;i<s.length();i++){
            l=i-1;r=i+1;
            int max=1;
            while(l>=0&&r<s.length()&&s.charAt(l)==s.charAt(r)){
                max+=2;
                l--;
                r++;

            }
            res.put(max,s.substring(l+1,r));
            if (max>maxx){
                maxx=max;
            }
        }
        //偶
        for(int i=0;i<s.length();i++){
            l=i-1;r=i;
            int max=0;
            while(l>=0&&r<s.length()&&s.charAt(l)==s.charAt(r)){
                max+=2;
                l--;
                r++;

            }
            res.put(max,s.substring(l+1,r));
            if (max>maxx){
                maxx=max;
            }
        }
        return res.get(maxx);

    }
}
