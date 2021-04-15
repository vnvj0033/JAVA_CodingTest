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