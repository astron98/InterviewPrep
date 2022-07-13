/*
21. Merge Two Sorted Lists
hints: https://leetcode.com/problems/merge-two-sorted-lists/discuss/9772/java-solution-with-real-world-concerns-real-world-concerns

time: N+M
space: if we delete the nodes after every traversal then its O(1), else O(N+M)
 */
class Solution {

    //method 2: iteration.
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode res = new ListNode();
        ListNode head = res;
        while(list1!=null && list2!=null) {
            if(list1.val <= list2.val) {
                res.next = list1;
                list1 = list1.next;
            }
            else {
                res.next = list2;
                list2 = list2.next;
            }
            
            res = res.next;
        }
        
        
        //lastly only one element could be left over. So add that to result.
        if(list1!=null) {
            res.next = list1;
        }
        
        if(list2!=null) {
            res.next = list2;
        }
        
        return head.next;
    }

    //method 1: recursion
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1==null) return list2;
        if(list2 == null) return list1;

        if(list1.val <= list2.val) {
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        }

        list2.next = mergeTwoLists(list1, list2.next);
        return list2;
    }
}