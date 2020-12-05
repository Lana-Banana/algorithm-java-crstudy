package week3.question1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void solution() {
        assertEquals(3, new Solution().solution(new int[]{3, 0, 6, 1, 5}));
        assertEquals(4, new Solution().solution(new int[]{5, 5, 5, 5}));
        assertEquals(2, new Solution().solution(new int[]{22, 42}));

    }
}