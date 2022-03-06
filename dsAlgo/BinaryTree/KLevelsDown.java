 public static void printKLevelsDown(Node node, int k){
    // write your code here
    Queue<Pair> q = new ArrayDeque<>();
    q.add(new Pair(node, 0));
    int level = 0;
    while(q.size()>0) {
        Pair top = q.remove();
        if(level!=top.state) {
            level++;
        }
        
        if(level==k)
            System.out.println(top.node.data);
        
        if(top.node.left!=null)
            q.add(new Pair(top.node.left, top.state+1));
            
        if(top.node.right!=null)
            q.add(new Pair(top.node.right, top.state+1));
    }
  }