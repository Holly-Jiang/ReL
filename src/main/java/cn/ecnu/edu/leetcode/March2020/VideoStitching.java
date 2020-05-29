package cn.ecnu.edu.leetcode.March2020;

import java.util.HashMap;
import java.util.Map;

/**
 * 1024. 视频拼接
 *
 *你将会获得一系列视频片段，这些片段来自于一项持续时长为 T 秒的体育赛事。这些片段可能有所重叠，也可能长度不一。
 *
 * 视频片段 clips[i] 都用区间进行表示：开始于 clips[i][0] 并于 clips[i][1] 结束。我们甚至可以对这些片段自由地再剪辑，例如片段 [0, 7] 可以剪切成 [0, 1] + [1, 3] + [3, 7] 三部分。
 *
 * 我们需要将这些片段进行再剪辑，并将剪辑后的内容拼接成覆盖整个运动过程的片段（[0, T]）。返回所需片段的最小数目，如果无法完成该任务，则返回 -1 。
 *
 * 贪心算法--找到最右边的区间
 *
 *
 */
public class VideoStitching {
    public static void main(String[] args) {

        int[][] clips=new int[][]
                {{0,2},{4,6},{8,10},{1,9},{1,5},{5,9}};

        int[][] clips1=new int[][]
                {{0,2},{4,8}};
        int[][] clips2=new int[][]
                {{16,18},{16,20},{3,13},{1,18},{0,8},{5,6},{13,17},{3,17},{5,6}};

        int[][] clips3=new int[][]
        {{24,28},{10,56},{50,78},{38,77},{38,78},{3,69},{33,49},{66,89},{73,83},{6,12},{24,86},{67,82},{18,26},{1,57},{13,30},{8,56},{58,78},{2,84},{35,39},{45,51},{30,32},{19,31},{32,70},{1,15},{16,18},{32,87},

                {32,87},{39,42},{81,84},{25,61},{26,34},{10,82},{17,34},{56,72},{17,22},{8,83},{5,21},{3,79},
            {12,73},{0,28},{74,76},{41,79},{4,60},{51,90},{10,41},{47,90},{44,56},{13,16},{43,83},{0,22},{30,40},{8,27},{57,58},{0,26},{16,66},{62,89},{2,74},{17,61},{25,28},{23,54},{42,79},{14,28},{26,77},{34,36},{17,42},{72,81},{12,87},{3,57},{81,88},{65,87},{35,74},{19,77},{10,53},{38,75},{14,90},{10,90},{57,62},{37,74},{24,80},{52,63},{52,55},{64,73},{45,79},{12,19},{26,38},{40,81},{28,48},{33,62},{18,50},{9,40}};

        System.out.println(videoStitching(clips3,75));
    }
    public static int videoStitching(int[][] clips, int T) {
        Integer num=0;
        int count=0;
        Integer maxNum=0;
        Integer maxVal=0;
        Map<Integer,Integer> map=new HashMap<>();
        int max=0;
        for (int i=0;i<clips.length;i++){
            if (max<clips[i][1]){
                max=clips[i][1];
            }
            if (map.get(clips[i][0])==null||map.get(clips[i][0])<clips[i][1]){
                map.put(clips[i][0],clips[i][1]);
            }

        }
        if (max<T){
            return -1;
        }
        while(num<T){

          Integer value;
          Integer max1=maxVal;
          while (num>=0&&num<T){
              value= map.get(num);
              if (value==null){
                  num=num-1;
continue;
              }
              maxVal=maxVal<value?value:maxVal;
              maxNum=num;
              num=num-1;
          }
          if (maxVal==max1){
              return -1;
          }
          map.remove(maxNum);
              num=maxVal;
              count++;
        }
        return count;


    }
}
