package backTracking;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    public static void main(String[] args) {
        GenerateParentheses a = new GenerateParentheses();

        System.out.println(a.generateParenthesis_dfs(3));
    }

    public List<String> generateParenthesis_dfs(int n) {
        List<String> res = new ArrayList<>();
        dfs(res, "", n, n);
        return res;
    }

    private void dfs(List<String> list, String str, int left, int right) {

        if (left < 0 || left > right)
            return;

        System.out.println("str\t"+str+"\t left: "+left+" right: "+right);

        if (left == 0 && right == 0) {
            list.add(str);
            return;
        }

        dfs(list, str + '(', left - 1, right);
        dfs(list, str + ')', left, right - 1);
    }
}
