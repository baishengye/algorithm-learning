import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/*
 * @lc app=leetcode.cn id=23 lang=java
 *
 * [23] 合并K个升序链表
 */

// @lc code=start
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
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        Queue<ListNode> heap=new PriorityQueue<ListNode>(
            //默认的PriorityQueue并不是保证了整个队列都是有序的，只是保证了队头是最小的）
            new Comparator<ListNode>(){//需要重写堆的排序规则
                @Override
                public int compare(ListNode o1, ListNode o2){
                    return o1.val - o2.val;
                }
            }
        );

        for (ListNode listNode : lists) {
            if(listNode!=null) heap.add(listNode);
        }

        ListNode dummy=new ListNode(-1);
        ListNode tailNode=dummy;
        while(!heap.isEmpty()){
            ListNode t=heap.poll();
            tailNode.next=t;

            tailNode=tailNode.next;
            if(t.next!=null){
                heap.add(t.next);
            }
        }

        return dummy.next;
    }
}
// @lc code=end

