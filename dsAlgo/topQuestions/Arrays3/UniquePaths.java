/*
62. Unique Paths

time: O(N*M) maze traversal, space: O(N*M)

testcases:

Input: m = 3, n = 7
Output: 28

Input: m = 3, n = 2
Output: 3
 */

 class Solution {
    public int uniquePaths(int m, int n) {
        
        boolean[][] visited = new boolean[m][n];
        int[][] dp = new int[m][n];
        for(int i=0;i<m;i++)
            Arrays.fill(dp[i], -1);
        return uniquePathsUtil(0, 0, visited, dp);
    }
    
    private int uniquePathsUtil(int r, int c, boolean[][] visited, int[][] dp) {
        int m = dp.length, n = dp[0].length;
        if(r==m-1 && c==n-1)
            return 1;
        if(r>=m || c>=n)
            return 0;
        
        if(dp[r][c]!=-1) return dp[r][c];

        dp[r][c] = uniquePathsUtil(r+1, c, visited, dp) 
                   + uniquePathsUtil(r, c+1, visited, dp);
        
        return dp[r][c];
    }
}