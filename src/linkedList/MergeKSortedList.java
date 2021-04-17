package linkedList;

import java.util.PriorityQueue;
import java.util.Queue;

public class MergeKSortedList {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(5);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        ListNode l3 = new ListNode(2);
        l3.next = new ListNode(6);

        ListNode[] list = new ListNode[3];
        list[0] = l1;
        list[1] = l2;
        list[2] = l3;

        ListNode result = new MergeKSortedList().solve(list);

        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }

    public ListNode solve(ListNode[] lists) {

        Queue<ListNode> queue = new PriorityQueue<>();

        ListNode newHead = new ListNode(0);
        ListNode p = newHead;

        for (ListNode node : lists)
            if (node != null) queue.offer(node);

        while (!queue.isEmpty()) {
            ListNode node = queue.poll();
            System.out.print(node.val + "\t");
            p.next = node;
            p = p.next;
            if (node.next != null) queue.offer(node.next);
        }

        return newHead.next;
    }

    private static class ListNode implements Comparable<ListNode> {
        int val;
        ListNode next;

        ListNode(int x) {
            this.val = x;
        }

        @Override
        public int compareTo(ListNode o) {
            return this.val - o.val;
        }
    }
}