/*
2. Add Two Numbers
hint: https://leetcode.com/problems/add-two-numbers/discuss/1835535/JavaC%2B%2B-A-very-beautiful-explanation-EVER-exists

testcases:
1. [2,4,3]
[5,6,4]
output: [7, 0, 8] => actual result: 807

Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
Output: [8,9,9,9,0,0,0,1]

3. 
Input: l1 = [0], l2 = [0]
Output: [0]
*/

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //numbers are added to list in reverse order.
        ListNode result = new ListNode();
        ListNode head = result;
        int carry = 0;
        while(l1!=null && l2!=null) {
            int sum = l1.val+l2.val + carry;
            carry = sum/10;
            sum %= 10;
            result.next = new ListNode(sum);
            
            result = result.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        
        while(l1!=null) {
            int sum = l1.val + carry;
            carry = sum/10;
            sum %= 10;
            result.next = new ListNode(sum);
            
            result = result.next;
            l1 = l1.next;
        }
        
        while(l2!=null) {
            int sum = l2.val + carry;
            carry = sum/10;
            sum %= 10;
            result.next = new ListNode(sum);
            
            result = result.next;
            l2 = l2.next;
        }
        
        if(carry>0) {
            result.next = new ListNode(carry);  //add the extra carry after MSB.
        }
        
        return head.next;
    }
}