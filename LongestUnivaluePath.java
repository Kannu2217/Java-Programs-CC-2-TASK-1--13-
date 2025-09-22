import java.util.*;
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
public class LongestUnivaluePath {
    int maxPath = 0;
    public int longestUnivaluePath(TreeNode root) {
        helper(root, -1);
        return maxPath;
    }
    private int helper(TreeNode node, int parentVal) {
        if (node == null) return 0;
        int left = helper(node.left, node.val);
        int right = helper(node.right, node.val);
        maxPath = Math.max(maxPath, left + right);
        if (node.val == parentVal) {
            return Math.max(left, right) + 1;
        } else {
            return 0;
        }
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(3);
        LongestUnivaluePath solution = new LongestUnivaluePath();
        System.out.println("Longest Univalue Path: " + solution.longestUnivaluePath(root)); 
    }
}

