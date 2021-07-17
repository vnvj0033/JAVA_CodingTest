package codingstudy.stackqueue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;




public class Development {
    public static void main(String[] args) {
        Development d = new Development();

        int[] progresses = new int[] {0,0,0,0};
        int[] speeds = new int[] {100,50,34,25};

        int[] reset = d.solution(progresses, speeds);

        System.out.println(reset);
    }

    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> results = new ArrayList<>();

        Queue<Integer> progressQueue = new LinkedList<>();
        Queue<Integer> speedQueue = new LinkedList<>();

        for (int i = 0; i < progresses.length; i++){
            progressQueue.add(progresses[i]);
            speedQueue.add(speeds[i]);
        }

        while (progressQueue.size() > 0){
            int progresse = progressQueue.peek();
            int speed = speedQueue.peek();

            int day = (int) Math.ceil((100f - progresse) / speed);

            int distributionCount = 0;

            while (progressQueue.size() > 0){


                progresse = progressQueue.peek();
                speed = speedQueue.peek();

                int taskProgress = progresse + day * speed;

                if (taskProgress < 100) break;

                progressQueue.poll();
                speedQueue.poll();

                distributionCount++;
            }
            results.add(distributionCount);
        }

        int[] answer = new int[results.size()];

        for (int i = 0; i < results.size(); i++){
            answer[i] = results.get(i);
        }

        return answer;
    }
}
