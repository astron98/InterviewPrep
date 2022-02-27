import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String[] st=br.readLine().split(" ");
        
        int n=Integer.parseInt(st[0]);
        int m=Integer.parseInt(st[1]);
        
        int[][] arr=new int[m][3];
        
        for(int i=0;i<m;i++)
        {
            st=br.readLine().split(" ");
            arr[i][0]=Integer.parseInt(st[0])-1;
            arr[i][1]=Integer.parseInt(st[1])-1;
            arr[i][2]=Integer.parseInt(st[2]);
        }

        int[] path = new int[n];
        Arrays.fill(path, Integer.MAX_VALUE);   //create an array of distances with +Infinity values from source vertex.
        path[0] = 0;    //source vertex is at 0 dist. from itself

        //do V-1 operations to get shortest path from root to all nodes.
        for(int i=0; i<n-1; i++) {  
            for(int j=0; j<m; j++) {    //traverse all the edges.
                int u = arr[j][0];
                int v = arr[j][1];
                int wt = arr[j][2];
                if(path[u]==Integer.MAX_VALUE) continue;
                if(path[u]+wt < path[v]) {
                    path[v] = path[u] + wt;
                }
            }
        }       

        //shortest path for all the vertices from src node.
        for(int i=1;i<n;i++) {
            if(path[i]!=Integer.MAX_VALUE)
                System.out.print(path[i]+" ");
            else
                System.out.print("1000000000 ");
        }
        
	}
}