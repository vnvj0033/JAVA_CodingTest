package graph;

/**
 * 재귀호출로 dfs 사용
 * 호출에서 노드가 null이면 + 1 전달
 *  */

public class MaxDepth {

    public static void main(String[] args) {
        MaxDepth maxDepth = new MaxDepth();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.left = new TreeNode(6);

        System.out.println(maxDepth.solve(root));
    }

    int max = 0;

    public int solve(TreeNode root) {
        maxDepth(root);
        return max;
    }

    public int maxDepth(TreeNode root) {

        if (root == null)
            return 0;

        int leftMax = maxDepth(root.left);
        int rightMax = maxDepth(root.right);

        max = Math.max(leftMax + rightMax, max);

        return Math.max(leftMax, rightMax) + 1;

    }

    static private class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int x) {
            this.val = x;
        }
    }
}