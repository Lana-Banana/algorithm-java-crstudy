/*
    https://programmers.co.kr/learn/courses/30/lessons/17676
    [프로그래머스][2018 KAKAO BLIND RECRUITMENT] 추석 트래픽 (level 3)
 */
package week4.question3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

class Solution {

    private static class Request {
        double start, end, cost;

        Request(double end, double cost) {
            this.start = end - cost + 0.001;
            this.end = end;
            this.cost = cost;
        }
    }

    public int solution(String[] lines) {

        ArrayList<Request> requests = new ArrayList<>();
        StringTokenizer st;

        for (String log : lines) {
            st = new StringTokenizer(log);
            st.nextToken();
            String endTime = st.nextToken();
            String cost = st.nextToken();
            double[] times = Arrays.stream(endTime.split(":")).mapToDouble(Double::parseDouble).toArray();
            double end = times[0] * 3600 + times[1] * 60 + times[2];
            requests.add(new Request(end, Double.parseDouble(cost.substring(0, cost.length() - 1))));
        }


        int answer = Integer.MIN_VALUE;

        for(Request r : requests) {
            answer = Math.max(getRequestTPS(r.start, requests), answer);
            answer = Math.max(getRequestTPS(r.end, requests), answer);
        }

        return answer;
    }

    private static int getRequestTPS (double start, ArrayList<Request> requests) {
        int tps = 0;

        double endOfRange = start + 1;

        for(Request r: requests) {
            if(     (start <= r.end && r.end <= endOfRange)
                ||  (start <= r.start && r.end <= endOfRange)
                ||  (start <= r.start && r.start < endOfRange)
                ||  (r.start < start && endOfRange < r.end)
            ) tps++;
        }

        return tps;
    }


}