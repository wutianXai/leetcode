package leetcode.hard.designproblem;

/*
LRU 缓存机制
运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制。它应该支持以下操作： 获取数据 get 和 写入数据 put 。

获取数据 get(key) - 如果密钥 (key) 存在于缓存中，则获取密钥的值（总是正数），否则返回 -1。
写入数据 put(key, value) - 如果密钥不存在，则写入其数据值。当缓存容量达到上限时，它应该在写入新数据之前删除最近最少使用的数据值，从而为新的数据值留出空间。

进阶:

你是否可以在 O(1) 时间复杂度内完成这两种操作？

示例:

LRUCache cache = new LRUCache( 2 );

        cache.put(1, 1);
        cache.put(2, 2);
        cache.get(1);       // 返回  1
        cache.put(3, 3);    // 该操作会使得密钥 2 作废
        cache.get(2);       // 返回 -1 (未找到)
        cache.put(4, 4);    // 该操作会使得密钥 1 作废
        cache.get(1);       // 返回 -1 (未找到)
        cache.get(3);       // 返回  3
        cache.get(4);       // 返回  4
 */
/*
思路：数组暴力法//299ms
 */
/**
 * LRUCache
 *
 * @author ：wutian
 * @date ：Created in 2019/9/4 21:39
 */
public class  LRUCache {
    int last=-1;
    int [][] arr;
    public LRUCache(int capacity) {
        arr=new int[capacity][2];
    }

    public int get(int key) {
        for (int i=0;i<=last;i++){
            if(arr[i][0]!=key){
                continue;
            }else {
                for(int j=i+1;j<=last;j++){
                    int [] temp=arr[j-1];
                    arr[j-1]=arr[j];
                    arr[j]=temp;
                }
                return arr[last][1];
            }

        }

        return -1;

    }

    public void put(int key, int value) {
        for(int i=0;i<=last;i++){
            if(arr[i][0]==key ){
                if(arr[i][1]!=value) {
                    arr[i][1]=value;
                }
                for(int j=i+1;j<=last;j++){
                    int [] temp=arr[j-1];
                    arr[j-1]=arr[j];
                    arr[j]=temp;
                }
                return;
            }
        }

        int [] temp={key,value};
        if(last==arr.length-1){
            for(int i=1;i<arr.length;i++){
                arr[i-1]=arr[i];
            }
            last--;
        }

        arr[++last]=temp;
    }

    public static void main(String[] args) {

//        LRUCache cache = new LRUCache( 1 /* 缓存容量 */ );
//        cache.put(2,1);
//        System.out.println(cache.get(2));
        LRUCache cache = new LRUCache( 2 /* 缓存容量 */ );
        cache.put(2,1);
        cache.put(1,1);
        cache.put(2,3);
        cache.put(4,1);
        System.out.println(cache.get(1));
        System.out.println(cache.get(2));


//        LRUCache cache = new LRUCache( 2 /* 缓存容量 */ );
//        cache.put(1, 1);
//        cache.put(2, 2);
//        cache.get(1);       // 返回  1
//        cache.put(3, 3);    // 该操作会使得密钥 2 作废
//        cache.get(2);       // 返回 -1 (未找到)
//        cache.put(4, 4);    // 该操作会使得密钥 1 作废
//        cache.get(1);       // 返回 -1 (未找到)
//        cache.get(3);       // 返回  3
//        cache.get(4);       // 返回  4

    }
}
