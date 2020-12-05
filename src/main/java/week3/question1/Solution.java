/*
    https://programmers.co.kr/learn/courses/30/lessons/42747
    [프로그래머스][정렬] H-Index (level 2)
 */
package week3.question1;

import java.util.Arrays;

class Solution {
    public int solution(int[] citations) {

        Arrays.sort(citations);

        return bs(0, citations[citations.length-1], citations);
    }

    private static int bs(int start, int end, int[] data) {

        int max = 0;

        while (start < end) {
            int mid = (start + end) / 2;
            int h = mid;

            // TODO: 개선 필요.
            int higher = (int) Arrays.stream(data).filter(v -> h <= v).count();
            int lower = (int) Arrays.stream(data).filter(v -> h > v).count();

            if (check(lower, higher, h)) {
                start = mid+1;
                max = Math.max(h, max);
            } else {
                end = mid;
            }
        }

        return max;

    }

    private static boolean check(int lower, int higher, int h) {
        return (lower < h && h <= higher);
    }
}