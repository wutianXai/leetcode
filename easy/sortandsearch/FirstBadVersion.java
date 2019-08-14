package leetcode.easy.sortandsearch;
/*
思路：二分查找
 */
/**
 * 第一个错误的版本
 * @author wutia
 * @ClassName FirstBadVersion
 * @date 2019/8/14 10:06
 */
public class FirstBadVersion {
    static boolean  isBadVersion(int version){
        if(version>=2)return true;
        else return false;
    }
    public static int firstBadVersion(int n) {
        int min = 1, max = n, mid = 0;
        while(min <= max){
            mid = min + (max - min) / 2;
            if(isBadVersion(mid)){
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return min;

    }

    public static void main(String[] args) {
        System.out.println(firstBadVersion(7));

    }
}
