/*
TC: O(V+E)
SC: O(V)
*/


import java.util.*;
import java.io.*;

class ArticulationPoint {
  static int time = 0;

  //DFS through the entire graph
  private static void AP_Bridges(ArrayList<ArrayList<Integer>> graph, int[] disc, int[] low, int[] parent,
                                 boolean[] Apoint, boolean[] vis, int src) {
            // write your code here

    disc[src] = low[src] = time++;
    int count = 0;

    vis[src] = true;
    
    ArrayList<Integer> nbrs = graph.get(src);
    for(int i=0; i<nbrs.size(); i++) {
      int nbr = nbrs.get(i);

      if( parent[src] == nbr)
        continue;
      else if(vis[nbr] == true)
        low[src] = Math.min(low[src], disc[nbr]);
      else {
        //when there is a an unvisited edge
        parent[nbr] = src;
        count++;
        AP_Bridges(graph, disc, low, parent, Apoint, vis, nbr); //DFS thru that nbr vertex

        low[src] = Math.min(low[src], low[nbr]);
        if(parent[src]==-1) {
          //if its a root node
          if(count>=2)
            Apoint[src] = true;
        }
        else {
          if(low[nbr] >= disc[src])
            Apoint[src] = true;
        }
      }
    }
  }

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    Scanner scn = new Scanner(System.in);


    int v = scn.nextInt();
    int e = scn.nextInt();
    ArrayList<ArrayList<Integer>> g = new ArrayList<>();
    for (int i = 0; i < v; i++) {
      g.add(new ArrayList<>());
    }
    for (int i = 0; i < e; i++) {
      int v1 = scn.nextInt();
      int v2 = scn.nextInt();
      g.get(v1 - 1).add(v2 - 1);
      g.get(v2 - 1).add(v1 - 1);
    }

    boolean A_point[] = new boolean[v];
    int[] parent = new int[v];
    parent[0] = -1;
    AP_Bridges(g, new int[v], new int[v], parent, A_point, new boolean[v], 0);
    int count = 0;
    for (int i = 0; i < v; i++) {
      if (A_point[i]) {
        count++;
      }
    }
    System.out.println(count);



  }
}