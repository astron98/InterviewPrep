class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> st = new HashSet<>();
        for(int val : nums)
            st.add(val);
        
        int res = 0;
        for(int val : nums) {
            if(st.contains(val-1)) continue;
            int currVal = val, count = 1;
            while(st.contains(++currVal)) {
                count++;
            }
            
            res = Math.max(res, count);
        }
        
        return res;
    }
}

/*
128. Longest Consecutive Sequence

use hashset/hashmap

time: O(N)
space: O(N)

Input: nums = [100,4,200,1,3,2]
Output: 4

Input: nums = [0,3,7,2,5,8,4,6,0,1]
Output: 9
*/