/*
    https://programmers.co.kr/learn/courses/30/lessons/68646
    [프로그래머스][월간 코드 챌린지 시즌1] 풍선 터트리기 (level 3)
 */
package week1.question3;

class Solution {
    public int solution(int[] a) {
        return 2 + check(a);
    }

    private static int check(int[] a) {

        int count = 0;
        int l = a[0];
        int r = a[a.length - 1];

        for (int i = 1; i < a.length - 1; i++) {
            if (a[i] < l) {
                count++;
                l = a[i];
            }
            if (a[a.length - 1 - i] < r) {
                count++;
                r = a[a.length - 1 - i];
            }
        }

        if (l == r) count--;

        return count;
    }
}