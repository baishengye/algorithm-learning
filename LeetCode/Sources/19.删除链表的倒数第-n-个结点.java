/*
 * @lc app=leetcode.cn id=19 lang=java
 *
 * [19] 删除链表的倒数第 N 个结点
 */

// @lc code=start
/*class ListNode {
   int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}*/
 
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast=head;
        ListNode slow=head;

        while(n>0){
            n--;
            fast=fast.next;
        }

        if(fast==null){//说明倒数第n个点是第一个点
            head=slow.next;
        }else{
            while(fast.next!=null){//最后出来的时候slow.next就是倒数第n个点
                fast=fast.next;
                slow=slow.next;
            }
            slow.next=slow.next.next;
        }

        return head;
    }
}
// @lc code=end

