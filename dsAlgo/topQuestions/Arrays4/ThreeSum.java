import java.util.*;
import java.io.*;
/*
3sum - Target Sum Unique Triplet
nums[i] + nums[j] + nums[k] == target.

time: O(N^2)
space: O(1)

testcases:
input
3
1 1 1
3

output: 
1 1 1
___
input:
6
-1 0 1 2 -1 -4
0

output:
-1 -1 2 
-1 0 1 
 */
public class ThreeSum {

  // ~~~~~~~~~~~~User Section~~~~~~~~~~~~
  public static List<List<Integer>> threeSum(int[] nums, int targ) {
    // write your code here
    List<List<Integer>> res = new ArrayList<>();
    int n = nums.length, k = 3;
    if(n<3) return res;
    Arrays.sort(nums);
    
    for(int i=0;i<=n-k; i++) {
        //skip the repeating element to avoid duplicacy
        if(i>0 && nums[i-1]==nums[i]) continue;
        int target = targ - nums[i];
        twoSum(i+1, n-1, target, nums, res);
    }
    
    return res;
  }
  
    public static void twoSum(int lo, int hi, int target, int[] nums, List<List<Integer>> res) {
        int left = lo;
        int right = hi;
        while(left < right) {
            boolean duplicacy = false;
            //if the left element is same as the previous one.
            if(left!= lo && nums[left]==nums[left-1]) {
                left++;
                duplicacy = true;
            }
            //if the right element is same as the next right's one, then skip it to avoid duplicate.
            if(right!= hi && nums[right]==nums[right+1]) {
                right--;
                duplicacy = true;
            }

            if(duplicacy) continue;
            
            int sum = nums[left] + nums[right];
            if(sum < target)
                left++;
            else if(sum > target)
                right--;
            else {
                List<Integer> temp = new ArrayList<>();
                temp.add(nums[lo-1]);
                temp.add(nums[left++]);
                temp.add(nums[right--]);
                res.add(temp);
            }
        }
    }

  // ~~~~~~~~~~Input Management~~~~~~~~~~
  public static void main(String[] args) throws FileNotFoundException {
    Scanner scn = new Scanner(new FileReader("../../input"));
    int n = scn.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = scn.nextInt();
    }
    int target = scn.nextInt();
    List<List<Integer>> res = threeSum(arr, target);
    ArrayList<String> finalResult = new ArrayList<>();
    for (List<Integer> list : res) {
      Collections.sort(list);
      String ans = "";
      for (int val : list) {
        ans += val + " ";
      }
      finalResult.add(ans);
    }
    Collections.sort(finalResult);
    for (String str : finalResult) {
      System.out.println(str);
    }
  }

}