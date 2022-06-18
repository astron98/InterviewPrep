/*
237. Delete Node in a Linked List

approach: given as the comments in the solution.
time: O(1), space: O(1)

testcases:

Input: head = [4,5,1,9], node = 5
Output: [4,1,9]
Explanation: You are given the second node with value 5, the linked list should become 4 -> 1 -> 9 after calling your function.

Input: head = [4,5,1,9], node = 1
Output: [4,5,9]
Explanation: You are given the third node with value 1, the linked list should become 4 -> 5 -> 9 after calling your function.

 */

 class Solution {
    /*
    Hint: to bring the next part of the deleted node to the deleted node.
    */
    public void deleteNode(ListNode node) {
        if(node==null) return;
        node.val = node.next.val;   //change the deleted-node value to its next-node.
        node.next = node.next.next; //attach the next chain of the next-node to it to shift the whole further list.
    }
}