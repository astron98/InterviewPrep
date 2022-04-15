import java.util.*;
 
/*
. The gray code is a binary numeral system where two successive numbers differ in only one bit.
2. Given a non-negative integer n representing the total number of bits in the code, print the 
     sequence of gray code. A gray code sequence must begin with 0.

 Example:
 
 Input: 2
 
 Output: [0,1,3,2]
 
 Explanation:
 00 - 0
 01 - 1
 11 - 3
 10 - 2

 [0,2,3,1] is also a valid gray code sequence.
 00 - 0
 10 - 2
 11 - 3
 01 - 1

Sample Input
2

Sample Output
[0, 1, 2, 3]

*/

 public class Main {
     public static ArrayList<String> solution(int n) {   
        if(n<=1) {
            ArrayList<String> rres = new ArrayList<>();
            rres.add("0");
            if(n==0) return rres;
            
            rres.add("1");
            return rres;
        }
        
 	    ArrayList<String> rres = solution(n-1);
 	    ArrayList<String> mres = new ArrayList<>();
 	    for(int i=0;i<rres.size();i++) {
 	        String val = rres.get(i);
 	        mres.add("0" + val);
 	    }
 	    
 	    for(int i=rres.size()-1;i>=0;i--) {
 	        String val = rres.get(i);
 	        mres.add("1" + val);
 	    }
 	    
 	    return mres;
     }
     
     //time: O(n * 2^n), space = O(N)   
     public static List<Integer> grayCode(int n) {
        
 	    List<String> tres = solution(n);
 	    List<Integer> res = new ArrayList<>();
 	    for(String val : tres)
 	        res.add(Integer.parseInt(val, 2));
 	    return res;
     }
 
     public static void main(String[] args) {
         Scanner scn = new Scanner(System.in);
         List<Integer> ans=grayCode(scn.nextInt());
         Collections.sort(ans);
         System.out.println(ans);
     }
 }