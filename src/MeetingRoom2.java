import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;


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

    static class Interval implements Comparable<Interval>{
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