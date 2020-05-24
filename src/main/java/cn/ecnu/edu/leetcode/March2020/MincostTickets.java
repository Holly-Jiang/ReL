package cn.ecnu.edu.leetcode.March2020;

public class MincostTickets {
    public static void main(String[] args) {
        int [] a1=new int[]{1,4,6,7,8,20};
        int []a2=new int[]{2,7,15};
        System.out.println(mincostTickets(a1,a2));
    }
    public static int mincostTickets(int[] days, int[] costs) {
        int len =days.length;
        if (len<=0){
            return 0;
        }
        int []dp=new int[len+1];//到当天为止花费的钱
        get(days,costs,dp,len-1,0,days[len-1]);
        get(days,costs,dp,len-1,1,days[len-1]);
        get(days,costs,dp,len-1,2,days[len-1]);

        return dp[0];
    }
    //返回当前计算到的天
    private static void get(int[] days, int[] costs, int[] dp, int i, int i1,int i2) {
        int res=i2;
        if(i<0){
            return ;
        }
        if(days[i]>i2&&i!=days.length-1){
            dp[i]=dp[i+1]<dp[i]?dp[i+1]:dp[i];
        }else{
            int temp=dp[i+1]+costs[i1];
            if(temp<dp[i]||dp[i]==0){
                dp[i]=temp;
            }
        }

        res=days[i];
        if (i1==0){
            res-=1;
        }else if (i1==1){
            res-=7;
        }else if(i1==2){
            res-=30;
        }

        get(days,costs,dp,i-1,0,res);
        get(days,costs,dp,i-1,1,res);
        get(days,costs,dp,i-1,2,res);

    }
}
