/*
Detection of cycle in Undirected graph.
1. using BFS
2. using DFS
*/

import java.io.*;
import java.util.*;

public class DetectCycle {
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
      BufferedReader br = new BufferedReader(new FileReader("../input"));

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

      // write your code here
      boolean isCyclic = false;
      boolean[] visited = new boolean[vtces];
      for(int v=0;v<vtces; v++) {
          if(!visited[v] && cyclicDfs(v, -1, graph, visited)) {
              isCyclic = true;
              break;
          }
      }
      
      System.out.println(isCyclic);
   }
   
   //1. with BFS
   public static boolean cyclicBfs(int src, ArrayList<Edge>[] graph, boolean[] visited) {
       Queue<Integer> q = new ArrayDeque<>();
       q.add(src);
       
       while(q.size()!=0) {
           int top = q.remove();
           if(visited[top]) {
               //cycle detected
               return true;
           }
           
           visited[top] = true;
           for(Edge e : graph[top]) {
               if(!visited[e.nbr])
                    q.add(e.nbr);
           }
       }
       
       return false;
   } 

   //2. with DFS
   	public static boolean cyclicDfs(int src, int parent, ArrayList<Edge>[] graph, boolean[] visited) {
   		visited[src] = true;

   		for(Edge e : graph[src]) {
   			if(!visited[e.nbr]) {
   				if(cyclicDfs(e.nbr, src, graph, visited))
   					return true;
   			}
   			else if(e.nbr != parent)	
   				return true;	//if the already visited vertex e != parent of src then its a cycle.
   		}

   		return false;
	}
}