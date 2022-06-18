import java.util.*;
import java.io.*;

class Solution {
    public int solve(String s) {
        int[] cache = new int[256];
        Arrays.fill(cache, -1);

        int left=0, right = 0;
        int result = 0, n = s.length();

        while(right < n) {
            char ch = s.charAt(right);
            if(cache[ch]!=-1)   //if the value is already found before, increment the left pointer.
                left = Math.max(left, cache[ch]+1);
            
            result = Math.max(result, right - left + 1);
            cache[ch] = right++;    //update the right index in the cache.
        }
        return result;
    }
}

public class Test {
    public static void main(String[] args) throws Exception {
        Solution obj = new Solution();
        Scanner sc = new Scanner(new FileReader("input.txt"));
        int n = sc.nextInt();
        sc.nextLine();
        String[] str = new String[n];

        for(int i=0;i<n;i++) {
            str[i] = sc.nextLine();
            int res=obj.solve(str[i]);
            System.out.println(res);
        }
    }
}

/*
time: N, space: O(1)
method: two pointer & store the previous indexes.

testcase:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.

Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.

Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */