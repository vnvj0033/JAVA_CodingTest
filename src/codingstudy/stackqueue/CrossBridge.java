package codingstudy.stackqueue;

import java.util.*;

public class CrossBridge {

    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = crossBridge(bridge_length, weight, truck_weights);

        return answer;
    }

    private int crossBridge(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> bridgeQueue = new LinkedList<>();

        int bridgeWeight = 0;
        int result = bridge_length;

        for (int truck : truck_weights){
            while (true) {
                result++;

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
        return result;
    }
}