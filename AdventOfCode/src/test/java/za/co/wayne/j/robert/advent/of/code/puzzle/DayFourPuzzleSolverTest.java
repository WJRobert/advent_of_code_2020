package za.co.wayne.j.robert.advent.of.code.puzzle;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DayFourPuzzleSolverTest {

    @Test
    public void testSolvePuzzleOne() {
        DayFourPuzzleSolver dayFourPuzzleSolver = new DayFourPuzzleSolver();

        assertEquals(260, dayFourPuzzleSolver.solvePuzzleOne("day_four/puzzle_input.txt"));
    }

    @Test
    public void testSolvePuzzleTwo() {
        DayFourPuzzleSolver dayFourPuzzleSolver = new DayFourPuzzleSolver();

        assertEquals(153, dayFourPuzzleSolver.solvePuzzleTwo("day_four/puzzle_input.txt"));
    }
}
