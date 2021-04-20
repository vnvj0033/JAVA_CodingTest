package string;

import java.util.HashMap;

/**
 * A의 문자를 키로 B에서의 위치를 찾는다.
 * input :
 *     A = {12, 28, 46, 32, 50}
 *     B = {50, 12, 32, 46, 28}
 *
 * output : 1 4 3 2 0
 * B의 원소를 키로 위치를 Map에 저장하고 A의 원소를 Map에서 찾는다.
 * */

public class FindAnagramMapping {

    public static void main(String[] args) {
        int[] A = {12, 28, 46, 32, 50};
        int[] B = {50, 12, 32, 46, 28};
        int[] result = new FindAnagramMapping().solve(A, B);

        for (int i : result)
            System.out.print(i + " ");

    }

    int[] solve(int[] A, int[] B) {
        int length = A.length;
        int[] result = new int[length];
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < length; i++)
            map.put(B[i], i);

        for (int i = 0; i < length; i++)
            result[i] = map.get(A[i]);

        return result;
    }

}
