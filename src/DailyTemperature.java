import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Stack;

public class DailyTemperature {

    public static void main(String[] args) {
        int[] nums = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] res = solveStack(nums);

        for(int i : res)
            System.out.print(i+" ");
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