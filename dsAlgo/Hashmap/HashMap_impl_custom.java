import java.io.*;
import java.util.*;

/*
HashMap implementation:

classes:
HashMap<K, V> {
  HMNode {
    K key;
    V value;
  }

  public HashMap() {
    initbuckets(4);
    size = 0;
  }
}


variables:
int size;
LinkedList<HMNode>[] buckets;

1. write function for put()
2. containsKey() is same as point 1, put()



*/

public class HashMap_impl_custom {

  public static class HashMap<K, V> {
    private class HMNode {
      K key;
      V value;

      HMNode() {}

      HMNode(K key, V value) {
        this.key = key;
        this.value = value;
      }
    }

    private int size; // size = n
    private LinkedList<HMNode>[] buckets; //array of linkedlist

    public HashMap() {
      initbuckets(4);
      size = 0;
    }

    private void initbuckets(int N) {
      buckets = new LinkedList[N];
      for(int i=0; i<buckets.length; i++) {
        buckets[i] = new LinkedList<>();
      }
    }

    private int hashfn(K key) {
      int hashCode = key.hashCode();
      return Math.abs(hashCode) % buckets.length;
    }

    private int getIndexWithinBucket(K key, int bi) {
      int di = 0;
      for(HMNode node : buckets[bi]) {
        if(node.key.equals(key)) 
          return di;  //di = data index
        di++;
      }

      return -1;  //element not found
    }

    private void rehash() throws Exception {
      LinkedList<HMNode>[] oldBuckets = buckets;
      initbuckets(2*size);  //resize the buckets to twice of its previous capacity
      size = 0;

      for(int bi=0; bi<oldBuckets.length; bi++) {
        for(HMNode node : oldBuckets[bi]) 
            put(node.key, node.value);
      }
    }

    public void put(K key, V value) throws Exception {
      int bi = hashfn(key);
      int di = getIndexWithinBucket(key, bi);

      if(di!=-1) {
        //if key exists then update the existing value for the key
        HMNode node = buckets[bi].get(di);
        node.value = value;
      }
      else {
        //when the key isn't present in the hashmap
        HMNode node = new HMNode(key, value);
        buckets[bi].add(node);
        size++; //increment the size of the elements count for the hashmap
      }

      //lambda = average no. of elements per bucket.
      double lambda = size * 1.0 / buckets.length;  
      if(lambda > 2.0) {
        rehash(); //increase the capacity of the hashmap
      }
    }

    public V get(K key) throws Exception {
      int bi = hashfn(key);
      int di = getIndexWithinBucket(key, bi);

      if(di != -1) {
        HMNode node = buckets[bi].get(di);
        return node.value;
      }
      return null;
    }

    public boolean containsKey(K key) {
      int bi = hashfn(key);
      int di = getIndexWithinBucket(key, bi);

      if(di != -1) 
        return true;
      return false;
    }

    public V remove(K key) throws Exception {
      int bi = hashfn(key);
      int di = getIndexWithinBucket(key, bi);

      if(di != -1) {
        HMNode node = buckets[bi].remove(di);
        size--;
        return node.value;
      }
      return null;
    }

    public ArrayList<K> keyset() throws Exception {
      ArrayList<K> keys = new ArrayList<>();
      for(int bi = 0; bi<buckets.length; bi++) {
        for(HMNode node : buckets[bi])
          keys.add(node.key);
      }

      return keys;
    }

    public int size() {
      return size;
    }

    public void display() {
      System.out.println("Display begins");
      for(int bi = 0; bi < buckets.length; bi++) {
        System.out.println("Bucket"+bi+" ");
        for(HMNode node : buckets[bi]) {
          System.out.println(node.key + "@" + node.value + " ");
        }
        System.out.println(".");
      }
      System.out.println("Display ends");
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new FileReader("../input"));
    HashMap<String, Integer> map = new HashMap();

    String str = br.readLine();
    while (str.equals("quit") == false) {
      if (str.startsWith("put")) {
        String[] parts = str.split(" ");
        String key = parts[1];
        Integer val = Integer.parseInt(parts[2]);
        map.put(key, val);
      } else if (str.startsWith("get")) {
        String[] parts = str.split(" ");
        String key = parts[1];
        System.out.println(map.get(key));
      } else if (str.startsWith("containsKey")) {
        String[] parts = str.split(" ");
        String key = parts[1];
        System.out.println(map.containsKey(key));
      } else if (str.startsWith("remove")) {
        String[] parts = str.split(" ");
        String key = parts[1];
        System.out.println(map.remove(key));
      } else if (str.startsWith("size")) {
        System.out.println(map.size());
      } else if (str.startsWith("keyset")) {
        System.out.println(map.keyset());
      } else if (str.startsWith("display")) {
        map.display();
      }
      str = br.readLine();
    }
  }
}