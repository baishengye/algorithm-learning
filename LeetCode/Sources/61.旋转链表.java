/*
 * @lc app=leetcode.cn id=61 lang=java
 *
 * [61] 旋转链表
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
    public ListNode rotateRight(ListNode head, int k) {
        //特判
        if(head==null) return null;
        
        //计算链表的长度同时找到最后一个节点
        int len=0;
        ListNode end=null;
        for (ListNode p=head; p!=null; p=p.next) {
            len++;
            if(p.next==null){
                end=p;
            }
        }
        k%=len;



        //连接最后一个节点和第一个节点
        end.next=head;

        //断开第len-k个节点连接
        ListNode ans=null;
        int n=len-k;
        ListNode p=head;
        while(p!=null&&n>1){
            p=p.next;
            n--;
        }

        //结果
        ans=p.next;
        p.next=null;

        return ans;
    }
}
// @lc code=end

