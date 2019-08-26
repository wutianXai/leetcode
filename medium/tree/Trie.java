package leetcode.medium.tree;
/*
实现一个 Trie (前缀树)，包含 insert, search, 和 startsWith 这三个操作。

示例:

Trie trie = new Trie();

trie.insert("apple");
trie.search("apple");   // 返回 true
trie.search("app");     // 返回 false
trie.startsWith("app"); // 返回 true
trie.insert("app");
trie.search("app");     // 返回 true
说明:

你可以假设所有的输入都是由小写字母 a-z 构成的。
保证所有输入均为非空字符串。

 */

class TrieNode{
    //孩子节点，分别记录26个字母
    TrieNode[] children = new TrieNode[26];
    //当前的节点（叶子节点）对应的单词
    boolean isStr=false;
}


/**
 * @author wutia
 * @ClassName Trie
 * @date 2019/8/26 11:42
 */
public class Trie {
    private TrieNode root;
    /** Initialize your data structure here. */
    public Trie() {
        root=new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode trieNode=root;
        for(char c:word.toCharArray()) {
            if(trieNode.children[c-'a']==null) {
                trieNode.children[c - 'a'] = new TrieNode();
                trieNode.children[c - 'a'].isStr = false;

            }
            trieNode = trieNode.children[c - 'a'];
        }
        trieNode.isStr=true;

    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode trieNode=root;
        for(char c:word.toCharArray()) {
            if(trieNode.children[c-'a']==null) {
                return false;
            }
            trieNode = trieNode.children[c - 'a'];
        }
        if(trieNode.isStr==true)return true;
        return false;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode trieNode=root;
        for(char c:prefix.toCharArray()) {
            if(trieNode.children[c-'a']==null) {
                return false;
            }
            trieNode = trieNode.children[c - 'a'];
        }
        return true;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();

        trie.insert("apple");
        // 返回 true
        System.out.println(trie.search("apple"));
        // 返回 false
        System.out.println(trie.search("app"));
        // 返回 true
        System.out.println(trie.startsWith("app"));
        trie.insert("app");
        // 返回 true
        System.out.println(trie.search("app"));

    }

}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */