package cn.ecnu.edu.leetcode.March2020;

/**
 *
 *
 * 神奇的字符串 S 只包含 '1' 和 '2'，并遵守以下规则：
 *
 * 字符串 S 是神奇的，因为串联字符 '1' 和 '2' 的连续出现次数会生成字符串 S 本身。
 *
 * 字符串 S 的前几个元素如下：S = “1221121221221121122 ......”
 *
 * 如果我们将 S 中连续的 1 和 2 进行分组，它将变成：
 *
 * 1 22 11 2 1 22 1 22 11 2 11 22 ......
 *
 * 并且每个组中 '1' 或 '2' 的出现次数分别是：
 *
 * 1 2 2 1 1 2 1 2 2 1 2 2 ......
 *
 * 你可以看到上面的出现次数就是 S 本身。
 *
 * 给定一个整数 N 作为输入，返回神奇字符串 S 中前 N 个数字中的 '1' 的数目。
 *
 * 注意：N 不会超过 100,000。
 *
 */
public class MagicalString {
    public static void main(String[] args) {
        System.out.println(magicalString(4));
    }

    public static int magicalString(int n) {
        if (n<=0){
            return 0;
        }
        int[] num1=new int[n+3];
        int []num2=new int[n+3];
        num1[0]=1;
        num1[1]=2;
        num1[2]=2;
        num2[0]=1;
        num2[1]=2;
        for (int i=3,j=2;i<n;i++){
            num2[j]=num1[j];
            int mult=2;
            if (num1[i-1]==2){
                mult=1;
            }
            if(num2[j]==2){
                num1[i]=mult;
                i++;
            }
            num1[i]=mult;
            j++;
        }
        int res=0;
        for (int i=0;i<n;i++){
            if (num1[i]==1){
                res++;
            }
        }
        return res;

    }
}
