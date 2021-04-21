package string;

/**
 * 배열에 자리를 각각 10의 자리수로 파싱하여 더하기 1을 한 값을 배열로 반환
 *
 * input :
 *     digits = {0, 9, 0}
 *
 * output : {0, 9, 1}
 */

public class PlusOne {

    public static void main(String[] args) {
        int[] digits = {0, 9, 0};

        int[] result = new PlusOne().solve(digits);

        for (int i : result)
            System.out.print(i);
    }

    int[] solve(int[] digits) {
        boolean isUp = false;
        digits[digits.length - 1]++;

        for (int i = digits.length - 1; i > 0; i--) {
            if (digits[i] > 9) {
                digits[i] = 0;
                isUp = true;
            }

            if (isUp) {
                digits[i - 1]++;
                isUp = false;
            }
        }

        if (isUp) {
            digits = new int[digits.length + 1];
            digits[0] = 1;
        }

        return digits;
    }

    int[] solve2(int[] digits) {
        int index = digits.length - 1;
        int carry = 1;
        while (index >= 0 && carry == 1) {
            digits[index] = (digits[index] + carry) % 10;

            if (digits[index] == 0) carry = 1;
            else carry = 0;

            index--;
        }

        if (carry > 0) {
            digits = new int[digits.length + 1];
            digits[0] = 1;
        }

        return digits;
    }
}
