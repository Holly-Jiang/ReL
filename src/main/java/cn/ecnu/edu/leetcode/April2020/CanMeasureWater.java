package cn.ecnu.edu.leetcode.April2020;

/**
 *
 *
 *
 */
public class CanMeasureWater {

    public static void main(String[] args) {
        CanMeasureWater cmw=new CanMeasureWater();
        System.out.println(cmw.canMeasureWater(2,6,5));
        System.out.println(cmw.canMeasureWater(3,5,4));
    }
    public boolean canMeasureWater(int x, int y, int z) {
        if(z==x||z==y||z==(x+y)){
            return true;
        }
        else if (z>(x+y)||x==0||y==0){
            return false;
        }
        int x1,y1,z1=z;//x1 代表小的数
        if(x<y){
            x1=x;
            y1=y;
        }else{
            x1=y;
            y1=x;
        }
        int x2=x1,y2=y1;
        y1=0;
        boolean f=false;
        int count =0;
        int c=0;
        while(c<10&&(count<y||count>0)){
            f=false;
            y1=(y1+x1);
            if(y1>y2){
                x1=(y1%y2);
                count=x1;
                y1=y2;
                c++;
                f=true;
            }else{
                x1=x2;
            }
            if(z==Math.abs(x1)||z==Math.abs(y1)||z==(x1+Math.abs(y1))){
                return true;
            }
            if(f&&y1==y2){
                y1=x1;
                x1=x2;
            }

        }
        return false;
    }

}
