/*
    https://programmers.co.kr/learn/courses/30/lessons/17681
    [프로그래머스][2018 KAKAO BLIND RECRUITMENT] 비밀지도 (level 1)
 */
package week4.question1;

class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {

        String[] answer = new String[n];
        for (int i = 0; i < n; i++) {
            String map = Integer.toBinaryString(arr1[i] | arr2[i]);
            map = map.replaceAll("0", " ");
            map = map.replaceAll("1", "#");

            StringBuilder sb = new StringBuilder();

            if (map.length() < n) {
                for (int j = 0; j < n - map.length(); j++) {
                    sb.append(" ");
                }
            }
            sb.append(map);

            answer[i] = sb.toString();
        }
        return answer;
    }
}