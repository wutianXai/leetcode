package leetcode.medium.sortandsearch;
/*
offer原题：从右上角开始查找，若target比该值小则向左；若大，则向下
 */
/**
 * 搜索二维矩阵 II
 * @author wutia
 * @ClassName SearchMatrix
 * @date 2019/8/15 13:18
 */
public class SearchMatrix {
    public static boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length==0)return false;

        int rows=matrix.length-1;
        int cols=matrix[0].length-1;
        int i=0;int j=cols;
        while (i<=rows && j>=0){
            if(target==matrix[i][j])return true;
            if(target>matrix[i][j]){
                i++;
            }else{
                j--;
            }
        }

        return false;

    }


    public static void main(String[] args) {
        int [][] matrix={{-5}
//                {1,   4,  7, 11, 15},
//                {2,   5,  8, 12, 19},
//                {3,   6,  9, 16, 22},
//                {10, 13, 14, 17, 24},
//                {18, 21, 23, 26, 30}
            };

        int target=-5;
        System.out.println(searchMatrix(matrix,target));

    }
}
