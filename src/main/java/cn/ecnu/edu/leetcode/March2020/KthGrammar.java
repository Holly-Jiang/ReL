package cn.ecnu.edu.leetcode.March2020;

import java.util.ArrayList;
import java.util.List;

/**
 * 在第一行我们写上一个 0。接下来的每一行，将前一行中的0替换为01，1替换为10。
 *
 * 给定行数 N 和序数 K，返回第 N 行中第 K个字符。（K从1开始）
 *
 */
public class KthGrammar {
    public static void main(String[] args) {
        System.out.println(kthGrammar(4,5));
    }
    public static int kthGrammar(int N, int K) {
        return h(N,K,0);

    }
    public static int h(int N, int K,int flag) {
        if(N==1)return flag;//flag表示开始的第一位是0 还是1 也是翻转的次数
        int half=1<<(N-2);//左移N-2位表示当前这一行的一半有多少
        if(K<=half){
            //直接等于上一行的第K个位置
            return h(N-1,K,flag);
        }else{
            //K大雨这一行的一半就需要对应到上一行的对应位置取反
            return h(N-1,K-half,1-flag);
        }
    }
}
