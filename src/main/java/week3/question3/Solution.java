/*
    https://programmers.co.kr/learn/courses/30/lessons/42860
    [프로그래머스][탐욕법] 조이스틱 (level 3)
 */
package week3.question3;

class Solution {
    public int solution(String name) {

        int answer = 0;
        for (char c : name.toCharArray()) {
            answer += changeAlphabet(c);
        }
        answer += moveCursor(name.toCharArray());

        return answer;

    }

    private static int moveCursor(char[] data) {
        int moveCount = Integer.MAX_VALUE;
        int moveCountOrigin = data.length - 1;

        for (int i = 0; i < data.length; i++) {
            //  'A' 가  연속해서 나오면 방향을 왼쪽으로 바꿔서 이동시킨다.
            int next_index = i + 1;
            while (next_index < data.length && data[next_index] == 'A') {
                next_index++; // 연속된 A의 마지막 인덱스
            }
            // 마지막 문자에서 연속된 A 의 마지막 인덱스까지 이동 거리(역방향)
            int reversCount = data.length - next_index;

            // 정방향 이동 거리 + 처음 연속 A 가 나온 인덱스부터 역방향 이동 거리 + 역방향 이동 거리
            moveCount = Math.min(moveCount, i * 2 + reversCount);
        }

        return Math.min(moveCount, moveCountOrigin);
    }

    private static int changeAlphabet(char nextChar) {
        int now = (int) 'A';
        int next = (int) nextChar;
        int backward = (int) next - 26;
        return Math.min(next - now, now - backward);
    }
}