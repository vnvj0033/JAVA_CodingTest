package string;

/**
 * 담장에 물이 차 있을경우 얼마만큼 물이 차있는지
 *
 * input :
 *     nums = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}
 *
 * output : 6
 *
 *        #
 *    #000##0#
 *  #0##0######
 *
 * 웅덩이 갯수 (0) = 6
 *
 * 왼쪽 벽을 탐색하며 지점에서 이전 고점을 벽으로 선언
 * 오른쪽 벽을 탐색하며 지점에서 이전 고점을 벽으로
 * 양쪽 벽의 높이중 낮은 벽의 높이 - 현재 벽 수 = 물 웅덩이 수
 * */

public class TrappingRainWater {

    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int result = new TrappingRainWater().solve(nums);
        System.out.println(result);
    }

    public int solve(int[] height) {
        int result = 0;

        if (height == null || height.length <= 2)
            return result;

        int[] leftHeight = new int[height.length];
        int[] rightHeight = new int[height.length];

        int max = height[0];
        leftHeight[0] = height[0];

        for (int i = 1; i < height.length; i++) {
            if (height[i] < max) {
                leftHeight[i] = max;
            } else {
                leftHeight[i] = height[i];
                max = height[i];
            }
        }

        max = height[height.length - 1];
        rightHeight[height.length - 1] = height[height.length - 1];

        for (int i = height.length - 2; i >= 0; i--) {
            if (height[i] < max) {
                rightHeight[i] = max;
            } else {
                rightHeight[i] = height[i];
                max = height[i];
            }
        }

        for (int i = 0; i < height.length; i++)
            result += Math.min(leftHeight[i], rightHeight[i]) - height[i];

        return result;
    }
}
