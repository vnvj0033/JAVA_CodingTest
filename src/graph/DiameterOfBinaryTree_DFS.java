package graph;

import java.util.Stack;

public class DiameterOfBinaryTree_DFS {

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);
        node.left.left = new TreeNode(4);
        node.left.right = new TreeNode(5);

        System.out.println(new DiameterOfBinaryTree_DFS().dfs(node));
    }

    public int dfs(TreeNode root) {

        if (root == null)
            return 0;

        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> value = new Stack<>();
        stack.push(root);
        value.push(1);

        int max = 0;

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            int count = value.pop();
            max = Math.max(max, count);

            if (node.left != null) {
                stack.push(node.left);
                value.push(count + 1);
            }

            if (node.right != null) {
                stack.push(node.right);
                value.push(count + 1);
            }
        }
        return max;
    }

    static private class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int x) {
            this.val = x;
        }
    }

}