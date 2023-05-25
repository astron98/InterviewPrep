// time: O(N)
// space: O(1)
// https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/description/

// approach:

// use postorder traversal

// code
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if(left == null)
            return right;
        else if(right == null)
            return left;
        else 
            return root;
    }
}