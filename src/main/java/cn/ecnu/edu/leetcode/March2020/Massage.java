package cn.ecnu.edu.leetcode.March2020;
/*
一个有名的按摩师会收到源源不断的预约请求，每个预约都可以选择接或不接。
在每次预约服务之间要有休息时间，因此她不能接受相邻的预约。给定一个预约请求序列，
替按摩师找到最优的预约集合（总预约时间最长），返回总的分钟数。
//dp[i]=dp[i-2]+num[i]
//dp[i]=dp[i-1]
 */
public class Massage {
    public static void main(String[] args) {
        System.out.println(massage(new int[] {2,1,1,2}));
    }

    public static int massage(int[] nums) {
        int len=nums.length;
        int [] dp=new int[nums.length];
        if(nums.length<=0)return 0;

        if(nums.length==1)return nums[0];
        else if(nums.length==2)return Math.max(nums[0],nums[1]);
        dp[0]=nums[0];
        dp[1]=Math.max(nums[0],nums[1]);
        for(int i=2;i<nums.length;i++){
            dp[i]=Math.max(dp[i-1],dp[i-2]+nums[i]);
        }
        return Math.max(dp[len-1],dp[len-2]);
    }

}
