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
 * course는 수업 갯수
 *
 * input :
 *   course = 4
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
        System.out.println(courseNumber);

        if (courseNumber <= 0)
            return false;
        ///////////////////////////////////////
        Queue<Integer> queue = new LinkedList<>();
        int[] inDegree = new int[courseNumber];

        // 1. inDegree : [1, 1, 1, 0]
        for (int[] num : nums) inDegree[num[1]]++;

        // 2.queue에 0인 값 찾아서 넣기
        int completeLength = inDegree.length;

        for (int i = 0; i < completeLength; i++)
            if (inDegree[i] == 0)
                queue.offer(i);

        // 3.
        while (!queue.isEmpty()) {
            int zeroVal = queue.poll();

            for (int i = 0; i < nums.length; i++) {
                if (zeroVal == nums[i][0]) {
                    System.out.println("=============");
                    System.out.println("zeroVal "+zeroVal+" i "+i);
                    inDegree[nums[i][1]]--;

                    if (inDegree[nums[i][1]] == 0)
                        queue.offer(nums[i][1]);
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
