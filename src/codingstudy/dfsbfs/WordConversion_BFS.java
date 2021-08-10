package codingstudy.dfsbfs;

import java.util.*;

public class WordConversion_BFS {
    public static void main(String[] args) {
        WordConversion_BFS wc = new WordConversion_BFS();
        String begin = "hit";
        String target = "cog";
        String[] words = new String[]{"hot", "dot", "dog", "lot", "log", "cog"};


        System.out.println(wc.solution(begin, target, words));
    }

    List<String> wordList;

    public int solution(String begin, String target, String[] words) {
        wordList = new ArrayList(Arrays.asList(words));

        Queue<String> queue = new LinkedList<>();

        queue.offer(begin);

        int count = 0;
        while (!queue.isEmpty()){

            String word = queue.poll();
            wordList.remove(word);
            List<String> newWordList = new ArrayList<>(wordList);

            if (word.equals(target)) return count;

            for (String newWord : wordList) {
                if (isOneDifferentChar(word, newWord)) {
                    queue.offer(newWord);
                    newWordList.remove(newWord);
                }

            }
            count++;
        }

        return 0;
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