import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[][] color = new int[n][k];
        for(int i=0;i<n;i++) {
            for(int j=0;j<k;j++) {
                color[i][j] = sc.nextInt();
            }
        }
        
        paintHouseOpt(n, k, color);
    }
    
    
    static void paintHouseK(int n, int k, int[][] arr) {
        int[][] t = new int[n][k];
        for(int i=0;i<k;i++)
            t[0][i] = arr[0][i];
            
        for(int i=1;i<n;i++) {
            for(int j=0;j<k;j++) {
                int min=Integer.MAX_VALUE;
                for(int p=0;p<k;p++) {
                    if(p!=j) {
                        min = Math.min(min, t[i-1][p]);
                    }
                }
                
                t[i][j] = arr[i][j]+min;
            }
        }
        int res = Integer.MAX_VALUE;
        for(int i=0;i<k;i++)
            res = Math.min(res, t[n-1][i]);
            
        System.out.println(res);
    }
    
    static void paintHouseOpt(int n, int k, int[][] arr) {
        int[][] t=new int[n][k];
        t[0] = arr[0];
        
        //get min, 2nd-min
            int mn=Integer.MAX_VALUE, secMn = Integer.MAX_VALUE-1;
            for(int p=0;p<k;p++) {
                int val = t[0][p];
                if(val <mn) {
                    secMn = mn;
                    mn = val;
                }
                else if(val < secMn) {
                    secMn = val;
                }
            }
        
        for(int i=1;i<n;i++) {
            int cl = Integer.MAX_VALUE, csl = cl;
            for(int j=0;j<k;j++) {
//if mn=(minColor)== previous row's color then take the 2nd least secMn as the value for currMin
                int currMin = (t[i-1][j]!=mn)? mn : secMn;
                t[i][j] = arr[i][j] + currMin;
                
                if(t[i][j]<cl) {
                    csl = cl;
                    cl = t[i][j];
                }
                else if(t[i][j]<csl)
                    csl = t[i][j];
            }
            
            //update mn & secMn
            mn = cl;
            secMn = csl;
        }
            
        System.out.println(mn);
    }
}