package string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 문자열에 가능한 아나그램 위치 찾기
 * input :
 *     txt = "BACDGABCDA"
 *     pat = "ABCD"
 *
 * output : [0, 5, 6]
 *
 * txt에서 pat의 원소가 순서대로 모두 포함한 위치를 반환한다.
 * */

public class FindAllAnagrams {
    public static void main(String args[]) {
        String txt = "BACDGABCDA";
        String pat = "ABCD";

        List<Integer> solve = new FindAllAnagrams().solve2(txt, pat);
        System.out.println(solve);
    }

    List<Integer> solve2(String txt, String pat) {
        List<Integer> result = new ArrayList<>();

        if (txt == null || txt.length() == 0 || pat == null || pat.length() == 0 || txt.length() < pat.length())
            return result;

        char[] txtArr = new char[pat.length()];
        char[] patArr = pat.toCharArray();
        Arrays.sort(patArr);

        for (int i = 0; i < txt.length() - pat.length() + 1; i++) {
            for (int j = 0; j < pat.length(); j++)
                txtArr[j] = txt.charAt(j+i); // txtArr에는 pat만큼의 길이만 담는다.

            Arrays.sort(txtArr);

            if (Arrays.equals(txtArr, patArr))
                result.add(i);
        }
        return result;
    }

    public List<Integer> solve(String txt, String pat) {

        List<Integer> result = new ArrayList<>();

        if (txt == null || txt.length() == 0 || pat == null || pat.length() == 0 || txt.length() < pat.length())
            return result;

        int[] patArr = new int[256];

        for (int i = 0; i < pat.length(); i++)
            patArr[pat.charAt(i)]++;

        for (int i = 0; i < txt.length() - pat.length() + 1; i++) {
            int[] txtArr = new int[256];
            for (int j = 0; j < pat.length(); j++)
                txtArr[txt.charAt(i + j)]++;

            if (check(patArr, txtArr))
                result.add(i);
        }
        return result;
    }

    private boolean check(int[] patArr, int[] txtArr) {
        for (int i = 0; i < patArr.length; i++)
            if (patArr[i] != txtArr[i])
                return false;

        return true;

    }
}
