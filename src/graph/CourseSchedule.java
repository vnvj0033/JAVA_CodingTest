package graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * 위상정렬 문제 : 사이클이 없는 그래프의 문제 풀이
 * CourseSchedule : 코스를 수강하기 위한 전제조건 문제 풀이
 * [0, 1]이 주어지면 0을 수강하기 위해 1을 완료 해야함
 * num 배열이 위상 정렬인지 true, false 반환
 *
 * input :
 *   num = { { 1, 0 },
 *           { 2, 1 },
 *           { 3, 2 } }
 *
 * output : true
 *
 *  0 -> 1 -> 2 -> 3
 *
 * */

public class CourseSchedule {

    public static void main(String[] args) {
        int[][] nums = {
                { 1, 0 },
                { 2, 1 },
                { 3, 2 } };

        CourseSchedule a = new CourseSchedule();

        System.out.println(a.solve(nums));
    }

    public boolean solve(int[][] nums) {

        Set<Integer> set = new HashSet<>();

        for (int[] num : nums)
            for (int n : num)
                set.add(n);

        int courseNumber = set.size();

        if (courseNumber <= 0)
            return false;


        Queue<Integer> queue = new LinkedList<>();
        int[] inDegree = new int[courseNumber];

        for (int[] num : nums) inDegree[num[1]]++;

        for (int i = 0; i < inDegree.length; i++)
            if (inDegree[i] == 0)
                queue.offer(i);

        // 3.
        while (!queue.isEmpty()) {
            int zeroVal = queue.poll();

            for (int[] num : nums) {
                if (zeroVal == num[0]) {
                    inDegree[num[1]]--; // 출발의 도착지 0으로

                    if (inDegree[num[1]] == 0)
                        queue.offer(num[1]);
                }
            }
        }

        /*
         *  4. 3번에서 completed에 값을 0으로 다 만들어야
         *  완성completed[nums[i][1]]--
         */

        for (int i : inDegree)
            if (i != 0)
                return false;

        return true;
    }
}
