package string;

import java.util.Arrays;

public class KClosest {

    public static void main(String[] args) {
        int[][] points = {{1, 3}, {-2, 2}};
        int k = 1;
        int[][] result = new KClosest().solve(points, k);

        System.out.println(result[0][0] + ", " + result[0][1]);
    }

    public int[][] solve(int[][] points, int k) {
        Arrays.sort(points, (a, b) -> a[0] * a[0] + a[1] * a[1] - b[0] * b[0] - b[1] * b[1]);
        return Arrays.copyOfRange(points, 0, k);
    }
}
