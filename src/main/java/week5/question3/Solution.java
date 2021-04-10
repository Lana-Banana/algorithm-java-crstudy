/*
    https://programmers.co.kr/learn/courses/30/lessons/17678
    [프로그래머스][2018 KAKAO BLIND RECRUITMENT] 1차 셔틀버스
 */
package week5.question3;

import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {

    private static class Crew {
        int arrivalTime;

        Crew(String time) {
            String[] times = time.split(":");
            this.arrivalTime = Integer.parseInt(times[0]) * 60 + Integer.parseInt(times[1]);
        }
    }

    public String solution(int n, int t, int m, String[] timetable) {

        // Timetable of Shuttles
        int[] shuttleTimeTalbe = new int[n];
        shuttleTimeTalbe[0] = 9 * 60;
        for (int i = 1; i < n; i++) {
            shuttleTimeTalbe[i] = shuttleTimeTalbe[i - 1] + t;
        }

        // Timetalbe of crews
        PriorityQueue<Crew> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.arrivalTime));
        for (String time : timetable) pq.add(new Crew(time));


        // get answer
        int[] isFulled = new int[n];
        for (int i = 0; i < n; i++) {
            int time = shuttleTimeTalbe[i];
            int count = 0;
            while (!pq.isEmpty() && pq.peek().arrivalTime <= time && count < m) {
                count++;
                if (count == m) {
                    isFulled[i] = pq.poll().arrivalTime; // set last rider
                } else pq.poll();
            }
        }

        int answer = shuttleTimeTalbe[n - 1];
        if (isFulled[n - 1] != 0) answer = isFulled[n - 1] - 1;


        return String.format("%02d:%02d", answer / 60, answer % 60);
    }

}