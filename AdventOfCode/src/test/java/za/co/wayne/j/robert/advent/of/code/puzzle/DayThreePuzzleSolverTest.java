package za.co.wayne.j.robert.advent.of.code.puzzle;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DayThreePuzzleSolverTest {

    @Test
    public void testSolvePuzzleOne() {
        DayThreePuzzleSolver dayThreePuzzleSolver = new DayThreePuzzleSolver();

        assertEquals(250, dayThreePuzzleSolver.solvePuzzleOne("day_three/puzzle_input.txt"));
    }

    @Test
    public void testSolvePuzzleTwo() {
        DayThreePuzzleSolver dayThreePuzzleSolver = new DayThreePuzzleSolver();

        assertEquals(1592662500, dayThreePuzzleSolver.solvePuzzleTwo("day_three/puzzle_input.txt"));
    }
}
