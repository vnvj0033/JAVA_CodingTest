import java.util.HashMap;

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
