import java.util.*;

class ListNode {
    int val;
    ListNode next;

    ListNode(){}
    ListNode(int val) {
        this.val = val;
        next = null;
    }
}

class Solution {
    /*
    e.g. 1->2->3->4, k=2

    part 1:
    reverse: 1-2
    result: 2->1
            2->1->3->4
    part 2:
    reverse: 3-4
    result: 4->3
            2->1->4>3
     */

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode begin;
        if (head==null || head.next ==null || k==1)
            return head;
        ListNode dummyhead = new ListNode(-1);
        dummyhead.next = head;
        begin = dummyhead;
        int i=0;
        while (head != null){
            i++;
            if (i%k == 0){
                begin = reverse(begin, head.next);  //begin = points to the dummyhead
                head = begin.next;
                dbg("outside level -- begin: " + begin.val +", head: "+ ((head==null) ? -1 : head.val));
            } else {
                head = head.next;
            }
        }
        return dummyhead.next;
        
    }

    public ListNode reverse(ListNode begin, ListNode end){
        ListNode curr = begin.next; //curr = actual initial node of the list
        ListNode next, first;
        ListNode prev = begin;
        first = curr;
        while (curr!=end){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        begin.next = prev;  //point the begin(null, -1) of the previous-list to the last node of the current list. -1->1->2 => -1->2->1 (prev: 2, begin: -1) 
        first.next = curr;  //point the last node of the prev. list to the 1st node of the next list. 2->1 -> 3->4 (curr: 3, first: 1)
        dbg("begin: " + begin.val +", first: "+ first.val);
        return first;
    }

    public static void dbg(String str) {
        System.out.println(str);
    }
}

public class Reverse_in_K_groups {
    
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode newNode = new ListNode(2);
        head.next = newNode;
        newNode.next = new ListNode(3);
        newNode.next.next = new ListNode(4);

        debug(head);
        System.out.println("solution:");

        Solution sol = new Solution();
        ListNode newHead = sol.reverseKGroup(head, 2);

        //check the solution
        System.out.println("Post solution:");
        debug(newHead);
    }

    public static void debug(ListNode head) {
        ListNode temp = head;
        while(temp!=null) {
            System.out.print(temp.val+" ");
            temp = temp.next;
        }
        System.out.println();
    }
}

/*
25. Reverse Nodes in k-Group
Hint: https://leetcode.com/problems/reverse-nodes-in-k-group/discuss/11440/Non-recursive-Java-solution-and-idea

testcases:
Input: head = [1,2,3,4,5], k = 3
Output: [3,2,1,4,5]

Input: head = [1,2,3,4,5], k = 2
Output: [2,1,4,3,5]

Input: head = [1,2,3,4,5,6], k = 3
Output: [3,2,1,6,5,4]
 */