package com.luna.algorithm.listnode;
//25. K 个一组翻转链表
//        给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
//
//        k 是一个正整数，它的值小于或等于链表的长度。
//
//        如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
//
//         
//
//        示例：
//
//        给你这个链表：1->2->3->4->5
//
//        当 k = 2 时，应当返回: 2->1->4->3->5
//
//        当 k = 3 时，应当返回: 3->2->1->4->5
//
//         
//
//        说明：
//
//        你的算法只能使用常数的额外空间。
//        你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。

import com.luna.algorithm.common.ListNode;

public class ReverseKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null ||head.next == null){
            return head;
        }
        ListNode res = new ListNode(0,head);
        ListNode pre = res;
        ListNode index = res;
        while(index != null){
            for(int i = 0 ; i < k && index!= null ;i++){
                index = index.next;
            }
            if(index == null){
                break;
            }
            ListNode next = index.next;
            ListNode start = pre.next;
            index.next = null;
            pre.next = reverse(start);
            start.next = next;
            pre = start;
            index = start;
        }
        return res.next;

    }
    public ListNode reverse(ListNode head){
        ListNode pre = null;
        while(head != null){
            ListNode next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.add(2).add(3).add(4).add(5);
        int k = 2;
//        k = 3;
        ReverseKGroup s = new ReverseKGroup();
        ListNode res = s.reverseKGroup(l1,k);
        if(res != null) {
            res.print();
        }
    }
}
