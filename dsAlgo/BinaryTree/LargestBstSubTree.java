/*
e.g. the below tree isn't a BST. i.e. for the node 51 as well as for 77
but for method 2 its successful saying 25 is the largest bst subtree
but its actually not, for its subnode 51. So method 2 fails there.

23
50 25 12 n n 37 30 n n 51 n n 75 62 60 n n 77 n n 87 n n



notes:
Add all the driver classes & main code. I've just added the core function of this problem.
*/



//method 1: one which I implemented
static class BstPair {
      int count;
      boolean isBst;
      BstPair(){
          count = 0;
          isBst = true;
      }
      
      BstPair(int count, boolean isBst){
          this.count = count;
          this.isBst = isBst;
      }
  }
  static int lstCount = -1;
  static int lstNode = -1;
  public static BstPair largestBstSubTree(Node node, int low, int high) {
      if(node==null) return new BstPair();
     
      if(node.data<low || node.data > high) {
        return new BstPair(0, false);  
      }
      
      BstPair lp = largestBstSubTree(node.left, low, node.data);
      BstPair rp = largestBstSubTree(node.right, node.data, high);
      int total = lp.count+rp.count+1;
      //the node is bst.
      if(lp.isBst && rp.isBst) {
          if(total>lstCount) {
              lstNode = node.data;
              lstCount = total;
          }
          return new BstPair(total, true);
      }
      
      return new BstPair(total, false);
  }

 //method 2: from Pepcoding
  static class BstPair {
      boolean isBst = true;
      int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE, size = 0;
      Node root = null;
    }
    
    public static BstPair largestSubBst(Node node) {
        BstPair bp = new BstPair();
        
        if(node == null){
            return bp;    
        }    
        
        BstPair lp = largestSubBst(node.left);
        BstPair rp = largestSubBst(node.right);
        
        bp.isBst = lp.isBst && rp.isBst && node.data>lp.max && node.data<rp.min;
        
        bp.min = Math.min(node.data, Math.min(lp.min, rp.min));
        bp.max = Math.max(node.data, Math.max(lp.max, rp.max));
        
        if(bp.isBst) {
            bp.root = node;
            bp.size = lp.size + rp.size + 1;
        }
        else if(lp.size > rp.size) {
            bp.root = lp.root;
            bp.size = lp.size;
        }
        else {
            bp.root = rp.root;
            bp.size = rp.size;
        }
        
        return bp;
    }