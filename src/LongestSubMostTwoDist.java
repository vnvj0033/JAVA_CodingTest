import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubMostTwoDist {

    public static void main(String[] args) {
        String str = "ccaabba";
        System.out.println(new LongestSubMostTwoDist().solve2(str));
    }

    public int solve(String str) {
        int start = 0, end = 0, counter = 0, length = 0;
        Map<Character, Integer> map = new HashMap<>();

        while (end < str.length()) {
            char endChar = str.charAt(end);
            map.put(endChar, map.getOrDefault(endChar, 0) + 1);
            if (map.get(endChar) == 1) counter++;
            end++;

            while (counter > 2) {
                char startChar = str.charAt(start);
                map.put(startChar, map.get(startChar) - 1);
                if (map.get(startChar) == 0) counter--;
                start++;
            }

            length = Math.max(length, end - start);
        }
        return length;
    }

    int solve2(String str) {
        Set<Character> set = new HashSet<>();

        int start = 0;
        int max = 0;
        int nextIndex = 0;
        boolean firstSizeOne = false;
        boolean firstSizeTow = false;

        for (int i = 0; i < str.length(); i++) {

            set.add(str.charAt(i));
            if (set.size() > 2) {
                set = new HashSet<>();
                max = Math.max(i - start + 1, max);
                i = nextIndex - 1;
                firstSizeTow = false;
                firstSizeOne = false;
                continue;
            } else if (set.size() == 1 && !firstSizeOne) {
                firstSizeOne = true;
                start = i;
            } else if (set.size() == 2 && !firstSizeTow) {
                firstSizeTow = true;
                nextIndex = i;
            } else if (set.size() == 2 && i == str.length() - 1) {
                max = Math.max(i - start, max);
            }
            System.out.println(start + "," + i);
        }
        return max;
    }
}