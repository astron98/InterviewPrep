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
    /*
    approaches:
    1. reverse the linkedlist & check if both list are same. 
        - time: O(n)
        - 2 times traversal of the list
    
    2. call recursively & check if the 1st node == last node. 
        - extra space: O(N) call stack.
        - 1 time traversal
    
    3. (most optimal) reverse the 2nd half of the list & then compare with 1st half.
        - O(1) space, O(N/2) time
        - 1 time traversal
    */
    
    //sol 3: most optimal
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head, fast = head, prev, temp;
        //1. find the middle node.
        while(fast!=null && fast.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        //2. reverse the 2nd half of the list
        prev = slow;
        slow = slow.next;
        prev.next = null;
        while(slow!=null) {
            temp = slow.next;
            slow.next = prev;
            prev = slow;
            slow = temp;
        }
        
        //3. point fast to last node of the reverse 2nd half-list i.e. 1st node
        slow = head; //slow to 1st node of 1st-half of list
        fast = prev;
        
        //4. test for palindrome
        while(fast!=null) {
            if(slow.val != fast.val) return false;
            slow = slow.next;
            fast = fast.next;
        }
        
        return true;
    }
}