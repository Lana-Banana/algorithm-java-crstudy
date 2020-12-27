package week5.question1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void solution() {
        assertEquals(7, new Solution().solution("aabbaccc"));
        assertEquals(9, new Solution().solution("ababcdcdababcdcd"));
        assertEquals(8, new Solution().solution("abcabcdede"));
        assertEquals(14, new Solution().solution("abcabcabcabcdededededede"));
        assertEquals(17, new Solution().solution("xababcdcdababcdcd"));
    }
}