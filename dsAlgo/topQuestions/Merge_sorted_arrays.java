class Solution {
    private void swap(int[] arr1, int i, int j) {
        int temp = arr1[i];
        arr1[i] = arr1[j];
        arr1[j] = temp;
    }
    
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        //sol1(nums1, m, nums2, n);
        
        
        
        //method 2: (gap method) O(N*logN) time, O(1) space
        int i=0, gap = (int) Math.ceil((double)(m+n)/2.0);
        int j = gap;
        
        for(i=m;i<nums1.length;i++) {
            nums1[i] = nums2[i-m];
        }
        
        if(n==0) return;
        
        while(gap>0) {
            i=0; j = gap;
            while(j< (n+m)) {
                if(nums1[i]> nums1[j])
                    swap(nums1, i, j);
                i++;
                j++;
            }
            
            if(gap==1)
                gap = 0;
            else 
                gap = (int)Math.ceil(gap/2.0);
        }
    }
    
    //method 1:  space: O(N), time: O(n+m)
    private void sol1(int[] nums1, int m, int[] nums2, int n) {
        int i=0, j=0;
        int[] res = new int[nums1.length];
        int k = 0;
        while(i!=m && j!=n) {
            int num1 = nums1[i];
            int num2 = nums2[j];
            
            if(num1 <= num2) {
                res[k] = num1; i++;
            }
            else if(num1>num2) {
                res[k] = num2; j++;
            }
            
            k++;
        }
        
        while(i<m) {
            res[k] = nums1[i];
            i++; k++;
        }
        while(j<n) {
            res[k] = nums2[j];
            j++; k++;
        }
        
        
        for(i=0;i<nums1.length;i++)
            nums1[i] = res[i];
    }
}