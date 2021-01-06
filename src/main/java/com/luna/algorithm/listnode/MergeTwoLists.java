package com.luna.algorithm.listnode;

import com.luna.algorithm.common.ListNode;

//21. 合并两个有序链表
//  将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
//
//  示例：
//
//  输入：1->2->4, 1->3->4
//  输出：1->1->2->3->4->4

public class MergeTwoLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(0);
        ListNode index = res;
        while(l1 != null && l2 != null){
            if(l1.val > l2.val){
                index.next = l2;
                l2 = l2.next;
                index = index.next;
            }else{
                index.next = l1;
                l1 = l1.next;
                index = index.next;
            }
        }
        if(l1 != null){
            index.next = l1;
        }
        if(l2 != null){
            index.next = l2;
        }
        return res.next;
    }




    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.add(2).add(4);
        ListNode l2 = new ListNode(1);
        l2.add(3).add(4);
        MergeTwoLists m = new MergeTwoLists();
        ListNode res = m.mergeTwoLists(l1,l2);
        res.print();
    }


}
