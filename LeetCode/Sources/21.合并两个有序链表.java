/*
 * @lc app=leetcode.cn id=21 lang=java
 *
 * [21] 合并两个有序链表
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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1==null) return list2;
        if(list2==null) return list1;

        ListNode root=null;
        if(list1.val<=list2.val){
            root=list1;
            root.next=mergeTwoLists(list1.next, list2);
        }else{
            root=list2;
            root.next=mergeTwoLists(list1, list2.next);
        }

        return root;
    }
}
// @lc code=end

