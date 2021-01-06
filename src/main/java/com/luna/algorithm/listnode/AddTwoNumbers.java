package com.luna.algorithm.listnode;

import com.luna.algorithm.common.ListNode;

//2.两数相加
//给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
//
//        如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
//
//        您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
//
//        示例：
//
//        输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
//        输出：7 -> 0 -> 8
//        原因：342 + 465 = 807
public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(0);
        ListNode index = res;
        boolean isAdd = false;
        while (l1 != null && l2 != null) {
            int sum = l1.val+l2.val+ (isAdd?1:0);
            int num = sum % 10;
            isAdd = sum >= 10;
            ListNode numNode = new ListNode(num);
            index.next = numNode;
            index = index.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        while(l1 != null){
            int sum = l1.val +(isAdd?1:0);
            int num = sum % 10;
            isAdd = sum >= 10;
            ListNode numNode = new ListNode(num);
            index.next = numNode;
        }
        while(l2 != null){
            int sum = l2.val +(isAdd?1:0);
            int num = sum % 10;
            isAdd = sum >= 10;
            ListNode numNode = new ListNode(num);
            index.next = numNode;
        }
        if(isAdd){
            ListNode numNode = new ListNode(1);
            index.next = numNode;
        }
        return res.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.add(4).add(3);
        ListNode l2 = new ListNode(5);
        l2.add(6).add(4);
        l1.print();
        l2.print();
        AddTwoNumbers tool = new AddTwoNumbers();
        ListNode res = tool.addTwoNumbers(l1,l2);
        res.print();

    }

}
