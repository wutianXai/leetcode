package leetcode.hard.recall;

import com.alibaba.fastjson.JSON;

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
 * @ClassName FindWords
 * @date 2019/8/25 10:01
 */
public class FindWords {
    static  boolean [][] isused;
    static List<String> res=new ArrayList<>();
    static  StringBuilder stringBuilder=new StringBuilder();
    public static List<String> findWords(char[][] board, String[] words) {

        if(words.length==0 && board.length==0)return res;
        isused=new boolean[board.length][board[0].length];

        for (String str :
                words) {

            for(int i=0;i<board.length;i++){
                for(int j=0;j<board[0].length;j++){
                    if(isused[i][j]==false && str.charAt(0)==board[i][j]){
                        isused[i][j]=true;
                        stringBuilder.append(str.charAt(0));
                        dfs(board,i,j,1,str);
                        if(stringBuilder.length()==str.length()){
                            res.add(stringBuilder.toString());
                        }
                        stringBuilder=new StringBuilder();
                    }
                }
            }
        }
        return  res;
    }

    public static void  dfs(char [][] board,int i,int j,int path,String target){
        if(path==target.length())return;
        if(isused[i][j]==false && target.charAt(path)==board[i][j]){
            stringBuilder.append(target.charAt(path));
            dfs(board,i+1,j,path+1,target);
            dfs(board,i,j+1,path+1,target);
            dfs(board,i-1,j,path+1,target);
            dfs(board,i,j-1,path+1,target);
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
