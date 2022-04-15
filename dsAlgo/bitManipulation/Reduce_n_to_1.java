import java.io.*;
import java.util.*;

/*
. You have to find the minimum number of operations required to convert N into 1.
3. Operations allowed :
     (i)  If n is even, you have to replace n with n/2.
     (ii) If n is odd, you can replace n with either n-1 or n+1.


Constraints
1 <= N <= 2147483647

Sample Input
8

Sample Output
3
*/

public class Main {

    public static int solution(int N) {
        //write your code here
        long n = (long)N;
        int res = 0;
        while(n!=1) {
            if((n%2)==0)
                n /= 2;
            else if(n==3 || (n&3)==1)
                n -= 1;
            else if((n&3)==3)
                n += 1;
                
            
            res++;
        }   
        
        return res;
    }
    
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
        System.out.println(solution(n));
    }
	
	
}