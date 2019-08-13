package leetcode.medium.tree;

/**
 * 岛屿数量
 * @author wutia
 * @ClassName NumIslands
 * @date 2019/8/13 23:02
 */
public class NumIslands {
    public static int numIslands(char[][] grid) {

        if(grid==null||grid.length==0||grid[0].length==0)return 0;
        int rows=grid.length;
        int cols=grid[0].length;

        int [][]flag=new int[rows][cols];

        int count=0;

        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                if (grid[i][j] == '1') {
                    count++;
                    dfsSearch(grid, i, j, rows, cols);
                }
        return count;

    }

    public static void dfsSearch(char[][] grid, int i, int j, int rows, int cols) {
        if (i < 0 || i >= rows || j < 0 || j >= cols)
            return;
        if (grid[i][j] != '1')
            return;
        // 也可以才用一个visited数组，标记遍历过的岛屿
        grid[i][j] = '0';
        dfsSearch(grid, i + 1, j, rows, cols);
        dfsSearch(grid, i - 1, j, rows, cols);
        dfsSearch(grid, i, j + 1, rows, cols);
        dfsSearch(grid, i, j - 1, rows, cols);

    }

    public static void main(String[] args) {
        char [][] grid={{'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'}};

        char [][] g1={};

        System.out.println(numIslands(g1));

    }
}
