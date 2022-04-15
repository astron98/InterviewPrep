import java.io.*;
import java.util.*;

public class kernighans_algo {

  public static void main(String[] args){
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    
    //write your code here
    int count=0;
    while(n!=0) {
        int rsbm = n & -n;
        n -= rsbm;
        count++;
    }
    
    System.out.println(count);
  }

}