package ds.list;

/*
 *Author：Victor_htq
 *Package：ds.list
 *Project：DSnAL
 *name：ListNode
 *Date：2024/3/5  16:01
 *Filename：ListNode
 */
public class ListNode {
    int val;

    ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
