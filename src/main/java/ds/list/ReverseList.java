package ds.list;

/*
 *Author：Victor_htq
 *Package：ds.list
 *Project：DSnAL
 *name：ReverseList
 *Date：2024/3/6  20:12
 *Filename：ReverseList
 */
public class ReverseList {
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode tmp = pre;
            pre = cur;
            cur = cur.next;
            pre.next = tmp;
        }
        return head;
    }
}
