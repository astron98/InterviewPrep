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
    
    //1. most optimal (most simplified code)
    public ListNode reverseList(ListNode head) {
        if(head==null || head.next==null) return head;
        
        ListNode newHead = reverseList(head.next);
        head.next.next = head;  //put next node's next as current-node.
        head.next = null;
        
        return newHead; //return the new head after reversing the list.
    }
    
    //2. most optimal (more code)
    public ListNode reverseLis1(ListNode head) {
        ListNode prevNode = null;
        while(head!=null) {
            ListNode nextNode = head.next;
            head.next = prevNode;
            prevNode = head;
            head = nextNode;
        }
        return prevNode;
    }
}

public class test1 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode newNode = new ListNode(2);
        head.next = newNode;
        newNode.next = new ListNode(3);
        newNode.next.next = new ListNode(4);

        debug(head);

        Solution sol = new Solution();
        ListNode newHead = sol.reverseList(head);

        //check the solution
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