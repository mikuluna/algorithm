package com.luna.algorithm.common;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }
    public ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    public ListNode add(int num){
        ListNode next = new ListNode(num);
        this.next = next;
        return next;
    }

    public void print(){
        ListNode printList = this;
        System.out.println("listNode"+this.toString());
        while(printList != null){
            System.out.print(printList.val);
            printList = printList.next;
        }
        System.out.println();
    }

}
