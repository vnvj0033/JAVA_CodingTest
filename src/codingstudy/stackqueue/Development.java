package codingstudy.stackqueue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Development {
    Queue<Integer> progressQueue = new LinkedList<>();
    Queue<Integer> speedQueue = new LinkedList<>();

    public int[] solution(int[] progresses, int[] speeds) {

        initQueue(progresses, speeds);

        return workWithGetDistributionCount();
    }

    private void initQueue(int[] progresses, int[] speeds) {

        for (int i = 0; i < progresses.length; i++){
            progressQueue.add(progresses[i]);
            speedQueue.add(speeds[i]);
        }

    }

    private int[] workWithGetDistributionCount() {
        List<Integer> results = new ArrayList<>();

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

        for (int i = 0; i < results.size(); i++)
            answer[i] = results.get(i);

        return answer;
    }
}
