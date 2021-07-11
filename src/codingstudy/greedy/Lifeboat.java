package codingstudy.greedy;

import java.util.ArrayList;
import java.util.Arrays;

class Lifeboat {
    public int solution(int[] people, int limit) {

        ArrayList<Integer> peoples = createPeoplesArray(people);

        int answer = carryCount(peoples, limit);

        return answer;
    }

    private ArrayList<Integer> createPeoplesArray(int[] people) {
        ArrayList<Integer> peoples = new ArrayList<>();

        Arrays.sort(people);

        for (int p :people)
            peoples.add(0, p);

        return peoples;
    }

    private int carryCount(ArrayList<Integer> peoples, int limit) {
        int result = 0;

        while (peoples.size() > 0) {
            if (peoples.get(peoples.size() - 1) + peoples.get(0) <= limit)
                peoples.remove(0);

            peoples.remove(peoples.size() - 1);
            result++;
        }
        return result;
    }
}
