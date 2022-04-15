class Solution {
    List<List<Integer>> result = new ArrayList();
    public List<List<Integer>> subsets(int[] nums) {
        subsetsUtil(nums, new ArrayList<>(), 0);
        return result;
    }

    private void subsetsUtil(int[] nums, ArrayList<Integer> subset, int i) {
//         //method 1
//         if(i>=nums.length) {
//             result.add(new ArrayList(subset));
//             return;
//         }
        
//         method 1
//         include the current element
//         subset.add(nums[i]);
//         subsetsUtil(nums, subset, i+1);

//         //without including current element
//         subset.remove(subset.size()-1);
//         subsetsUtil(nums, subset, i+1);
        
        //method 2
        result.add(new ArrayList(subset)); //add current subset pattern to result.
        for(int idx=i;idx<nums.length;idx++) {
            subset.add(nums[idx]);  //add new number to current subset
            subsetsUtil(nums, subset, idx+1);
            subset.remove(subset.size()-1); //go for next element without picking current element
        }
    }
}