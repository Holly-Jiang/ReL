package cn.ecnu.edu.leetcode.March2020;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个字符串数组 words，找到 length(word[i]) * length(word[j]) 的最大值，
 * 并且这两个单词不含有公共字母。你可以认为每个单词只包含小写字母。如果不存在这样的两个单词，返回 0。
 *
 */
public class MaxProduct {
    public static void main(String[] args) {
        System.out.println(maxProduct(new String[] {"abcw","baz","foo","bar","xtfn","abcdef"}));
    }
    public static int maxProduct(String[] words) {
        int max=0;
        //将每个单词是否出现映射到单词数组中
        int arr[][]=new int [words.length][26];
        for(int i=0;i<words.length;i++){
            for(int j=0;j<words[i].length();j++){
                arr[i][words[i].charAt(j)-97]=1;
            }
        }
        for(int i=0;i<words.length;i++){
            for(int j=i+1;j<words.length;j++){
                int temp=words[i].length()*words[j].length();
                if(max<temp&&!isSame(arr[i],arr[j])){
                    max=temp;
                }
            }
        }
        return max;
    }
    //比较两个单词是否有相同的字母 有--true 无--false
    public static boolean isSame(int[] s1,int[] s2) {
        for(int i=0;i<s1.length;i++){
            if(s1[i]==1&&s2[i]==1){
                return true;
            }
        }
        return false;
    }
}
