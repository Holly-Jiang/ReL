package cn.ecnu.edu.leetcode.March2020;

public class LengthOfLIS {

    public static void main(String[] args) {
        int[] a1=new int[] {10,9,2,5,3,7,101,18};
        int[] a2=new int[] {10,9,2,5,3,4};
        System.out.println(lengthOfLIS(a1));
    }
    public static int lengthOfLIS(int[] nums) {
        if(nums==null||nums.length==0){
            return 0;
        }
        int res=1;
        int []dp=new int[nums.length] ;
        int temp=0;
        for(int i=1;i<nums.length;i++){
            temp=0;
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j]){
                    temp=Math.max(temp,dp[j]);
                }
            }
            dp[i]=temp+1;
            res=Math.max(res,dp[i]);
        }
        return res;
    }
}
