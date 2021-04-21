package string;

/**
 * 배열에서 0이 아닌수를 앞으로 이동하고 0은 뒤로 이동한다.
 * input :
 *     nums = {0, 3, 2, 0, 8, 5}
 *
 * output : {3, 2, 8, 5, 0, 0}
 *
 * */

public class MoveZeros {

    public static void main(String args[]) {
        int[] nums = {0, 3, 2, 0, 8, 5};

        solve(nums);

        for (int num : nums)
            System.out.print(num + ",");

    }

    private static void solve(int[] nums) {
        int currentIndex = 0;

        for (int i = 0; i < nums.length; i++)
            if (nums[i] != 0)
                nums[currentIndex++] = nums[i];

        while (currentIndex < nums.length)
            nums[currentIndex++] = 0;
    }
}