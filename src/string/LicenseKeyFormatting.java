package string;

/**
 * 문자열 s의 -를 제외한 문자를 뒤에서k 마다 -를 추가한다.
 * input :
 *     S = "5Fsff3Z-2e-921-j-qww"
 *     k = 6
 *
 * output : 5FSF-F3Z2E9-21JQWW
 *
 * replace를 이용해 - 제거 sb를 사용해 뒤부터 k마다 - 추가
 * */

public class LicenseKeyFormatting {

    public static void main(String[] args) {

        String S = "5Fsff3Z-2e-921-j-qww";
        int k = 6;

        String result = new LicenseKeyFormatting().solve(S, k);
        System.out.println(result);
    }

    public String solve(String S, int K) {

        String S1 = S.replace("-", "");
        S1 = S1.toUpperCase();

        StringBuilder sb = new StringBuilder();
        for (char c : S1.toCharArray())
            sb.append(c);

        int len = sb.toString().length();
        for (int i = len - K; i > 0; i = i - K)
            sb.insert(i, '-');

        return sb.toString();
    }
}