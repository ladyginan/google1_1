package app;

import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class SolutionTest {
    @Test
    void firstCase() {

        final int[] output = Solution.solution(5, new int[]{19, 14, 28});
        final int[] expectedResult = new int[]{21, 15, 29};
        assertArrayEquals(expectedResult, output);
    }

    @Test
    void secondCase() {

        final int[] output = Solution.solution(3, new int[]{7, 3, 5, 1});
        final int[] expectedResult = new int[]{-1, 7, 6, 3};

        assertArrayEquals(expectedResult, output);
    }

}
