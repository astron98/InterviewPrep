import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] t=new int[n+1];
        Arrays.fill(t, -1);
        t[0] = 0;
        t[1] = 1;
        t[2] = 2;
        for(int i=3;i<=n;i++) {
            // f(n) = f(n-1) + f(n-2)*(n-1)
            t[i] = t[i-1] + t[i-2]*(i-1);
        }
        
        System.out.println(t[n]);
    }

}