import java.util.List;

/*
 * @lc app=leetcode.cn id=25 lang=java
 *
 * [25] K 个一组翻转链表
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
/**
 * 两步:
 * 1. 先将一组里的指针反向
 * 2. 在改变指向首尾的指针
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy=new ListNode(-1);
        dummy.next=head;

        for(ListNode p=dummy;;){//p是一组第一个节点的前一个节点
            ListNode q=p;//q是一组的最后一个节点,测试有没有k个节点
            for(int i=0;i<k&&q!=null;i++) q=q.next;

            if(q==null) break;//如果这一组没有k个就不换位置

            ListNode a=p.next,b=a.next;
            //a最后指向一组的最后一个节点
            //b最后指向一组的最后一个节点后一个节点
            for (int i = 0; i < k-1; i++) {
                ListNode c=b.next;
                b.next=a;
                a=b;
                b=c;
            }

            ListNode c=p.next;//c是一组的第一个节点
            c.next=b;
            p.next=a;
            p=c;//p指向下一组第一个节点的前一个节点
        }
        return dummy.next;
    }
}
// @lc code=end

