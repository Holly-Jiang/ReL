package cn.ecnu.edu.leetcode.March2020;


public class Rob {
    public static void main(String[] args) {
        System.out.println(rob(new int[]{2,7,9,3,1}));
    }
    public static int rob(int[] nums) {
        int len=nums.length;
        int res[]=new int[len];
        if (nums.length<=0){
            return 0;
        }
        if(nums.length==1){
            return nums[0];
        }
        res[0]=0;//不取第一个元素
        res[1]=nums[1];
        for(int i=2;i<len;i++){
            if (res[(i+len-2)%len]>res[(i+len-3)%len]){
                res[i]+=res[(i+len-2)%len];
            }else if (res[(i+len-2)%len]<=res[(i+len-3)%len]){
                res[i]+=res[(i+len-3)%len];
            }
            res[i]+=nums[i];
        }
        res[1]=0;//不取第二个元素
        res[0]=nums[0];
        for(int i=2;i<len;i++){
            if (res[(i+len-2)%len]>res[(i+len-3)%len]){
                res[i]+=res[(i+len-2)%len];
            }else if (res[(i+len-2)%len]<=res[(i+len-3)%len]){
                res[i]+=res[(i+len-3)%len];
            }
            res[i]+=nums[i];
        }
        return res[len-1]>res[len-2]?res[len-1]:res[len-2]+nums[0];
    }
}
