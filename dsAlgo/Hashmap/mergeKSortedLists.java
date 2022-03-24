import java.io.*;
import java.util.*;

public class mergeKSortedLists {
    public static class Pair implements Comparable<Pair> {
        int i;
        int j;
        int val;
        Pair(){}
        Pair(int i, int j, int val) {
            this.i = i;
            this.j = j;
            this.val = val;
        }
        
        @Override
        public int compareTo(Pair other) {
            return this.val - other.val;
        }
    }
   public static ArrayList<Integer> mergeKSortedLists(ArrayList<ArrayList<Integer>> lists){
      ArrayList<Integer> rv = new ArrayList<>();
      // write your code here
      PriorityQueue<Pair> pq = new PriorityQueue<>();
      for(int i=0;i<lists.size();i++ ) {
          pq.add(new Pair(i, 0, lists.get(i).get(0)));
      }
      
      while(pq.size()>0) {
          Pair least = pq.remove();
          int i = least.i;
          int j = least.j;
          int val = least.val;
          rv.add(val);
          j++;
          if(lists.get(i).size()>j) {
            pq.add(new Pair(i, j, lists.get(i).get(j)));
          }
      }
      
      return rv;
   }

   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int k = Integer.parseInt(br.readLine());
      ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
      for(int i = 0; i < k; i++){
         ArrayList<Integer> list = new ArrayList<>();

         int n = Integer.parseInt(br.readLine());
         String[] elements = br.readLine().split(" ");
         for(int j = 0; j < n; j++){
            list.add(Integer.parseInt(elements[j]));
         }

         lists.add(list);
      }

      ArrayList<Integer> mlist = mergeKSortedLists(lists);
      for(int val: mlist){
         System.out.print(val + " ");
      }
      System.out.println();
   }

}