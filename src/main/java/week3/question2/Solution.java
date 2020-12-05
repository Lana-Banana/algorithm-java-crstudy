/*
    https://programmers.co.kr/learn/courses/30/lessons/42842
    [프로그래머스][완전탐색] 카펫 (level 2)
 */
package week3.question2;

class Solution {
    public int[] solution(int brown, int yellow) {

        int size = brown + yellow;
        int x = 3;
        int y;
        while (true) {
            y = size / x;
            if(check(x, y, yellow)){
                return new int[] {y, x};
            }
            x++;
        }
    }

    private static boolean check(int x, int y, int yellow) {
        return (x - 2) * (y - 2) == yellow;
    }


}