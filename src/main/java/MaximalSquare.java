/**
 *在一个由 0 和 1 组成的二维矩阵内，找到只包含 1 的最大正方形，并返回其面积。
 *官方的题解是dp【i，j】作为正方形右下角的边长，
 * 我的是计算dp[i,j]作为正方形右下角的面积
 *
 */
public class MaximalSquare {
    public static void main(String[] args) {

        char[][] matrix1 =new char[][]
                {{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
        char[][] matrix =new char[][]
                 {{'0','0','0','1'},{'1','1','0','1'},{'1','1','1','1'},{'0','1','1','1'},{'0','1','1','1'}};
        System.out.println(maximalSquare(matrix));
    }
    public static int maximalSquare(char[][] matrix) {
        if(matrix==null||matrix.length<=0){
            return 0;
        }
        int row=matrix.length;
        int col=matrix[0].length;
        int dp[][]=new int[row][col];
        int max=0;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(matrix[i][j]=='1'){
                    if(i-1>=0&&j-1>=0){

                        int k=(int) Math.sqrt(dp[i-1][j-1]);
                        int lon=0;
                        for(int m=1;m<=k;m++){//计算左上角顶点的横纵坐标到i，j的这个边是不是全部都是1
                            if(matrix[i-m][j]!='1'||matrix[i][j-m]!='1'){
                               break;
                            }
                            lon++;//计算边长
                        }
                            dp[i][j]=(lon+1)*(lon+1);
                    }else{
                        dp[i][j]=1;
                    }
                }
                if(max<dp[i][j]){
                    max=dp[i][j];
                }
            }
        }
        return max;
    }
}
