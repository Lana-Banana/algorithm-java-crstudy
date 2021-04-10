/*
    https://programmers.co.kr/learn/courses/30/lessons/42888
    [프로그래머스][2019 KAKAO BLIND RECRUITMENT] 오픈채팅방 (level 2)
 */
package week6.question1;

import java.util.HashMap;
import java.util.StringTokenizer;

class Solution {

    static final String enter = "님이 들어왔습니다.";
    static final String leave = "님이 나갔습니다.";

    public String[] solution(String[] record) {

        HashMap<String, String> members = new HashMap<>();
        StringTokenizer st;

        int count = 0;
        for (String r : record) {
            st = new StringTokenizer(r);
            String status = st.nextToken();
            String id = st.nextToken();
            if (status.equals("Enter") || status.equals("Change")) {
                String nickname = st.nextToken();
                members.put(id, nickname);
            }
            if (status.equals("Enter") || status.equals("Leave")) count++;
        }


        String[] chatting = new String[count];
        int idx = 0;
        for (String r : record) {
            st = new StringTokenizer(r);
            String status = st.nextToken();
            String id = st.nextToken();
            if (!status.equals("Change")) chatting[idx++] = members.get(id) + (status.equals("Enter") ? enter : leave);
        }

        return chatting;
    }

}