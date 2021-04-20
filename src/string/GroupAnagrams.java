package string;

import java.util.*;

/**
 * list에 들어있는 문자의 아나그램 목록을 찾기
 * intput :
 * list = {"eat", "tea", "tan", "ate", "nat", "bat"}
 * <p>
 * output : [[eat, tea, ate], [bat], [tan, nat]]
 */

public class GroupAnagrams {

    public static void main(String[] args) {
        String[] list = {"eat", "tea", "tan", "ate", "nat", "bat"};

        List<List<String>> result = new GroupAnagrams().solve(list);
        System.out.println(result);
    }

    public List<List<String>> solve(String[] strs) {

        if (strs == null || strs.length == 0)
            return new ArrayList<>();

        List<List<String>> result = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            char[] arr = new char[26]; // 알바벳 수

            for (int i = 0; i < str.length(); i++)
                arr[str.charAt(i) - 'a']++; // a~z = 0~25로 형변환

            String ns = new String(arr);

            if (map.containsKey(ns)) {
                map.get(ns).add(str);
            } else {
                ArrayList<String> al = new ArrayList<>();
                al.add(str);
                map.put(ns, al);
            }
        }
        result.addAll(map.values());
        return result;
    }

    public List<List<String>> solve2(String[] strs) {
        if (strs == null || strs.length == 0) return new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] ca = s.toCharArray();
            Arrays.sort(ca);
            String keyStr = String.valueOf(ca);
            if (!map.containsKey(keyStr)) map.put(keyStr, new ArrayList<>());
            map.get(keyStr).add(s);
        }
        return new ArrayList<>(map.values());
    }
}
