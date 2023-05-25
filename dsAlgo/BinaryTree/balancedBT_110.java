// time: O(N), the method visit a node only once
// space: O(H) height of the binary tree
// https://leetcode.com/problems/balanced-binary-tree/description/

// steps:
// Find height of the BT at every level & check if the height difference between left, right subtree is > 1, if yes then its not balanced else it is.

// code
class Solution {

    public boolean isBalanced(TreeNode root) {
        return heightBT(root) != -1;
    }

    private int heightBT(TreeNode root) {
        if(root==null) return 0;

        int left = heightBT(root.left);
        if(left==-1) return -1;
        int right = heightBT(root.right);
        if(right==-1) return -1;

        if(Math.abs(left - right)>1) return -1;
        return Math.max(left, right) + 1;
    }
}