import java.util.*;
import java.io.*;

/*
time: O(N^3)
space: O(K), K = K sum, here its 4Sum

Sample Input
6
1 0 -1 0 -2 2
0

Sample Output
-1 0 0 1 
-2 -1 1 2 
-2 0 0 2 
*/

public class FourSum {

  public static List<List<Integer>> fourSum(int[] nums, int target) {
    // write your code here
    int n = nums.length,
        k = 4;
    List<List<Integer>> res = new ArrayList<>();
    if(n<4) return res;
    
    Arrays.sort(nums);
    
    for(int i=0;i<=n-k; i++) {
        List<Integer> tmpRes = new ArrayList<>();
        if(i!=0 && nums[i]==nums[i-1]) continue;
        tmpRes.add(nums[i]);
        int target1 = target - nums[i];
        for(int j=i+1; j<=n-k+1; j++) {
            if(j!=i+1 && nums[j]==nums[j-1]) continue;
            int target2 = target1 - nums[j];
            
            tmpRes.add(nums[j]);
            twoSum(j+1, n-1, target2, nums, res, tmpRes);
            tmpRes.remove(1);   //clear 2nd element
        }
    }
    
    return res;
  }
  
  private static void twoSum(int lo, int hi, int target, int[] nums, List<List<Integer>> res, List<Integer> tmpRes) {
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
            List<Integer> subRes = new ArrayList<>(tmpRes);
            subRes.add(nums[left++]);
            subRes.add(nums[right--]);
            res.add(subRes);
        }
    }
  }

  public static void main(String[] args) throws FileNotFoundException {
    Scanner scn = new Scanner(new FileReader("../../input"));
    int n = scn.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = scn.nextInt();
    }
    int target = scn.nextInt();
    List<List<Integer>> res = fourSum(arr, target);
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

    scn.close();
  }
}