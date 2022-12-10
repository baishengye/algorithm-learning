import java.util.List;

/*
 * @lc app=leetcode.cn id=82 lang=java
 *
 * [82] 删除排序链表中的重复元素 II
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

        ListNode dummy=new ListNode(-1);
        dummy.next=head;

        ListNode p=dummy;
        while(p.next!=null){
            ListNode q=p.next.next;//下一段a的开始q
            while(q!=null&&q.val==p.next.val) q=q.next;//找到再下一段b的开始
            if(p.next.next==q){//a这段只有一个元素
                p=p.next;
            }else{
                p.next=q;//a段有重复的数据就直接跳过a段
            }
        }

        return dummy.next;
    }
}
// @lc code=end

