import java.io.*;
import java.util.*;

/*
Arrange buildings on both side of the road with given spaces & building combinations.
Constraints
0 < n <= 45

Sample Input
6

Sample Output
441
*/
public class Main{
    
    public static long arrangeBuildings(int n) {
        //for road size n=2
        long ending_with_building = 1;  //sb
        long ending_with_space = 2; //bs,ss
        long ifBuilding = 0;
        long ifSpace = 0;
        
        //0 to n will be [1,n] inclusive so, n is not considered         //in the for-loop below 
        for(int i=3; i<=n; i++) {
            ifBuilding = ending_with_space;
            ifSpace = ending_with_space + ending_with_building;
            
            ending_with_space = ifSpace;
            ending_with_building = ifBuilding;
        }
        long result = ending_with_space + ending_with_building;
        result *= result;
        return result;
    }

public static void main(String[] args) throws Exception {
    // write your code here
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    
    System.out.println(arrangeBuildings(n));
}
}