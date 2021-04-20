import java.util.ArrayList;
import java.util.List;

/**
 * 입력에 순열을 구한다.
 */

public class Permutation {

    public static void main(String[] args) {
        Permutation a = new Permutation();
        int[] nums = {1, 2, 3};
        System.out.println(a.permute_dfs(nums));
    }

    public List<List<Integer>> permute_dfs(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();

        if (nums == null || nums.length == 0)
            return lists;

        dfs(nums, lists, new ArrayList<>());
        return lists;
    }

    int count = 0;

    private void dfs(int[] nums, List<List<Integer>> lists, List<Integer> cur) {
        count++;

        if (cur.size() == nums.length) {
            List<Integer> list = new ArrayList<>(cur);
            lists.add(list);
        }

        for (int i = 0; i < nums.length; i++) {
            if (cur.contains(nums[i]))
                continue;
            cur.add(nums[i]);
            dfs(nums, lists, cur);
            cur.remove(cur.size() - 1);
        }
    }
}