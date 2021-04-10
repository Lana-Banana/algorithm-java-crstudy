/*
    https://programmers.co.kr/learn/courses/30/lessons/60057
    [프로그래머스][2020 KAKAO BLIND RECRUITMENT] 문자열 압축
 */
package week5.question1;

class Solution {
    public int solution(String s) {


        int answer = Integer.MAX_VALUE;

        for (int rsize = 1; rsize <= s.length() / 2 || rsize == 1; rsize++) {

            int count = 0;
            int startIdx = 0;

            while (startIdx < s.length() && startIdx + rsize < s.length()) {
                String repeat = s.substring(startIdx, startIdx + rsize);
                String temp = s.substring(startIdx);
                int subCount = getRepeatCount(temp, repeat);
                // Math.log10(subCount) + 1 : 반복 횟수의 10 자릿수
                count += subCount > 1 ? Math.log10(subCount) + 1 + rsize : rsize;
                startIdx += subCount * rsize;
            }

            count += s.length() - startIdx;

            answer = Math.min(count, answer);
        }

        return answer;
    }


    private static int getRepeatCount(String s, String repeat) {
        int count = 0;
        while (s.startsWith(repeat)) {
            s = s.substring(repeat.length());
            count++;
        }
        return count;
    }
}