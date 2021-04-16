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
