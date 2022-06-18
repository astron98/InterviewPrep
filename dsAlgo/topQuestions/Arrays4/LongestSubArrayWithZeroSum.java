import java.util.*;

/*
Largest subarray with 0 sum 
https://practice.geeksforgeeks.org/problems/largest-subarray-with-0-sum/1#

approach: prefix sum store, hashmap
1. create a prefixSum, create a hasmap which store the indexes for the prefixSum
2. traverse the array
    - for every element check
        if(prefixSum==0)
            update the result with i+1
        else {
            if(lastIndex is found)
                update the result with i-lastIndex
            else
                add the prefixSum to the hashmap
        }

time: N, space: N

testcases:
N
arr[0...N]

8
6 -2 2 -8 1 7 4 -10
res: 8

6
9 -3 3 -1 6 -5
res: 5

3
1 0 -5
res: 1

5
1 3 -5 6 -2
res: 0
 */
public class LongestSubArrayWithZeroSum
{

    // Returns length of the maximum length subarray with 0 sum
    public static void main(String arg[])
    {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T > 0)
        {
            int n = sc.nextInt();
            int arr[] = new int[n];
            for (int i = 0; i < n; i++)
                arr[i] = sc.nextInt();

            Solution sol = new Solution();
            System.out.println(sol.maxLen(arr, n));
            T--;
        }
    }
}


class Solution
{
    int maxLen(int arr[], int n)
    {
        Map<Integer, Integer> prevIdx = new HashMap<>();
        int res = 0, prefixSum = 0;
        
        for(int i=0;i<n;i++) {
            prefixSum += arr[i];
            Integer lastIdx = prevIdx.get(prefixSum);
            if(prefixSum==0)
                res = Math.max(res, i+1);
            else {
                if(lastIdx != null)
                    res = Math.max(res, i - prevIdx.get(prefixSum));
                else
                    prevIdx.put(prefixSum, i);
            }
        }
        return res;
    }
}