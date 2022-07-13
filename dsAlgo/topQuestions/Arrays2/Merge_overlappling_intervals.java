/*
time: O(N*logN) for sorting the array.
space: O(N*2) = O(N)

approach:
- sort the intervals
- iterate via the intervals & check if the current interval can be merged with the immediate next one,
if yes, update the end-val of previous interval.
else, just add the whole interval as a new one in the result array.
 */

 class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b)-> Integer.compare(a[0], b[0]));
        
        LinkedList<int[]> res = new LinkedList<>();
        
        for(int[] interval : intervals) {
            if(res.isEmpty() || res.getLast()[1] < interval[0])
                res.add(interval);
            else
                res.getLast()[1] = Math.max(res.getLast()[1], interval[1]);
        }
        
        return res.toArray(new int[res.size()][]);
    }
}