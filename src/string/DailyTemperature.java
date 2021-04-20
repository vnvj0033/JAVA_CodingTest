package string;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Stack;

/**
 * 일별 온도에서 다음 높은 온도까지의 일 구하기
 * input :
 *     nums = {73, 74, 75, 71, 69, 72, 76, 73}
 *
 * output : 0 1 5 4 4 5 0 0
 * */

public class DailyTemperature {

    public static void main(String[] args) {
        int[] nums = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] results = solve(nums);

        for(int result : results)
            System.out.print(result+" ");
    }

    private static int[] solve(int[] tempers) {
        int[] result = new int[tempers.length];

        for (int i = 0; i < tempers.length; i++){
            for (int j = i + 1; j < tempers.length - 1; j++){
                if (tempers[i] < tempers[j]){
                    result[i] = j - 1;
                    break;
                }
            }
        }

        return result;
    }

    public static int[] solveStack(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int[] ret = new int[temperatures.length];

        for(int i = 0; i < temperatures.length; i++) {
            while(!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i] ) {
                int index = stack.pop();
                ret[index] = i - index;
            }
            stack.push(i);
        }
        return ret;
    }


    public int[] solveMap(int[] temperatures) {
        final int m = temperatures.length;
        final Map<Integer, Integer> next = new HashMap<>();
        final Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < m; i++) {
            while (!stack.empty() && temperatures[stack.peek()] < temperatures[i]) {
                next.put(stack.peek(), i - stack.pop());
            }
            stack.push(i);
        }
        final int[] ans = new int[m];
        for (int i = 0; i < m; i++) {
            ans[i] = next.getOrDefault(i, 0);
        }
        return ans;
    }

    public static int[] solveBack(int[] T) {
        LinkedList<Integer> stack = new LinkedList<>();
        int[] ans = new int[T.length];
        stack.push(T.length-1);
        for(int i = T.length -2;i>=0;i--){
            while(!stack.isEmpty() && T[i] >= T[stack.peek()])
                stack.pop();
            if(!stack.isEmpty())
                ans[i] = stack.peek() - i;
            stack.push(i);
        }
        return ans;
    }
}