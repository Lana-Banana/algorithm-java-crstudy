/*
    https://programmers.co.kr/learn/courses/30/lessons/64061
    [프로그래머스][2019 카카오 개발자 겨울 인턴십] 크레인 인형뽑기 게임
 */
package week5.question2;

import java.util.Stack;

class Solution {
    public int solution(int[][] board, int[] moves) {

        int answer = 0;
        Stack<Integer> stack = new Stack<>();

        for (int m : moves) {
            for (int i = 0; i < board.length; i++) {
                if (board[i][m - 1] != 0) {
                    if (!stack.isEmpty() && stack.peek() == board[i][m - 1] ) {
                        answer += 2;
                        stack.pop();
                    } else {
                        stack.push(board[i][m - 1]);
                    }
                    board[i][m - 1] = 0;
                    break;
                }
            }

        }
        return answer;
    }
}