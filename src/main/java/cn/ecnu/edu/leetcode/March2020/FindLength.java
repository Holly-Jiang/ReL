package cn.ecnu.edu.leetcode.March2020;
/*
给两个整数数组 A 和 B ，返回两个数组中公共的、长度最长的子数组的长度。
 */
public class FindLength {
    public static void main(String[] args) {
        System.out.println(findLength(new int[] {1,0,0,0,1},new int[]{1,0,0,1,1}));
    }
    public static  int findLength(int[] A, int[] B) {
        if(A.length==0||B.length==0){
            return 0;
        }
        int max=0;
        int [][] dp=new int [A.length+2][B.length+2];
        dp[0][0]=0;
        for(int i=0;i<A.length;i++){
            for(int j=0;j<B.length;j++){
                if(A[i]==B[j]){
                    dp[i+1][j+1]=dp[i][j]+1;
                    if(max<dp[i+1][j+1])max=dp[i+1][j+1];
                }
            }
        }
        return max;
    }
}
