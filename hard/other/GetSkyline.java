package leetcode.hard.other;

import com.alibaba.fastjson.JSON;

import java.util.*;
/*
天际线问题
城市的天际线是从远处观看该城市中所有建筑物形成的轮廓的外部轮廓。现在，假设您获得了城市风光照片（图A）上显示的所有建筑物的位置和高度，请编写一个程序以输出由这些建筑物形成的天际线（图B）。

Buildings  Skyline Contour

每个建筑物的几何信息用三元组 [Li，Ri，Hi] 表示，其中 Li 和 Ri 分别是第 i 座建筑物左右边缘的 x 坐标，Hi 是其高度。可以保证 0 ≤ Li, Ri ≤ INT_MAX, 0 < Hi ≤ INT_MAX 和 Ri - Li > 0。您可以假设所有建筑物都是在绝对平坦且高度为 0 的表面上的完美矩形。

例如，图A中所有建筑物的尺寸记录为：[ [2 9 10], [3 7 15], [5 12 12], [15 20 10], [19 24 8] ] 。

输出是以 [ [x1,y1], [x2, y2], [x3, y3], ... ] 格式的“关键点”（图B中的红点）的列表，它们唯一地定义了天际线。关键点是水平线段的左端点。请注意，最右侧建筑物的最后一个关键点仅用于标记天际线的终点，并始终为零高度。此外，任何两个相邻建筑物之间的地面都应被视为天际线轮廓的一部分。

例如，图B中的天际线应该表示为：[ [2 10], [3 15], [7 12], [12 0], [15 10], [20 8], [24, 0] ]。

说明:

任何输入列表中的建筑物数量保证在 [0, 10000] 范围内。
输入列表已经按左 x 坐标 Li  进行升序排列。
输出列表必须按 x 位排序。
输出天际线中不得有连续的相同高度的水平线。例如 [...[2 3], [4 5], [7 5], [11 5], [12 7]...] 是不正确的答案；三条高度为 5 的线应该在最终输出中合并为一个：[...[2 3], [4 5], [12 7], ...]
 */
/*
思路：
参考：https://blog.csdn.net/whdAlive/article/details/81152670
 */
/**
 * GetSkyline
 *
 * @author ：wutian
 * @date ：Created in 2019/9/3 15:15
 */
public class GetSkyline {
//    // 排序规则，按照x的坐标升序排列，若x坐标相同，右端点在前
//    class IntCompator implements Comparator<int[]> {
//        @Override
//        public int compare(int[] o1, int[] o2) {
//            if (o1[0] == o2[0])
//                return o2[1] - o1[1];
//            return o1[0] - o2[0];
//        }
//    }
//
//    public List<List<Integer>> getSkyline(int[][] buildings) {
//        List<List<Integer>> list = new ArrayList<>();
//        int newbuild[][] = new int[2 * buildings.length][2];
//
//        // 将建筑物坐标化成[右端点，高度]，[左端点，-高度],用高度的正负来判断是左端点还是右端点。
//        for (int i = 0; i < buildings.length; i++) {
//            newbuild[2 * i][0] = buildings[i][0];
//            newbuild[2 * i][1] = buildings[i][2];
//            newbuild[2 * i + 1][0] = buildings[i][1];
//            newbuild[2 * i + 1][1] = -buildings[i][2];
//        }
//        Arrays.sort(newbuild, new IntCompator());
//
//        // list1维护堆内的有序
//        List<Integer> list1 = new ArrayList<>();
//        list1.add(0);
//        int index;
//
//        for (int i = 0; i < newbuild.length; i++) {
//            if (newbuild[i][1] > 0) {// 左端点
//                if (newbuild[i][1] > list1.get(list1.size() - 1)) {// 如果左端点的高度比堆的最大值还大，说明是一个转折点
//                    list.add(Arrays.asList(newbuild[i][0], newbuild[i][1]));
//                }
//                index = findIndex(list1, newbuild[i][1]);
//                list1.add(index, newbuild[i][1]);// 将该点入堆
//            } else {//右端点
//                index = findIndex(list1, -newbuild[i][1]);
//                list1.remove(index);//先将该点从堆中移除
//                if (-newbuild[i][1] > list1.get(list1.size() - 1)) {//如果右端点的高度是堆内最大，说明是一个转折点
//                    list.add(Arrays.asList(newbuild[i][0], list1.get(list1.size() - 1)));
//                }
//            }
//        }
//        return list;
//    }

//    // 二分查找辅助函数
//    public int findIndex(List<Integer> list, int n) {
//        int low = 0, high = list.size(), middle;
//        while (low < high) {
//            middle = (low + high) >>> 1;
//            if (list.get(middle) < n) {
//                low = middle + 1;
//            } else {
//                high = middle;
//            }
//        }
//        return low;
//    }

    public static List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> result = new ArrayList<>();
        List<int[]> height = new ArrayList<>();

        //将矩形拆分为，左上角坐标和右上角坐标，同时为了区分二者，将左上角的纵坐标设为负值
        for(int[] building:buildings){
            height.add(new int[]{building[0],-building[2]});
            height.add(new int[]{building[1],building[2]});
        }

        //按照 优先横坐标从小到大（x轴从左到右），其次纵坐标从小到大 排序
        Collections.sort(height,(a,b)->{
            if(a[0]!=b[0]) { return a[0] - b[0]; }
             return a[1]-b[1];
        });

        //优先队列，大顶堆
        //默认容量是11，因此也创建一个容量为11
        Queue<Integer> pq = new PriorityQueue<>(11,(i1,i2)->i2-i1);
        //首先将地平线加入
        pq.offer(0);

        //记录上一次最大高度
        int prev = 0;

        //遍历
        for(int[] h:height){
            //加入左上角坐标
            if(h[1]<0){
                pq.offer(-h[1]);
            }else{
                //如果此时遇到右上角坐标，那么意味着这个矩形已经处理完了，将左上角坐标移除即可
                pq.remove(h[1]);
            }
            //当前最大高度
            int cur = pq.peek();

            //两次最大高度不一致，说明前一个最大高度被移除，或者新加入了更高的building
            if(prev != cur){
                //添加拐点
                List<Integer> list=new ArrayList<>();
                list.add(h[0]);list.add(cur);
                result.add(list);
                //更新
                prev = cur;
            }
        }
        return result;
    }

    public static void main(String[] args) {

        int [][] arr={ {2 ,9 ,10}, {3 ,7 ,15}, {5, 12 ,12}, {15 ,20 ,10}, {19 ,24 ,8} };
        System.out.println(JSON.toJSON(getSkyline(arr)));

    }
}
