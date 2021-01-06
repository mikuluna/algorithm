package com.luna.algorithm.listnode;
//23. 合并K个升序链表
//        给你一个链表数组，每个链表都已经按升序排列。
//
//        请你将所有链表合并到一个升序链表中，返回合并后的链表。
//
//         
//
//        示例 1：
//
//        输入：lists = [[1,4,5],[1,3,4],[2,6]]
//        输出：[1,1,2,3,4,4,5,6]
//        解释：链表数组如下：
//        [
//        1->4->5,
//        1->3->4,
//        2->6
//        ]
//        将它们合并到一个有序链表中得到。
//        1->1->2->3->4->4->5->6
//        示例 2：
//
//        输入：lists = []
//        输出：[]
//        示例 3：
//
//        输入：lists = [[]]
//        输出：[]
//         
//
//        提示：
//
//        k == lists.length
//        0 <= k <= 10^4
//        0 <= lists[i].length <= 500
//        -10^4 <= lists[i][j] <= 10^4
//        lists[i] 按 升序 排列
//        lists[i].length 的总和不超过 10^4

import com.luna.algorithm.common.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKLists {

    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0){
            return null;
        }
        ListNode result = new ListNode(0);
        ListNode index = result;
        PriorityQueue<ListNode> queue = new PriorityQueue<>(Comparator.comparingInt(item -> item.val));
        for(ListNode item:lists){
            if(item != null){
                queue.add(item);
            }
        }
        while(!queue.isEmpty()){
            ListNode next = queue.poll();
            index.next = next;
            index = next;
            if(next.next != null){
                queue.add(next.next);
            }
        }
        return result.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.add(4).add(5);
        ListNode l2 = new ListNode(1);
        l2.add(3).add(4);
        ListNode l3 = new ListNode(2);
        l3.add(6);
        ListNode[] lists = new ListNode[]{l1,l2,l3};
        MergeKLists m = new MergeKLists();
        ListNode res = m.mergeKLists(lists);
        res.print();
    }

    public ListNode mergeKLists1(ListNode[] lists) {
        if(lists.length == 0 ){
            return null;
        }
        ListNode res = new ListNode(0);
        ListNode current = res;
        PriorityQueue<ListNode> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));
        for(ListNode item : lists){
            if(item == null){
                continue;
            }
            pq.add(item);
        }
        while(!pq.isEmpty()){
            ListNode nextNode = pq.poll();
            current.next = nextNode;
            current = nextNode;
            if(nextNode.next != null){
                pq.add(nextNode.next);
            }
        }
        return res.next;
    }
}
