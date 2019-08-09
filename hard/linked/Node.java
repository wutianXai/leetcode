package leetcode.hard.linked;

/**
 * @author wutia
 * @ClassName Node
 * @date 2019/8/9 21:42
 */
class Node {
    public int val;
    public Node next;
    public Node random;

    public Node() {}

    public Node(int _val,Node _next,Node _random) {
        val = _val;
        next = _next;
        random = _random;
    }
}
