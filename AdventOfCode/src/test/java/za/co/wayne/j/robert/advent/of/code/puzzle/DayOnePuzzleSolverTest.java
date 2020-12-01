package za.co.wayne.j.robert.advent.of.code.puzzle;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DayOnePuzzleSolverTest {

    @Test
    public void testSolvePuzzleOne() {
        DayOnePuzzleSolver dayOnePuzzleSolver = new DayOnePuzzleSolver();

        assertEquals(918339, dayOnePuzzleSolver.solvePuzzleOne("day_one/puzzle_input_one.txt"));
    }
}
