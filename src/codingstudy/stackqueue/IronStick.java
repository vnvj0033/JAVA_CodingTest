package codingstudy.stackqueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class IronStick {
    public static void main(String[] args) throws IOException {

        char[] sticks = getInputArray();

        int result = 0;

        Stack<Character> stickStack = new Stack<>();

        for (int i = 0; i < sticks.length; i++){
            if (sticks[i] == '(') {
                stickStack.add(sticks[i]);
                continue;
            }

            if (sticks[i-1] == ')') {
                stickStack.pop();
                result++;
                continue;
            }

            if (stickStack.peek() == '(') {
                stickStack.pop();
                result += stickStack.size();
            }
        }
        System.out.println(result);
    }

    private static char[] getInputArray() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] sticks = br.readLine().toCharArray();
        br.close();

        return sticks;
    }
}
