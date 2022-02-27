import java.io.*;
import java.util.*;

public class Kosaraju {
	public static void main(String args[]) throws Exception {
	  BufferedReader br = new BufferedReader(new FileReader("../input"));
		String[] st = br.readLine().split(" ");
		int n = Integer.parseInt(st[0]);
		int m = Integer.parseInt(st[1]);

		ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			graph.add(new ArrayList<>());
		}

		for (int i = 0; i < m; i++) {
			st = br.readLine().split(" ");
			int u = Integer.parseInt(st[0]) - 1;
			int v = Integer.parseInt(st[1]) - 1;
			graph.get(u).add(v);
		}

		System.out.println(kosaraju(graph, n));
	}

	public static int kosaraju(ArrayList<ArrayList<Integer>> graph, int n) {
    boolean[] visited = new boolean[n];
    Stack<Integer> st = new Stack<>();
    
    //step1: do a random dfs
    for(int v=0; v<n; v++)
      if(!visited[v])
        dfs(v, graph, visited, st);

    //step 2: reverse all the edges.
    ArrayList<ArrayList<Integer>> nGraph = new ArrayList<>();
    for(int i=0;i<n;i++)
      nGraph.add(new ArrayList<>());

    for(int i=0;i<n;i++) {
      ArrayList<Integer> nbrs = graph.get(i);
      for(int nbr : nbrs) {
        nGraph.get(nbr).add(i);
      }
    }

    //step 3: again perform dfs on the nGraph with reversed edges.
    int ssc = 0;  //total strongly connected components
    Arrays.fill(visited, false);
    while(!st.isEmpty()) {
      int v = st.pop();
      if(!visited[v]) {
        dfs(v, nGraph, visited, new Stack<>());
        ssc++;
      }  
    }
    
    return ssc;
  }	

  public static void dfs(int src, ArrayList<ArrayList<Integer>> graph, boolean[] visited, Stack<Integer> st) {
    visited[src] = true;

    for(int edge : graph.get(src)) {
      if(!visited[edge])
        dfs(edge, graph, visited, st);
    }

    st.push(src);
  }
}