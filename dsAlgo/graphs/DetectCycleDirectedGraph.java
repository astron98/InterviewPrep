/*
TC: o(n+e)
sc: O(2N)
auxiliary sc: O(N)

Detection of cycle in directed graph.
1. using BFS
2. using DFS

testcase:
9
10
1 2 1
2 3 1
3 4 1
4 5 1
3 6 1
6 5 1
7 8 1
8 9 1
9 7 1
7 2 1
*/

import java.io.*;
import java.util.*;

public class DetectCycleDirectedGraph {
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
         int v1 = Integer.parseInt(parts[0])-1;
         int v2 = Integer.parseInt(parts[1])-1;
         int wt = Integer.parseInt(parts[2]);
         graph[v1].add(new Edge(v1, v2, wt));	//directed graph
      }

      // write your code here
      boolean isCyclic = false;
      boolean[] visited = new boolean[vtces];
      boolean[] dfsVis = new boolean[vtces];
      for(int v=0;v<vtces; v++) {
          if(!visited[v]) {
          	if(cyclicDfs(v, graph, visited, dfsVis)) {
              isCyclic = true;
              break;
          	}
          }
      }
      
      System.out.println(isCyclic);
   }
   
    //2. with DFS
    public static boolean cyclicDfs(int src, ArrayList<Edge>[] graph, boolean[] visited, boolean[] dfsVis) {
    	visited[src] = true;
    	dfsVis[src] = true;

    	for(Edge e : graph[src]) {
    		if(!visited[src]) {
    			if(cyclicDfs(e.nbr, graph, visited, dfsVis))
    				return true;
    		}
    		else if(dfsVis[src]) //when both visited[v]=true && dfsVis[v]=true then its a cycle.
    			return true;
    	}

    	dfsVis[src] = false;	
    	return false;
    }
   
}