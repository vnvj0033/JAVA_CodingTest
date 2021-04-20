package string;

import java.util.HashSet;
import java.util.Set;

/**
 * S문자열에 J의 원소가 몇번 나오는지 검사
 * input :
 *     J = "aaA!"
 *     S = "aAAbacsgbAbAf!@#ba"
 *
 * output : 8
 *
 * Set을 사용해 검사하면 간단하다.
 * */

public class JewelsAndStones {

    public static void main(String[] args) {
        String J = "aaA!", S = "aAAbacsgbAbAf!@#ba";

        int result = new JewelsAndStones().solve(J, S);

        System.out.println(result);
    }

    int solve(String jew, String stone) {
        Set<Character> set = new HashSet<>();

        for (char jewel : jew.toCharArray())
            set.add(jewel);

        int count = 0;

        for (char stoneChar : stone.toCharArray())
            if (set.contains(stoneChar)) count++;

        return count;
    }
}
