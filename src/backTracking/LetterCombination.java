package backTracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 문자의 조합을 구하기
 * input :
 *     digits = "23" (2번, 3번 위치)
 *     digitletter[] = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" }
 *
 * output : [ad, bd, cd, ae, be, ce, af, bf, cf]
 *
 * 2, 3번 위치의 "abc", "def"를 이용하여 조합을 만들어야하는 문제
 * */

public class LetterCombination {
    public static void main(String[] args) {
        LetterCombination a = new LetterCombination();

        System.out.println(a.solve("23"));
    }

    public List<String> solve(String digits) {
        String digitletter[] = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
        List<String> result = new ArrayList<>();

        if (digits.length() == 0)
            return result;

        result.add("");

        for (int i = 0; i < digits.length(); i++)
            result = combine(digitletter[Integer.parseInt(String.valueOf(digits.charAt(i)))], result);

        return result;
    }

    public List<String> combine(String digit, List<String> firstList) {
        List<String> result = new ArrayList<>();

        for (int i = 0; i < digit.length(); i++)
            for (String firstStr : firstList)
                result.add(firstStr + digit.charAt(i));

        return result;
    }
}
