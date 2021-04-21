package string;

import java.util.*;

/**
 * lower과 upper 범위 내에 제외된 숫자를 찾는다.
 * input :
 *     nums = {0, 2, 3, 5, 50, 75, 99}
 *     lower = 0
 *     upper = 99
 *
 * output : [1, 4, 6->49, 51->74, 76->98]
 * */

public class MissingRanges {
    public static void main(String[] args) {

        int[] nums = {0, 2, 3, 5, 50, 75, 99};
        int lower = 0, upper = 99;
        List<String> result = new MissingRanges().solve(nums, lower, upper);

        System.out.println(result);
//		[0->1, 4, 6->49, 51->74, 76->99]

    }

    public List<String> solve(int[] nums, int lower, int upper) {
        List<String> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            result.add(makeRange(lower, upper));
            return result;
        }

        if (lower < nums[0])
            result.add(makeRange(lower, nums[0] - 1));

        for (int i = 0; i < nums.length - 1; i++)
            if (nums[i] != nums[i + 1] && nums[i] + 1 < nums[i + 1])
                result.add(makeRange(nums[i] + 1, nums[i + 1] - 1));


        if (nums[nums.length - 1] < upper)
            result.add(makeRange(nums[nums.length - 1] + 1, upper));

        return result;
    }

    public String makeRange(int low, int high) {
        return low == high ? String.valueOf(low) : (low + "->" + high);
    }
}
