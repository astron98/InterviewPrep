class Solution {
    //solution1: Improved Boyer-Moore Voting algorithm
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> result = new ArrayList<>();
        if(nums.length==0) return result;
        
        int first = -1, second = -1, count1 = 0, count2 = 0;
        
        //step1: check for the two numbers with their frequencies (> n/3)
        for(int val : nums) {
            if(first == val)
                count1++;
            else if(second == val)
                count2++;
            else if(count1 == 0) {
                first = val;
                count1 = 1;
            }
            else if(count2 == 0) {
                second = val;
                count2 = 1;
            }
            else {
                //coz, none from both 1st,2nd were equal to current element, so decrease both. 
                count1--;
                count2--;
            }
        }
        
        //step 2: check if first, second has the freq. > n/3
        count1 = 0; count2 = 0;
        for(int val : nums) {
            if(val==first)
                count1++;
            else if(val==second)
                count2++;
        }
        
        //step3: store them in result if valid (> n/3)
        int n = nums.length/3;
        if(count1 > n)
            result.add(first);
        if(count2 > n)
            result.add(second);
        
        return result;
    }
}

/*
leetcode 229. Majority Element II

Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.
- approach:
We are sure that there will be a max of 2 elements which occurs > N/3 times because 
there cannot be any more as the 3rd element will always be less than n/3.

- Steps:
Let, current value be the element present in the array at any index.
take these variables, num1, num2, count1, count2 

- if val == num1, so we increment c1.
- if val == num2, so we increment c2.
- if c1 is 0, put num1 = val.
- if c2 is 0, put num2 = val.
- if the curr val isn't either num1 or num2 then decrease both c1 and c2.

time: O(N)
space: O(1)
 */