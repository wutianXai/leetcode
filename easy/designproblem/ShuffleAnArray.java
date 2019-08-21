package leetcode.easy.designproblem;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author wutia
 * @ClassName ShuffleAnArray
 * @date 2019/8/21 16:34
 */
public class ShuffleAnArray {
    public static void main(String[] args) {
        int[] arr={1,2,3};
        Solution solution=new Solution(arr);
        solution.shuffle();
        solution.reset();


    }
}

class Solution {
    int [] ori;

    public Solution(int[] nums) {
        this.ori=nums;
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {

        return this.ori;
    }


    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        int[] nums=this.ori.clone();

        Random r = ThreadLocalRandom.current();
        int n=nums.length;
        while(n>1){
            n--;
            int k = r.nextInt(n+1);
            int value = nums[k];
            nums[k] = nums[n];
            nums[n] = value;
        }

        return nums;
    }
}
