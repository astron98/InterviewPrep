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
      snippet.FastReader();

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
      // write your code here
      boolean[] visited = new boolean[vtces];
      dijkstra(src, graph, visited);
      
   }
   
   static class Pair implements Comparable<Pair>{
       int v;
       String psf;
       int weight;
       Pair(int v, String psf, int weight) {
           this.v = v;
           this.psf = psf;
           this.weight = weight;
       }
       
       public int compareTo(Pair other) {
           return this.weight - other.weight;
       }
   }
   
   static void dijkstra(int src, ArrayList<Edge>[] graph, boolean[] visited) {
       PriorityQueue<Pair> pq = new PriorityQueue<>();
       pq.add(new Pair(src, ""+src, 0));
       
       while(pq.size()>0) {
           Pair top = pq.remove();
           if(visited[top.v])
                continue;
            visited[top.v] = true;
            System.out.println(top.v + " via "+top.psf + " @ "+ top.weight);
            for(Edge e: graph[top.v]) {
                if(!visited[e.nbr])
                    pq.add(new Pair(e.nbr, top.psf+e.nbr, top.weight+e.wt));
            }
       }
   }  
}