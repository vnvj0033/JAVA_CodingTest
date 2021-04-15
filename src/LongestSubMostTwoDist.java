import java.util.HashMap;
import java.util.Map;

public class LongestSubMostTwoDist {

    public static void main(String[] args) {
        String str = "ccaabbba";
        System.out.println(new LongestSubMostTwoDist().solve(str));
    }

    public int solve(String str) {
        int start = 0, end = 0, counter = 0, len = 0;
        Map<Character,Integer> map = new HashMap<>();

        while(end < str.length()){
            char c = str.charAt(end);
            map.put(c, map.getOrDefault(c, 0) + 1);

            if(map.get(c) == 1) counter++;

            while(counter > 2){
                char cTemp = str.charAt(start);
                map.put(cTemp, map.get(cTemp) - 1);

                if(map.get(cTemp) == 0)
                    counter--;
                start++;
            }

            len = Math.max(len, ++end-start);
        }
        return len;
    }

}
