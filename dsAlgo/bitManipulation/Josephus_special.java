import java.io.*;
import java.util.*;

/*
1. You are given an integer N which represents the total number of soldiers standing in a circle 
     having position marked from 1 to N.
2. A cruel king wants to execute them but in a different way.
3. He starts executing soldiers from 1st position and proceeds around the circle in clockwise 
     direction.
4. In each step, every second soldier is executed.
5. The elimination proceeds around the circle (which is becoming smaller and smaller as the 
     executed soldiers are removed), until only the last soldier remains, who is given freedom.
6. You have to find the position of that lucky soldier.

Constraints
1 <= N <= 10^9

Sample Input
4

Sample Output
1
*/

public class Josephus_special {
    private static int powerOf2(int n) {
        int i=1;
        while(i*2 <= n) {
            i *= 2;
        }
        
        return i;
    }
    
  public static int solution(int n){
    //hp2 = n interms of highest power of 2 
    /*
    algorithm:
    1. 2^x + l = n
    2. result = 2*l + 1
    
    e.g. if n=10 (1010) for base 2
    so from msb to lsb for every bit:
    1. 0 indicates in the next iteration all numbers at 2nd     bit = 1 will gets killed
    2. 1 at 2nd bit indicates all nos. with 0 as 3rd bit will get killed.
    3. so on for subsequent bits till end.
    */
    int hp2 = powerOf2(n);  //powerOf2 value is <= n
    int l = n - hp2;
    return 2*l + 1;
    
  }
  public static void main(String[] args){
    Scanner scn = new Scanner(new FileReader("../input"));
    int n = scn.nextInt();
    System.out.println(solution(n));
  }
}