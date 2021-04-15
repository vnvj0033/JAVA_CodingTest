import java.util.HashSet;
import java.util.Set;

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
