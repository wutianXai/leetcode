package leetcode.hard.recall;

import com.alibaba.fastjson.JSON;
import leetcode.medium.tree.Trie;

import java.util.ArrayList;
import java.util.List;

/*
单词搜索 II
给定一个二维网格 board 和一个字典中的单词列表 words，找出所有同时在二维网格和字典中出现的单词。

单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母在一个单词中不允许被重复使用。

示例:

输入:
words = ["oath","pea","eat","rain"] and board =
[
  ['o','a','a','n'],
  ['e','t','a','e'],
  ['i','h','k','r'],
  ['i','f','l','v']
]

输出: ["eat","oath"]
说明:
你可以假设所有输入都由小写字母 a-z 组成。
 */
/**
 * @author wutia
 * @date 2019/8/25 10:01
 */
public class FindWords {
    static  boolean [][] isused;

    static  StringBuilder stringBuilder=new StringBuilder();
    static  Trie trie=new Trie();

    public static List<String> findWords(char[][] board, String[] words) {
        List<String> res=new ArrayList<>();
        if(words.length==0 || board.length==0) {
            return res;
        }
        isused=new boolean[board.length][board[0].length];


        for (String str :
                words) {
            if(str.length()==1) {
                continue;
            }
            trie.insert(str);
        }



        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(trie.startsWith(String.valueOf(board[i][j]))){
                    dfs(board,i,j,res);
                    isused=new boolean[board.length][board[0].length];
                    stringBuilder=new StringBuilder();
                }
            }
        }

        return  res;
    }

    public static void  dfs(char [][] board,int i,int j,List res){
        if(!isused[i][j]) {
            stringBuilder.append(board[i][j]);
            isused[i][j] = true;

            if (trie.startsWith(stringBuilder.toString())) {
                if (trie.search(stringBuilder.toString())) {
                    res.add(stringBuilder.toString());
                    return;
                } else {
                    if (i + 1 < board.length) {
                        dfs(board, i + 1, j, res);
                    }
                    if (j + 1 < board[0].length) {
                        dfs(board, i, j + 1, res);
                    }
                    if (i - 1 >= 0) {
                        dfs(board, i - 1, j, res);
                    }
                    if (j - 1 >= 0) {
                        dfs(board, i, j - 1, res);
                    }
                }
            }
            else {
                stringBuilder.deleteCharAt(stringBuilder.length()-1);
                return;
            }
        }

    }

    public static void main(String[] args) {
        String [] words={"oath","pea","eat","rain"};
        char [][] board={
                {'o','a','a','n'},
                {'e','t','a','e'},
                {'i','h','k','r'},
                {'i','f','l','v'}
        };

        System.out.println(JSON.toJSONString(findWords(board,words)));

    }
}

/*
ac代码：
 */
//import java.util.*;
//class TrieNode {
//    private static final int ALPHABET_SIZE = 26;
//
//    TrieNode[] children = new TrieNode[ALPHABET_SIZE];
//    // 判断这个前缀是不是某个字符串的结尾
//    boolean isEndOfWord = false;
//    TrieNode() {
//        isEndOfWord = false;
//        for (int i = 0; i < ALPHABET_SIZE; i++)
//            children[i] = null;
//    }
//}
//
//class Trie {
//    public TrieNode root;
//    /** Initialize your data structure here. */
//    public Trie() {
//        root = new TrieNode();
//    }
//    /** Inserts a word into the trie. */
//    public void insert(String word) {
//        TrieNode curNode = root;
//        int index;
//        for (int i = 0; i < word.length(); i++) {
//            index = word.charAt(i) - 'a';
//            if (curNode.children[index] == null) {
//                curNode.children[index] = new TrieNode();
//            }
//            curNode = curNode.children[index];
//        }
//        curNode.isEndOfWord = true;
//    }
//}
//class Solution {
//    public List<String> findWords(char[][] board, String[] words) {
//        List<String> result = new ArrayList<>();
//        if (words == null || words.length == 0 || board == null || board.length == 0 || board[0].length == 0)
//            return result;
//
//        Trie trie = new Trie();
//        for (String temp : words)
//            trie.insert(temp);
//
//        TrieNode root = trie.root;
//        boolean[][] visited = new boolean[board.length][board[0].length];
//        Set<String> tempResult = new HashSet<>();
//        StringBuilder sb = new StringBuilder();
//        for (int i = 0; i < board.length; i++) {
//            for (int j = 0; j < board[0].length; j++) {
//                if (root.children[board[i][j] - 'a'] != null ) {
//                    dfs(board, visited, i, j, root.children[board[i][j] - 'a'], tempResult, sb);
//                }
//            }
//        }
//
//        // 需要把tempResult这个set拷贝到真正的result List中进行返回
//        Iterator<String> iterator = tempResult.iterator();
//        while (iterator.hasNext()) {
//            result.add(iterator.next());
//        }
//        return result;
//    }
//
//    private void dfs(char[][] board, boolean[][] visited, int startIInBoard, int startJInBoard
//            , TrieNode curNode, Set<String> resultSet, StringBuilder curStrBuilder) {
//        curStrBuilder.append(board[startIInBoard][startJInBoard]);
//        visited[startIInBoard][startJInBoard] = true;
//        if (curNode.isEndOfWord) {
//            resultSet.add(curStrBuilder.toString());
//        }
//        // 向上搜索, 如果上面的格子没有被搜索过的话
//        if (startIInBoard > 0 && !visited[startIInBoard - 1][startJInBoard]
//                && curNode.children[board[startIInBoard - 1][startJInBoard] - 'a'] != null) {
//            dfs(board, visited,startIInBoard - 1, startJInBoard
//                    , curNode.children[board[startIInBoard - 1][startJInBoard] - 'a'], resultSet, curStrBuilder);
//        }
//        // 向下搜索
//        if (startIInBoard < board.length - 1 && !visited[startIInBoard + 1][startJInBoard]
//                && curNode.children[board[startIInBoard + 1][startJInBoard] - 'a'] != null) {
//            dfs(board, visited,startIInBoard + 1, startJInBoard
//                    , curNode.children[board[startIInBoard + 1][startJInBoard] - 'a'], resultSet, curStrBuilder);
//        }
//        // 向左搜索
//        if (startJInBoard > 0 && !visited[startIInBoard][startJInBoard - 1]
//                && curNode.children[board[startIInBoard][startJInBoard - 1] - 'a'] != null) {
//            dfs(board, visited, startIInBoard, startJInBoard - 1
//                    , curNode.children[board[startIInBoard][startJInBoard - 1] - 'a'], resultSet, curStrBuilder);
//        }
//        // 向右搜索
//        if (startJInBoard < board[0].length - 1 && !visited[startIInBoard][startJInBoard + 1]
//                && curNode.children[board[startIInBoard][startJInBoard + 1] - 'a'] != null) {
//            dfs(board, visited, startIInBoard, startJInBoard + 1
//                    , curNode.children[board[startIInBoard][startJInBoard + 1] - 'a'], resultSet, curStrBuilder);
//        }
//        // 恢复现场
//        curStrBuilder.setLength(curStrBuilder.length() - 1);
//        visited[startIInBoard][startJInBoard] = false;
//    }
//}