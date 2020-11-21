/*
  https://programmers.co.kr/learn/courses/30/lessons/68936
  [프로그래머스][월간 코드 챌린지 시즌1] 쿼드압축 후 개수 세기 (level 2)
 */
package week1.question2;

class Solution {

    public int[] solution(int[][] arr) {
        int[] answer = {0, 0};
        check(0, 0, arr.length, arr, answer);
        return answer;
    }

    private static void check(int x, int y, int l, int[][] arr, int[] answer) {

        boolean allOne = true;
        boolean allZero = true;
        loop:
        for (int i = x; i < x + l; i++) {
            for (int j = y; j < y + l; j++) {
                if (arr[i][j] == 0) allOne = false;
                if (arr[i][j] == 1) allZero = false;
                if (!allOne && !allZero) break loop;
            }
        }
        if (allOne) {
            answer[1]++;
            return;
        }
        if (allZero) {
            answer[0]++;
            return;
        }

        check(x, y, l / 2, arr, answer);
        check(x, y + l / 2, l / 2, arr, answer);
        check(x + l / 2, y, l / 2, arr, answer);
        check(x + l / 2, y + l / 2, l / 2, arr, answer);


    }
}