package codingstudy.dfsbfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WordConversion_DFS {
    public static void main(String[] args) {
        WordConversion_DFS wc = new WordConversion_DFS();
        String begin = "hit";
        String target = "cog";
        String[] words = new String[]{"hot", "dot", "dog", "lot", "log", "cog"};


        System.out.println(wc.solution(begin, target, words));
    }

    private String target;
    private int result = 51;

    public int solution(String begin, String target, String[] words) {
        this.target = target;

        List<String> routeList = new ArrayList<>();
        List<String> wordList = new ArrayList<>(Arrays.asList(words));

        dfs(begin, wordList, routeList);

        if (result == 51) result = 0;
        return result;
    }

    private void dfs(String begin, List<String> wordList, List<String> routeList) {


        if (begin.equals(target)) {

            if (result > routeList.size())
                result = routeList.size();

            return;
        }

        wordList.remove(begin);

        List<String> newWordList = new ArrayList<>(wordList);

        for (String word : wordList) {
            if (isOneDifferentChar(begin, word)) {
                List<String> newRouteList = new ArrayList<>(routeList);
                newRouteList.add(word);
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