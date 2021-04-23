package graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 트리 높이 구하기
 * */

public class DiameterOfBinaryTree_BFS {

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);
        node.left.left = new TreeNode(4);
        node.left.right = new TreeNode(5);

        System.out.println("val: "+new DiameterOfBinaryTree_BFS().solve(node));
    }

    public int solve(TreeNode root) {

        if (root == null) return 0;

        Queue<TreeNode> queue = new LinkedList<>();
        int count = 0;

        queue.offer(root);

        while (!queue.isEmpty()) {
            for (int i = 0; i < queue.size(); i++) {
                TreeNode node = queue.poll();

                if (node.left != null)
                    queue.offer(node.left);
                if (node.right != null)
                    queue.offer(node.right);
            }
            count++;
        }
        return count;
    }

    static private class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int x) {
            this.val = x;
        }
    }
}