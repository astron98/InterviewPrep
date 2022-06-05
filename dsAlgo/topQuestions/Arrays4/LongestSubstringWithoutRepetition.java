// Java program to find the length of the
// longest substring without repeating
// characters
import java.io.*;
import java.util.*;

class LongestSubstringWithoutRepetition{

	//// (non optimal) time:N^2, space: 1
	// public static int longestUniqueSubsttr(String str)
	// {
	// 	int n = str.length();
		
	// 	// Result
	// 	int res = 0;
		
	// 	for(int i = 0; i < n; i++)
	// 	{
			
	// 		// Note : Default values in visited are false
	// 		boolean[] visited = new boolean[256];
			
	// 		for(int j = i; j < n; j++)
	// 		{
				
	// 			// If current character is visited
	// 			// Break the loop
	// 			if (visited[str.charAt(j)] == true)
	// 				break;

	// 			// Else update the result if
	// 			// this window is larger, and mark
	// 			// current character as visited.
	// 			else
	// 			{
	// 				res = Math.max(res, j - i + 1);
	// 				visited[str.charAt(j)] = true;
	// 			}
	// 		}

	// 		// Remove the first character of previous
	// 		// window
	// 		visited[str.charAt(i)] = false;
	// 	}
	// 	return res;
	// }


	//time: O(N), space: O(256) = O(1)
    public static int longestUniqueSubsttr_optimal1(String str) {
    	int[] cache = new int[256];
    	Arrays.fill(cache, -1);	//default with no values or -1
    	int left = 0, right = 0; //two pointers. (sliding window)
    	int n = str.length();
    	int result = 0;
    	while(right < n) {
    		char ch = str.charAt(right);	//check the last-index of RIGHTth character in the window.  
    		if(cache[ch] > -1) //if there is an already char for the RIGHT index.
    			left = Math.max(left, cache[ch]+1);	//update the LEFT index to MAX(right+1, left)
    		cache[ch] = right; //store the latest index of RIGHT th character.
    		result = Math.max(result, right-left+1); //longest substring = length of that window = r-l+1
    		right++; 
    	}

    	return result;
    }

	// Driver code
	public static void main(String[] args) throws Exception
	{
		Scanner sc = new Scanner(new FileReader("../../input"));
		int n = sc.nextInt();
		sc.nextLine();	//to goto nextline after integer input reading.

		for(int i=0;i<n;i++) {
			String str = sc.nextLine();
			System.out.println("The input string is " + str);

			int len = longestUniqueSubsttr_optimal1(str);
			System.out.println("The length of the longest " +
							"non-repeating character " +
							"substring is " + len);
		}
	}
}

/*
3. Longest Substring Without Repeating Characters
//time: O(N), space: O(256) = O(1)

Input:
N
N strings on every line

Output:
Length of the longest substring with no repeating elements.


testcases:

abcabcbb
3

geeksforgeeks
7

bbbbb
1
*/
