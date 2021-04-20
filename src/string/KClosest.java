package string;

import java.util.Arrays;

/**
 * 원점에서 가장먼 x, y 좌표 k개 구하기
 * input :
 *     points = {{1, 3}, {-2, 2}}
 *     k = 1
 *
 * output : -2, 2
 *
 * 피타고라스 공식 사용하고. 결과 정렬해 순서 뽑기
 * */

public class KClosest {

    public static void main(String[] args) {
        int[][] points = {{1, 3}, {-2, 2}};
        int k = 1;
        int[][] results = new KClosest().solve(points, k);

        for (int[] result : results)
            System.out.println(result[0] + ", " + result[1]);
    }

    public int[][] solve(int[][] points, int k) {
        Arrays.sort(points, (a, b) -> a[0] * a[0] + a[1] * a[1] - b[0] * b[0] - b[1] * b[1]);
        return Arrays.copyOfRange(points, 0, k);
    }
}
