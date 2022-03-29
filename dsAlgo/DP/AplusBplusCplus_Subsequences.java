//A+B+C+ Subsequences
import java.io.*;
import java.util.*;

/*
Constraints
0 < str.length <= 10

Sample Input
abcabc

Sample Output
7
*/

public class Main {
    /*
    formula logic:
    a = 2*a + 1;    //a' with or without a & a' itself (aa', a, a')
    ab = 2*ab + a;  //total count of b' with or without ab strings & putting b' behind A strings (abb', ab, a'b', ab', aa'b')
    abc = 2*abc + ab; //total count of c' with or without abc strings & putting c' behind AB strings 
        (abcc')
        (abb'c', abc', a'b'c', ab'c', aa'b'c')
    
    */
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        
        int a = 0;
        int ab = 0;
        int abc = 0;
        
        for(int i=0;i<str.length(); i++) {
            char ch = str.charAt(i);
            
            if(ch == 'a')
                a = 2*a + 1;
            else if(ch=='b')
                ab = 2*ab + a;
            else if(ch=='c')
                abc = 2*abc + ab;
        }
        
        System.out.println(abc);
    }
}