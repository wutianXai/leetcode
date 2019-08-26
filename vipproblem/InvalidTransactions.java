package leetcode.vipproblem;
/*
5167. 查询无效交易
题目难度 Easy
如果出现下述两种情况，交易 可能无效：

交易金额超过 ¥1000
或者，它和另一个城市中同名的另一笔交易相隔不超过 60 分钟（包含 60 分钟整）
每个交易字符串 transactions[i] 由一些用逗号分隔的值组成，这些值分别表示交易的名称，时间（以分钟计），金额以及城市。

给你一份交易清单 transactions，返回可能无效的交易列表。你可以按任何顺序返回答案。

示例 1：

输入：transactions = ["alice,20,800,mtv","alice,50,100,beijing"]
输出：["alice,20,800,mtv","alice,50,100,beijing"]
解释：第一笔交易是无效的，因为第二笔交易和它间隔不超过 60 分钟、名称相同且发生在不同的城市。同样，第二笔交易也是无效的。
示例 2：

输入：transactions = ["alice,20,800,mtv","alice,50,1200,mtv"]
输出：["alice,50,1200,mtv"]
示例 3：

输入：transactions = ["alice,20,800,mtv","bob,50,1200,mtv"]
输出：["bob,50,1200,mtv"]
 */

import com.alibaba.fastjson.JSON;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author wutia
 * @ClassName InvalidTransactions
 * @date 2019/8/25 10:34
 */
public class InvalidTransactions {
    public static List<String> invalidTransactions(String[] transactions) {
        List<String> res = new ArrayList<>();

        boolean[] isinvalid = new boolean[transactions.length];

        for (int i = 0; i < transactions.length; i++) {
            String[] chars = transactions[i].split(",");
            if (Integer.valueOf(chars[2]) > 1000) {
                res.add(transactions[i]);
                isinvalid[i] = true;
            }
        }
        for (int i = 0; i < transactions.length; i++) {
            if (isinvalid[i] == false) {
                String[] chars = transactions[i].split(",");

                for (int j = 0; j < transactions.length; j++) {
                    if (i == j) continue;
                    String[] chars1 = transactions[j].split(",");

                    if (chars[0].equals(chars1[0]) && (!chars[3].equals(chars1[3]))) {
                        int a = Math.abs(Integer.valueOf(chars[1]) - Integer.valueOf(chars1[1]));
                        if (a <= 60) {
                            if (isinvalid[i] == false) {
                                res.add(transactions[i]);
                                isinvalid[i] = true;
                            }
                            if (isinvalid[j] == false) {
                                res.add(transactions[j]);
                                isinvalid[j] = true;
                            }

                        }


                    }

                }

            }

        }


        return res;

    }

    public static void main(String[] args) {
//        String[] str={"alice,20,800,mtv","alice,50,100,beijing"};
        String[] str={"alice,20,800,mtv","bob,50,1200,mtv"};
//        String[] str = {"alice,20,800,mtv", "alice,50,1200,mtv"};
        System.out.println(JSON.toJSONString(invalidTransactions(str)));

    }
}
