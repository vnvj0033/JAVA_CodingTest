package string;

import java.util.ArrayList;
import java.util.List;

/**
 * 배열 탐색을 왼쪽 아래 오른쪽 위를 반복하여 순서를 구한다.
 *
 * intput :
 *     matrix = {
 *         {1, 2, 3, 13},
 *         {4, 5, 6, 14},
 *         {7, 8, 9, 15},
 *         {10, 11, 12, 16}};
 *
 * output : {1, 2, 3, 13, 14, 15, 16, 12, 11, 10, 7, 4, 5, 6, 9, 8}
 * */

public class SpiralMatrix {

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3, 13},
                {4, 5, 6, 14},
                {7, 8, 9, 15},
                {10, 11, 12, 16}};

        List<Integer> result = new SpiralMatrix().solve(matrix);
        System.out.println(result);
    }

    List<Integer> solve(int[][] matrix) {

        List<Integer> result = new ArrayList<>();

        if (matrix == null || matrix.length == 0)
            return result;

        int rowStart = 0;
        int rowEnd = matrix.length - 1;

        int colStart = 0;
        int colEnd = matrix[0].length - 1;

        while (rowStart <= rowEnd && colStart <= colEnd) {
            for (int i = colStart; i <= colEnd; i++)
                result.add(matrix[rowStart][i]);
            rowStart++;

            for (int i = rowStart; i <= rowEnd; i++)
                result.add(matrix[i][colEnd]);
            colEnd--;

            if (rowStart <= rowEnd)
                for (int i = colEnd; i >= colStart; i--)
                    result.add(matrix[rowEnd][i]);
            rowEnd--;

            if (colStart <= colEnd)
                if (rowStart <= rowEnd)
                    for (int i = rowEnd; i >= rowStart; i--)
                        result.add(matrix[i][colStart]);
            colStart++;
        }
        return result;
    }
}