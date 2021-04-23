package backTracking;

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

    private void dfs(int[] nums, List<List<Integer>> lists, List<Integer> cur) {


        if (cur.size() == nums.length) {
            List<Integer> list = new ArrayList<>(cur);
            lists.add(list);
        }

        for (int num : nums) {
            if (cur.contains(num))
                continue;
            cur.add(num);
            dfs(nums, lists, cur);
            cur.remove(cur.size() - 1); // 마지막 삭제하여 다음에 배제하기
        }
    }
}
