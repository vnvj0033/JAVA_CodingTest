package codingstudy.stackqueue;

import java.util.*;

public class CrossBridge {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = bridge_length;

        int bridgeWeight = 0;

        Queue<Integer> bridgeQueue = new LinkedList<>();

        for (int truck : truck_weights){
            while (true) {
                answer++;

                if (bridgeQueue.size() == bridge_length)
                    bridgeWeight -= bridgeQueue.poll();

                if (bridgeWeight + truck > weight){
                    bridgeQueue.add(0);
                    continue;
                }

                bridgeQueue.add(truck);
                bridgeWeight += truck;
                break;
            }
        }

        return answer;
    }
}
