/*
    https://programmers.co.kr/learn/courses/30/lessons/17677
    [프로그래머스][2018 KAKAO BLIND RECRUITMENT] 뉴스 클러스터링 (level 2)
 */
package week4.question2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.regex.Pattern;

class Solution {
    public int solution(String str1, String str2) {

        HashMap<String, Integer> map1 = getSameCounts(getStringArray(str1));
        HashMap<String, Integer> map2 = getSameCounts(getStringArray(str2));


        if (map1.size() > map2.size()) {
            HashMap<String, Integer> temp = map1;
            map1 = map2;
            map2 = temp;
        }

        double a = getIntersection(map1, map2);
        double b = getUnion(map1, map2);

        return jacad(a, b);
    }

    private static String[] getStringArray(String origin) {

        String pattern = "^[a-zA-Z]*$";
        String[] newSts = new String[origin.length() - 1];

        for (int i = 0; i < origin.length() - 1; i++) {
            if (Pattern.matches(pattern, origin.substring(i, i + 2))) {
                newSts[i] = origin.substring(i, i + 2).toLowerCase();
            }
        }
        return newSts;
    }

    private static HashMap<String, Integer> getSameCounts(String[] strArray) {
        HashMap<String, Integer> strs = new HashMap<>();
        String flag = "";
        for (String key : strArray) {
            if (key != null && !flag.equals(key)) {
                int count = (int) Arrays.stream(strArray).filter(key::equals).count();
                strs.put(key, count);
                flag = key;
            }
        }
        return strs;
    }

    private static double getIntersection(HashMap<String, Integer> map1, HashMap<String, Integer> map2) {
        double count = 0;
        for (String key : map1.keySet()) {
            if (map2.containsKey(key)) count += Math.min(map1.get(key), map2.get(key));
        }
        return count;
    }

    private static double getUnion(HashMap<String, Integer> map1, HashMap<String, Integer> map2) {
        double count = 0;
        for (String key : map2.keySet()) {
            count += map2.get(key);
        }
        for (String key : map1.keySet()) {
            if (map2.containsKey(key)) {
                count += Math.max(map2.get(key), map1.get(key)) - map2.get(key);
            } else {
                count += map1.get(key);
            }
        }
        return count;
    }

    private static int jacad(double a, double b) {
        int multiply = 65536;
        if (a == 0 && b == 0) return multiply;
        double answer = (a / b) * multiply;
        return (int) answer;
    }
}