package leetcode.medium.other;
/*
Task Scheduler
给定一个用字符数组表示的 CPU 需要执行的任务列表。其中包含使用大写的 A - Z 字母表示的26 种不同种类的任务。任务可以以任意顺序执行，并且每个任务都可以在 1 个单位时间内执行完。CPU 在任何一个单位时间内都可以执行一个任务，或者在待命状态。

然而，两个相同种类的任务之间必须有长度为 n 的冷却时间，因此至少有连续 n 个单位时间内 CPU 在执行不同的任务，或者在待命状态。

你需要计算完成所有任务所需要的最短时间。

示例 1：

输入: tasks = ["A","A","A","B","B","B"], n = 2
输出: 8
执行顺序: A -> B -> (待命) -> A -> B -> (待命) -> A -> B.
注：

任务的总个数为 [1, 10000]。
n 的取值范围为 [0, 100]。
 */
/*
思路：
统计所有符号出现的个数，找到频率出现最高的数max和相同频率的数maxCount
将最大符号按最长间隔排开，如输入AAABB，n=2
那么排列为A__A__A,执行（max-1)*(n+1) +1 次，将剩下的数插入即可；
若出现相同频率的数，插入在队尾即可，则最后为（max-1)*(n+1)+maxCount
有可能出现AABBCDEFGH n=2时,最大数的空挡容纳不下其他任务，这种情况直接返回数组长度即可
 */
import java.util.HashMap;
import java.util.Map;

/**
 * LeastInterval
 *
 * @author ：wutian
 * @date ：Created in 2019/8/30 11:50
 */
public class LeastInterval {
    public static int leastInterval(char[] tasks, int n) {
        if (n == 0) {
            return tasks.length;
        }
        Map<Character, Integer> map = new HashMap<>();
        for (char c :
                tasks) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int max = Integer.MIN_VALUE;
        int maxCount = 1;
        for (Map.Entry<Character, Integer> entry :
                map.entrySet()) {
            int a = entry.getValue();
            if (a > max) {
                max = a;
                maxCount = 1;
            } else if (a == max) {
                maxCount++;
            }
        }

        return  Math.max(tasks.length,(max-1)*(n+1)+maxCount);

    }

    public static void main(String[] args) {
        char[] carr = {'A', 'A', 'B', 'B', 'B'};
//        char[] carr={'A','A','A','A','B','B','B','E','E','F','F','G','G'};
//        char[] carr={'A','A','B','E'};
        int n = 1;
        System.out.println(leastInterval(carr, n));

    }

}
