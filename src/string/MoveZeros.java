package string;

public class MoveZeros {

    public static void main(String args[]) {
        int[] nums = {0, 3, 2, 0, 8, 5};

        solve(nums);
        for (int num : nums)
            System.out.print(num + ",");

    }

    private static int[] solve(int[] nums) {
        int currentIndex = 0;

        for (int i = 0; i < nums.length; i++)
            if (nums[i] != 0)
                nums[currentIndex++] = nums[i];

        while (currentIndex < nums.length)
            nums[currentIndex++] = 0;

        return nums;
    }
}