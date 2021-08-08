package codingstudy.dfsbfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class TravelRoute {


    public String[] solution(String[][] tickets) {
        String[] answer = {};


        List<String> routeList = new ArrayList();

        for (String[] ticket : tickets) {

            if (ticket[0].equals("ICN")) dfs(ticket);
        }


        return answer;
    }

    private void dfs(String[] ticket) {


    }

}
