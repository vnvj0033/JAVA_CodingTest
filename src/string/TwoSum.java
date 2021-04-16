package string;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static void main(String[] args) {
        int[] nums = {2, 8, 11, 21};
        int target = 10;
        int[] result = solve(nums, target);

        for (int i : result)
            System.out.println(i);
    }

    public static int[] solve(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] result = new int[2];

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                result[0] = map.get(nums[i]) + 1;
                result[1] = i + 1;
            } else map.put(target - nums[i], i);
        }
        return result;
    }
}