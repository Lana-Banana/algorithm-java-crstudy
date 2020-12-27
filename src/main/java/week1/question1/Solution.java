/*
  https://programmers.co.kr/learn/courses/30/lessons/68645
  [프로그래머스][월간 코드 챌린지 시즌1] 삼각 달팽이 (level 2)
 */
package week1.question1;

class Solution {
    public int[] solution(int n) {

        //진행 순서
        // 1. 왼쪽 아래
        // 2. 오른쪽
        // 3. 오른쪽 위
        int workflow = 1;
        int index = 1;
        int x = 0, y = 1;
        int[][] dp = new int[n + 1][n + 1];

        for (int i = n; i > 0; i--) {
            for (int j = i; j > 0; j--) {
                if (workflow % 3 == 1) {
                    x++;
                }

                if (workflow % 3 == 2) {
                    y++;
                }

                if (workflow % 3 == 0) {
                    x--;
                    y--;
                }
                dp[x][y] = index++;
            }
            workflow++;
        }

        int[] answer = new int[index-1];
        int idx = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                answer[idx++] = dp[i][j];
            }
        }


        return answer;
    }
}