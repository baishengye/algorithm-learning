/*
 * @lc app=leetcode.cn id=83 lang=java
 *
 * [83] 删除排序链表中的重复元素
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
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null) return null;

        ListNode cur=head;
        for(ListNode p=head.next;p!=null;p=p.next){
            if(p.val!=cur.val){
                cur.next=p;
                cur=p;
            }
        }
        cur.next=null;

        return head;
    }
}
// @lc code=end

