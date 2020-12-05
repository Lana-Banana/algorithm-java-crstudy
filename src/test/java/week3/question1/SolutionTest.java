package week3.question1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void solution() {
        assertEquals(3, new Solution().solution(new int[]{3, 0, 6, 1, 5}));
    }
}