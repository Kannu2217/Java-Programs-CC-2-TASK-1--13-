import java.util.*;
class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int item) {
        val = item;
        left = right = null;
    }
}
public class CountBinaryTreePaths {
    public static int countPaths(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        int leftPaths = countPaths(root.left);
        int rightPaths = countPaths(root.right);
        return leftPaths + rightPaths;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        System.out.println("Number of paths from root to leaf: " + countPaths(root)); 
    }
}

