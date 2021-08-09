package codingstudy.dfsbfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WordConversion {
    public static void main(String[] args) {
        WordConversion wc = new WordConversion();
        String begin = "hit";
        String target = "cog";
        String[] words = new String[]{"hot", "dot", "dog", "lot", "log", "cog"};


        System.out.println(wc.solution(begin, target, words));
    }

    private String target;
    private int result = 0;

    public int solution(String begin, String target, String[] words) {
        this.target = target;

        List<String> routeList = new ArrayList<>();
        List<String> wordList = new ArrayList<>(Arrays.asList(words));

        routeList.add(begin);
        dfs(begin, wordList, routeList);

        return result;
    }

    private void dfs(String begin, List<String> wordList, List<String> routeList) {
        if (begin.equals(target)) {

            for (String s : routeList)
                System.out.print(s+" ");
            System.out.println();

            if (result < routeList.size())
                result = routeList.size();

            return;
        }

        wordList.remove(begin);

        List<String> newWordList = new ArrayList<>(wordList);
        List<String> newRouteList = new ArrayList<>(routeList);

        for (String word : wordList) {
            if (isOneDifferentChar(begin, word)) {
                routeList.add(word);
                dfs(word, newWordList, newRouteList);
            }
        }
    }

    private boolean isOneDifferentChar(String s1, String s2) {
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();

        boolean checker = false;
        for (int i = 0; i < s1.length(); i++) {

            if (c1[i] != c2[i]) {
                if (checker) return false;
                checker = true;
            }
        }

        return checker;
    }
}