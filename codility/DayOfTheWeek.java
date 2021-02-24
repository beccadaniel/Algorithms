package codility;

import java.util.HashMap;
import java.util.Map;

public class DayOfTheWeek {
    static final int DAYS_IN_THE_WEEK = 7;
    static HashMap<String, Integer> map = new HashMap<>();

    public static void main(String[] args) {
        map.put("Sun",1);
        map.put("Mon", 2);
        map.put("Tue",3);
        map.put("Wed",4);
        map.put("Thu",5);
        map.put("Fri",6);
        map.put("Sat",7);


        int zero = 0;
        String result = "5" + String.valueOf(zero);
        //result.length()
        result.toLowerC;
        result.contains()
        System.out.println(Integer.parseInt("-5"));
    }

    public static String getDayOfWeek(String s, int k) {
        int daysAwayFrom = k % DAYS_IN_THE_WEEK;
        int currentDay = map.get(s);
        int newDay = (currentDay + daysAwayFrom) % DAYS_IN_THE_WEEK;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue().equals(newDay)) {
                return entry.getKey();
            }
        }
        /*int zero = 0;
        String result = "5" + String.valueOf(zero);
        return Integer.parseInt(result*/
        return "";
    }

}



/*
// you can also use imports, for example:
// import java.util.*;

import java.util.HashMap;
        import java.util.Map;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public String solution(String S, int K) {
        // write your code in Java SE 8
        int daysOfTheWeek = 7;
        HashMap<String, Integer> map = new HashMap<>();
        map.put("Mon", 1);
        map.put("Tue", 2);
        map.put("Wed", 3);
        map.put("Thu", 4);
        map.put("Fri", 5);
        map.put("Sat", 6);
        map.put("Sun", 7);

        if (K < 0 || K > 500) {
            return "";
        }

        int daysAway = K % daysOfTheWeek;
        int currentDay = map.get(S);
        int newDay = (currentDay + daysAway) % daysOfTheWeek;
        for(Map.Entry<String, Integer> entry: map.entrySet()) {
            if (entry.getValue().equals(newDay)) {
                return entry.getKey();
            }
        }
        return "";
    }
}
*/
