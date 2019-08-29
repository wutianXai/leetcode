package leetcode.hard.mathproblem;
/*

直线上最多的点数
给定一个二维平面，平面上有 n 个点，求最多有多少个点在同一条直线上。

示例 1:

输入: [[1,1],[2,2],[3,3]]
输出: 3
解释:
^
|
|        o
|     o
|  o
+------------->
0  1  2  3  4
示例 2:

输入: [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]
输出: 4
解释:
^
|
|  o
|     o        o
|        o
|  o        o
+------------------->
0  1  2  3  4  5  6
 */

import java.util.HashMap;
import java.util.Map;

/**
 * demo         :MaxPoints
 *
 * @author ：wutian
 * @date ：Created in 2019/8/29 10:33
 */
public class MaxPoints {

    public static int maxPoints(int[][] points) {
        int n = points.length;
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        int res = 0;
        for (int i = 0; i < n - 1; i++) {
            Map<String, Integer> slope = new HashMap<>();
            int repeat = 0;
            int tmp_max = 0;
            for (int j = i + 1; j < n; j++) {
                int dy = points[i][1] - points[j][1];
                int dx = points[i][0] - points[j][0];
                if (dy == 0 && dx == 0) {
                    repeat++;
                    continue;
                }
                int g = gcd(dy, dx);
                if (g != 0) {
                    dy /= g;
                    dx /= g;
                }
                String tmp = String.valueOf(dy) + "/" + String.valueOf(dx);
                slope.put(tmp, slope.getOrDefault(tmp, 0) + 1);
                tmp_max = Math.max(tmp_max, slope.get(tmp));
            }
            res = Math.max(res, repeat + tmp_max + 1);
        }
        return res;
    }

    private static int gcd(int dy, int dx) {
        if (dx == 0) {
            return dy;
        } else {
            return gcd(dx, dy % dx);
        }
    }

    public static void main(String[] args) {
        int [][] arr={{1,1},{2,2},{3,3},{4,4}};

        System.out.println(maxPoints(arr));

    }
}
