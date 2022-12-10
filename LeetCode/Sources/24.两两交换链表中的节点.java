/*
 * @lc app=leetcode.cn id=24 lang=java
 *
 * [24] 两两交换链表中的节点
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
    public ListNode swapPairs(ListNode head) {
        ListNode dummy=new ListNode(-1);
        dummy.next=head;

        for(ListNode p=dummy;p.next!=null&&p.next.next!=null;){
            ListNode a=p.next,b=a.next;//获取到相邻的两个点
            
            p.next=b;
            a.next=b.next;
            b.next=a;
            p=a;
        }

        return dummy.next;
    }
}
// @lc code=end

