import java.io.*;
import java.util.*;

public class Main {
   static class Edge {
      int src;
      int nbr;
      int wt;

      Edge(int src, int nbr, int wt) {
         this.src = src;
         this.nbr = nbr;
         this.wt = wt;
      }
   }

   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      int vtces = Integer.parseInt(br.readLine());
      ArrayList<Edge>[] graph = new ArrayList[vtces];
      for (int i = 0; i < vtces; i++) {
         graph[i] = new ArrayList<>();
      }

      int edges = Integer.parseInt(br.readLine());
      for (int i = 0; i < edges; i++) {
         String[] parts = br.readLine().split(" ");
         int v1 = Integer.parseInt(parts[0]);
         int v2 = Integer.parseInt(parts[1]);
         int wt = Integer.parseInt(parts[2]);
         graph[v1].add(new Edge(v1, v2, wt));
         graph[v2].add(new Edge(v2, v1, wt));
      }

      int src = Integer.parseInt(br.readLine());

      // write all your codes here
      boolean[] visited = new boolean[vtces];
      hamiltonian(src, src+"", 1, src, graph, visited);
   }
   
   static void hamiltonian(int src, String psf, int count, int origSrc, ArrayList<Edge>[] graph, boolean[] visited) {
       
       visited[src] = true;
       for(Edge e : graph[src]) {
           if(!visited[e.nbr]) {
               hamiltonian(e.nbr, psf + e.nbr, count+1, origSrc, graph, visited);
           }
           else if(e.nbr== origSrc && count==visited.length) { //node is already visited & the count of totalNodes till now = total vertices
               //graph has a hamiltonian cycle
               System.out.println(psf+"*");
               visited[src] = false;
               return;
           }
       }
       
       visited[src] = false;
       
       if(count==visited.length) {
           System.out.println(psf+".");
       }
   }
   
   
   
   


}