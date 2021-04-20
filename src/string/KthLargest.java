package string;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 배열에서 k번째 큰수를 찾는다.
 * input :
 *     nums = {3, 2, 1, 5, 6, 4}
 *     k = 2
 *
 * output : 5
 *
 * 정렬을 이용한다.
 * */

public class KthLargest {
    public static void main(String[] args) {

        int[] nums = {3, 2, 1, 5, 6, 4};
        int k = 2;

        int result = new KthLargest().solve(nums, k);
        System.out.println(result);
    }

    public int solve(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);
        return nums[n - k];
    }

    public int solve_pq(int[] nums, int k) {
        Queue<Integer> pq = new PriorityQueue<>((a, b) -> a - b);

        for (int val : nums) {
            pq.offer(val);
            if (pq.size() > k)
                pq.poll();
        }
        return pq.peek();
    }
}
