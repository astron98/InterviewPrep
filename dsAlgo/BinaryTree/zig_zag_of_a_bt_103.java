// https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/description/
// time, space: O(N), O(N)

// approach: Level order traversal, with a boolean flag for the traversal direction toggle.

// code
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        if(root==null) return result;
        q.offer(root);
        boolean flag = true;
        while(!q.isEmpty()) {
            int levelSize = q.size();
            List<Integer> levelList = new ArrayList<>(levelSize);
            for(int i=0;i<levelSize;i++) {
                TreeNode top = q.peek();
                if(top.left!=null) q.offer(top.left);
                if(top.right!=null) q.offer(top.right);
                if(flag)
                    levelList.add(q.poll().val);
                else
                    levelList.add(0, q.poll().val);                    
            }
            flag = !flag;
            result.add(levelList);
        }
        return result;
    }
}