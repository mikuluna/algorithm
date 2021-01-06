package com.luna.algorithm.listnode;

import com.luna.algorithm.common.ListNode;

//19. 删除链表的倒数第N个节点
//
//        给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
//
//        示例：
//
//        给定一个链表: 1->2->3->4->5, 和 n = 2.
//
//        当删除了倒数第二个节点后，链表变为 1->2->3->5.
//        说明：
//
//        给定的 n 保证是有效的。
//
//        进阶：
//
//        你能尝试使用一趟扫描实现吗？

public class RemoveNthFromEnd {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode() {}
     *     ListNode(int val) { this.val = val; }
     *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dump = new ListNode(0,head);
        ListNode res = dump;
        ListNode index = head;
        int len = 0;
        while(index != null){
            index = index.next;
            len ++;
        }
        for(int i = 0 ;i < len-n ; i++){
            dump = dump.next;
        }
        dump.next = dump.next.next;
        return res.next;
    }




    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.add(2).add(3).add(4).add(5);
        int num = 2;
//        num = 1;
        RemoveNthFromEnd remove = new RemoveNthFromEnd();
        ListNode res = remove.removeNthFromEnd(l1,num);
        if(res != null){
            res.print();
        }
    }


    public ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode index = head;
        ListNode dummy = new ListNode(0, head);
        ListNode res = dummy;
        int size = 0;
        while(index != null){
            index = index.next;
            size ++;
        }
        for(int i = 1 ; i < size - n + 1; i ++){
            dummy = dummy.next;
        }
        dummy.next = dummy.next.next;
        return res.next;
    }

    public ListNode removeNthFromEnd1(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        ListNode first = head;
        ListNode second = dummy;
        for (int i = 0; i < n; ++i) {
            first = first.next;
        }
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        ListNode ans = dummy.next;
        return ans;
    }
}
