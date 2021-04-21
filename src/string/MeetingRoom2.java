package string;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 미팅룸의 예약시간이 주어질때 최대 몇개의 룸이 필요한지
 * input :
 *     in1 = new Interval(4, 9);
 *     in2 = new Interval(5, 15);
 *     in3 = new Interval(0, 30);
 *     in4 = new Interval(10, 16);
 *
 * output : 3
 *
 * Interval{start=5, end=15}
 * Interval{start=0, end=30}
 * Interval{start=10, end=16}
 *
 * PriorityQueue를 사용해 상위 정렬된 순서부터 비교하여 예약 시간을 추가한다.
 * */

public class MeetingRoom2 {

    public static void main(String[] args) {
        Interval in1 = new Interval(4, 9);
        Interval in2 = new Interval(5, 15);
        Interval in3 = new Interval(0, 30);
        Interval in4 = new Interval(10, 16);
        int result = new MeetingRoom2().solve(in1, in2, in3, in4);

        System.out.println(result);
    }


    public int solve(Interval... intervals) {
        Arrays.sort(intervals);
        Queue<Interval> pq = new PriorityQueue<>(Comparator.comparingInt((Interval o) -> o.end));
        pq.add(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            if (pq.peek().end <= intervals[i].start)
                pq.poll();
            pq.add(intervals[i]);
        }

        for (Interval i : pq)
            System.out.println(i);

        return pq.size();
    }


    public int solve1(Interval[] intervals) {
        if (intervals == null || intervals.length == 0)
            return 0;

        Arrays.sort(intervals);
        Queue<Interval> heap = new PriorityQueue<>(intervals.length, Comparator.comparingInt(o -> o.end));

        heap.offer(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            Interval interval = heap.poll();
            if (interval.end <= intervals[i].start) {
                interval.end = intervals[i].end;
            } else {
                heap.offer(intervals[i]);
            }
            heap.offer(interval);
        }
        return heap.size();


    }

    private static class Interval implements Comparable<Interval>{
        int start, end;

        Interval(int s, int e) {
            this.start = s;
            this.end = e;
        }

        @Override
        public int compareTo(Interval o) {
            return this.start - o.start;
        }

        @Override
        public String toString() {
            return "Interval{" +
                    "start=" + start +
                    ", end=" + end +
                    '}';
        }
    }
}