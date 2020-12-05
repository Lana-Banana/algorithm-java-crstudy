/*
    https://programmers.co.kr/learn/courses/30/lessons/67256
    [프로그래머스][2020카카오 인턴십] 키패드 누르기
 */
package week2.question1;

import java.util.HashMap;

class Solution {

    static char h;
    static int pl, pr;
    static HashMap<Integer, Position> map;

    public String solution(int[] numbers, String hand) {

        h = hand.equals("right") ? 'R' : 'L';
        pl = 10;
        pr = 11;

        map = new HashMap<>();

        map.put(0, new Position(4, 2));
        map.put(10, new Position(4, 1));
        map.put(11, new Position(4, 3));

        int idx = 1;
        for (int i = 1; i <= 3; i++) {
            for (int j = 1; j <= 3; j++) {
                map.put(idx++, new Position(i, j));
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int n : numbers) sb.append(getLR(n));
        return sb.toString();
    }

    private static char getLR(int n) {
        if (n == 1 || n == 4 || n == 7) {
            pl = n;
            return 'L';
        } else if (n == 3 || n == 6 || n == 9) {
            pr = n;
            return 'R';
        }

        char result = check(n);
        if (result == 'R') pr = n;
        else pl = n;

        return result;
    }

    private static char check(int n) {
        int ld = nextDistance(pl, n);
        int rd = nextDistance(pr, n);
        if (ld == rd) {
            return h;
        } else if (rd > ld) return 'L';
        else return 'R';
    }

    private static class Position {
        int x, y;

        Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static int nextDistance(int now, int next) {
        Position nw = map.get(now);
        Position nt = map.get(next);
        return Math.abs(nw.x - nt.x) + Math.abs(nw.y - nt.y);
    }
}