package cn.ecnu.edu.leetcode.April2020;

import java.util.LinkedList;

/**
 *面试题13. 机器人的运动范围
 *
 *地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，
 * 它每次可以向左、右、上、下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。
 * 例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。
 * 但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof
 *
 * 广度优先遍历
 */

public class MovingCount {
    public static void main( String[] args )
    {
        MovingCount mc = new MovingCount();
        System.out.println( mc.movingCount(38,15,9) );
    }

    public int movingCount(int m, int n, int k) {
        if (k<0){
            return 0;
        }
        int [][] ini=new int[m][n];
        int sum=0;
        LinkedList<Integer> queX=new LinkedList<Integer>();
        LinkedList<Integer> queY=new LinkedList<Integer>();
        queX.offerLast(0);
        queY.offerLast(0);
        ini[0][0]=1;
        while(!queX.isEmpty()){
            int x1,y1;
            x1=queX.pollFirst();
            y1=queY.pollFirst();
            if (sum==167){
                System.out.println("---------");
            }
            if((x1-1)>=0&&ini[x1-1][y1]==0){
                if (sum(x1-1,y1)<=k){
                    ini[x1-1][y1]=1;
                    queX.offerLast(x1-1);
                    queY.offerLast(y1);
                    sum++;
                }
            }
            if((y1-1)>=0&&ini[x1][y1-1]==0){
                if (sum(x1,y1-1)<=k) {
                    ini[x1][y1-1]=1;
                    queX.offerLast(x1);
                    queY.offerLast(y1 - 1);
                    sum++;
                }
            }
            if((x1 + 1)<m&&ini[x1+1][y1]==0) {
                if (sum(x1+1,y1) <= k) {
                    ini[x1+1][y1]=1;
                    queX.offerLast(x1+1);
                    queY.offerLast(y1);
                    sum++;
                }

            }
            if((y1+1)<n&&ini[x1][y1+1]==0){
                if (sum(x1,y1+1)<=k){
                    ini[x1][y1+1]=1;
                    queX.offerLast(x1);
                    queY.offerLast(y1+1);
                    sum++;
                }

            }
        }
        return sum;
    }
    //计算数位之和
    public int sum(int x,int y){
        int count =0;
        while(x>0){
            count+=x%10;
            x=x/10;
        }
        while(y>0){
            count+=(y)%10;
            y=(y)/10;
        }
        return count;
    }
}
