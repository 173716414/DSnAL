package test;

import ds.list.ReverseList;

public class pizi {
    public static void main(String[] args){
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ListNode res = reverseKGroup(head, 2);
        while(res != null){
            System.out.println(res.val);
            res = res.next;
        }
    }
    public static ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null || k == 1) {
            return head;
        }

        ListNode dummy = new ListNode(0); // 创建一个哑节点作为头节点
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = head;

        while (cur != null) {
            // 找到第K个节点的前一个节点
            ListNode end = pre;
            for (int i = 0; i < k; i++) {
                if (end.next == null) {
                    return dummy.next; // 如果链表长度不足K个，直接返回
                }
                end = end.next;
            }

            // 反转当前的K个节点
            ListNode next = end.next;
            ListNode newHead = reverse(cur, end);

            // 将反转后的链表连接到pre之后
            pre.next = newHead;
            cur.next = next;

            // 更新pre和cur指针
            pre = cur;
            cur = next;
        }

        return dummy.next;
    }

    private static ListNode reverse(ListNode start, ListNode end) {
        ListNode pre = start;
        ListNode cur = start.next;
        ListNode next = null;

        while (cur != end) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        return pre;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
