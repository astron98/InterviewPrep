// 287. Find the Duplicate Number

class Solution {
    public int findDuplicate(int[] nums) {
        //method 1: flag alternate numbers with -1 to get the duplicate one.
        //method 2: use bit manipulation to get result
        //method 3:floyd's algo (Hare, Tortoise technique)
        
        int fast=0, slow = 0;
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while(slow!=fast);
        
        int slow2 = 0;
        do {
            slow2 = nums[slow2];
            slow = nums[slow];
        } while(slow != slow2);
        
        return slow;
    }
}