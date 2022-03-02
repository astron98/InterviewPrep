/*
There are n servers numbered from 0 to n - 1 connected by undirected server-to-server connections forming a network 
where connections[i] = [ai, bi] represents a connection between servers ai and bi. Any server can reach other servers 
directly or indirectly through the network.
A critical connection is a connection that, if removed, will make some servers unable to reach some other server.

Return all critical connections in the network in any order.

 

Example 1:


Input: n = 4, connections = [[0,1],[1,2],[2,0],[1,3]]
Output: [[1,3]]
Explanation: [[3,1]] is also accepted.
Example 2:

Input: n = 2, connections = [[0,1]]
Output: [[0,1]]
*/

//note: we don't find here the articulation point instead we find the edge that's why we removed the logic
//for the root not if() condition


class Solution {
    static int time = 0;
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connection) {
        int[] disc = new int[n];
        int[] low = new int[n];
        boolean[] visited = new boolean[n];
        List<List<Integer>> result = new ArrayList<>();
        
        ArrayList<Integer>[] graph = new ArrayList[n];
        for(int i=0;i<n;i++) {
            graph[i] = new ArrayList<>();
        }
        
        for(int i=0;i<connection.size();i++) {
            int u = connection.get(i).get(0);
            int v = connection.get(i).get(1);
            
            graph[u].add(v);
            graph[v].add(u);
        }
        
        for(int v=0;v<n;v++) {
            if(!visited[v])
                dfs(v, disc, low, v-1, visited, result, graph);
        }

        return result;
    }
    
    public void dfs(int u, int[] disc, int[] low, int parent, boolean[] visited, List<List<Integer>> result, ArrayList<Integer>[] graph) {
        disc[u] = low[u] = time++;
        
        int children = 0;
        visited[u] = true;
        
        for(Integer v : graph[u]) {
            if(v == parent)
                continue;
            else if(visited[v])
                low[u] = Math.min( low[u], disc[v] );
            else {
                //when there is an unvisited edge.
                children++;
                dfs(v, disc, low, u, visited, result, graph);
                
                // Check if the subtree rooted with v has
                // a connection to one of the ancestors of u
                low[u] = Math.min(low[u], low[v]);
                
                if (low[v] > disc[u])   //non root node is an articulation point
                    result.add(Arrays.asList(u,v));   
               
            }
        }
        
        // if(parent==-1 && children>1)
        //     ap[u] = true;   //root node is an articulation point
    }
}