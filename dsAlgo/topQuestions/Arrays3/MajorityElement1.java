class Solution { 
    public int majorityElement(int[] nums) {
        int candidate = 0;
        int count = 0;
        
        for(int val : nums) {
            if(count==0)
                candidate = val;
            count += (val == candidate)? 1 : -1; 
        }
        
        return candidate;
    }
}

/*
leetcode: 169 (> n/2 times)

Given an array nums of size n, return the majority element.
The majority element is the element that appears more than ⌊n / 2⌋ times. 

Solution: Boyer-Moore Voting algorithm
If we had some way of counting instances of the majority element as +1+1 and instances 
of any other element as -1−1, summing them would make it obvious that the majority element 
is indeed the majority element.

time: O(N)
space: O(1)
*/