package cn.ecnu.edu.leetcode.March2020;

public class CountPrimes {
    public static void main(String[] args) {
        System.out.println(countPrimes(10));
    }
    public static int countPrimes(int n) {
        int [] visited=new int [n];
        for(int i=2;i<n;i++){
            if(visited[i]==0){
                for(int j=2;i*j<n;j++){
                    visited[i*j]=1;
                }
            }

        }
        int count =0;
        for(int i=2;i<n;i++){
            if(visited[i]==0){
                count++;
            }
        }

        return count;

    }
}
