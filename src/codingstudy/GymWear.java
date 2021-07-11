package codingstudy;

import java.util.Arrays;

public class GymWear {
    public int solution(int n, int[] lost, int[] reserve) {
        int anwser = 0;
        int[] students = new int[n];
        Arrays.fill(students, 1);

        for (int loster : lost)
            students[loster-1]--;

        for (int reserver : reserve)
            students[reserver-1]++;

        if (students[0] == 0 && students[1] == 2){
            students[0]++;
            students[1]--;
        }

        if (students[n-1] == 0 && students[n-2] == 2 && n > 2){
            students[n-1]++;
            students[n-2]--;
        }

        for (int i = 1; i < n - 1; i++){
            if (students[i] == 0){
                if (students[i-1] == 2) {
                    students[i]++;
                    students[i-1]--;
                }else if (students[i+1] == 2){
                    students[i]++;
                    students[i+1]--;
                }
            }
        }

        for (int student : students)
            if (student > 0) anwser++;

        return anwser;
    }
}
