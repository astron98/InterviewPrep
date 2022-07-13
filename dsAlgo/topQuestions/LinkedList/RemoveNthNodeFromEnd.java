/*
19. Remove Nth Node From End of List
sol: https://leetcode.com/problems/remove-nth-node-from-end-of-list/discuss/1164542/JS-Python-Java-C%2B%2B-or-Easy-Two-Pointer-Solution-w-Explanation

testcases:

1. edge case, here below the removal node is the first node of the list.
[1,2]
2
output: [2]

2.
[1]
1
output []

3.
[1,2]
1
output [1]

 */

 class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head;
        ListNode slow = head;
        ListNode origHead = head;
        for(int i=1;i<=n;i++)
            fast = fast.next;
        
        //when n==length of list, then return head.next, because in this case the removal node will be the first node.
        if(fast==null)
            return head.next;
        
        while(fast.next!=null) {
            fast = fast.next;
            slow = slow.next;
        }
        
        slow.next = slow.next.next;
        
        return origHead;
    }
}