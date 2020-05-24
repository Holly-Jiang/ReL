package cn.ecnu.edu.leetcode.March2020;

import java.math.BigInteger;

public class Reverse {
    public static void main(String[] args) {
        System.out.println(reverse(1534236469));
    }
    public static int reverse(int x) {
        int first=1;
        double con=2e31-1;
        if(x<0){
            first=-1;
            x*=-1;
        }
        int res=0;
        while(x>0){
            if (con-(res*10+x%10)<x/10){
                res=0;
                break;
            }
            res=res*10+x%10;
            x=x/10;
        }

        return first*(res);
    }
}
