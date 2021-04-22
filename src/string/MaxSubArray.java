package string;

/**
 * 리스트 숫자에서 연속으로 더하여서 가장 큰 수를 구한다.
 *
 * intput :
 *     nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4}
 * output : 6
 *
 * 4-1+2+1 = 6
 */

public class MaxSubArray {
    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int result = new MaxSubArray().maxSubArray_dp(nums);
        System.out.println(result);
    }

    int solve(int[] nums) {
        int newSum = nums[0];
        int max = nums[0];

        for (int i = 1; i < nums.length; i++) {
            newSum = Math.max(newSum + nums[i], nums[i]);
            max = Math.max(max, newSum);
        }
        return max;
    }

    int maxSubArray_dp(int[] A) {
        int n = A.length;
        int[] dp = new int[n];// dp[i] means the maximum subarray ending with A[i];
        dp[0] = A[0];
        int max = dp[0];

        for (int i = 1; i < n; i++) {
            dp[i] = A[i] + (Math.max(dp[i - 1], 0)); // 이전 것이 0보다 크면 더하고 작으면 자신부터 다시 시작
            max = Math.max(max, dp[i]);
        }

        return max;
    }
}
