class Solution {
    public boolean searchMatrix(int[][] arr, int target) {
        int lo = 0;
		int n = arr.length;
		int m = arr[0].length;
		int hi = (n*m) -1;

		while(lo <= hi) {
			int mid = lo + (hi - lo)/2;
			if(arr[mid/m][mid%m] < target)
				lo = mid +1;
			else if(arr[mid/m][mid%m] > target)
				hi = mid - 1;
			else
				return true;
		}

		return false;
    }
}