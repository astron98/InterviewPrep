import java.util.*;
import java.io.*;

class Solution {
    public int solve(int[] arr, int k) {
     HashMap<Integer,Integer> visited = new HashMap<Integer,Integer>(); 
        int res = 0;
        int prefixXor = 0;
        int n = arr.length;
        for(int i=0;i<n;i++) {
            prefixXor ^= arr[i];
            if(visited.containsKey(prefixXor ^ k))
                res += visited.get(prefixXor ^ k);
            
            if(prefixXor == k)
                res++;
            
            if(visited.containsKey(prefixXor))
                visited.put(prefixXor, visited.get(prefixXor)+1);
            else
                visited.put(prefixXor, 1);
        }

        return res; 
    }
}

public class count_subarrays_with_xor_k {
    public static void main(String[] args) {
        Solution obj = new Solution();
		int[] A = new int[]{4,2,2,6,4};
		int countTotal=obj.solve(A,6);
		System.out.println(countTotal);
    }
}

/*
time: N
space: N (for the prefix sum)

testcase:
1. [4,2,2,6,4], K = 6, res = 4
2. [5, 6, 7, 8, 9], K = 5, res = 2
 */