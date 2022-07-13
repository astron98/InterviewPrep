/*
493. Reverse Pairs
 */

class Solution {
    public int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length-1);
    }
    
    private int mergeSort(int[] nums, int low, int high) {
        if(low >= high) return 0;
            
        int count = 0;   //count reversePairs arr[i] > 2*arr[j], where i<j
        int mid = low + (high-low)/2;
        count += mergeSort(nums, low, mid);
        count += mergeSort(nums, mid+1, high);
        count += merge(nums, low, mid, high);
        
        return count;
    }
    
    private int merge(int[] arr, int low, int mid, int high) {
        int count = 0;
        int i = low, j = mid+1;
   
        while(i<=mid && j<=high) {
            if(arr[i] > (2* (long)arr[j])) {
                // e.g. left-arr = [1,3,4] right-arr = [1,2]
                count += (mid-i + 1);   //any element greater than that would satisfy the above condition so consider all of them. (mid-i+1)
                j++;
            }
            else
                i++;
        }
        
        ArrayList<Integer> temp = new ArrayList<>();
        
        i=low;
        j = mid+1;
        
        while(i<=mid && j<=high) {
            if(arr[i] <= arr[j])
                temp.add(arr[i++]);
            else
                temp.add(arr[j++]);
        }
        
        while(i<=mid)
            temp.add(arr[i++]);
        
        while(j<=high)
            temp.add(arr[j++]);
        
        for(int k=low;k<=high;k++) {
            arr[k] = temp.get(k-low);
        }
        
        return count;
    }
}

/*
testcases:

Example 1:
Input: nums = [1,3,2,3,1]
Output: 2

Example 2:
Input: nums = [2,4,3,5,1]
Output: 3

approach:
- use merge sort algo. to find all pairs with given condition below:
arr[i] > 2*arr[j], where i<j
 */