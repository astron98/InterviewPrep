// https://leetcode.com/problems/same-tree/description/
// time: O(N), space: O(H)

// approach: postorder traversal (euler path traversal)

// code
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p==null && q == null) return true;
        if (p==null || q==null) return false;
        boolean left = isSameTree(p.left, q.left);
        boolean right = isSameTree(p.right, q.right);
        return p.val == q.val && left && right;
    }
}