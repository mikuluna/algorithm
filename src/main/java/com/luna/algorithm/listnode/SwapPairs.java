package com.luna.algorithm.listnode;
//24. 两两交换链表中的节点
//        给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
//
//        你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
//
//         
//
//        示例 1：
//
//
//        输入：head = [1,2,3,4]
//        输出：[2,1,4,3]
//        示例 2：
//
//        输入：head = []
//        输出：[]
//        示例 3：
//
//        输入：head = [1]
//        输出：[1]
//         
//
//        提示：
//
//        链表中节点的数目在范围 [0, 100] 内
//        0 <= Node.val <= 100

import com.luna.algorithm.common.ListNode;

public class SwapPairs {
    //适用于n个反转
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode res = new ListNode(0);
        res.next = head;
        ListNode pre = res;
        ListNode index = res;
        ListNode next = head;
        while(index != null){
            for(int i =0;i <  2 && index!=null;i++){
                index = index.next;
            }
            if(index == null){
                break;
            }
            ListNode start = index.next;
            index.next = null;
            pre.next = reverse(next);
            next.next = start;
            pre = next;
            index = next;
            next = start;
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
        SwapPairs s = new SwapPairs();
        ListNode res = s.swapPairs(l1);
        if(res != null) {
            res.print();
        }
    }

}
