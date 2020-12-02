package za.co.wayne.j.robert.advent.of.code.puzzle;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DayTwoPuzzleSolverTest {

    @Test
    public void testSolvePuzzleOne() {
        DayTwoPuzzleSolver dayTwoPuzzleSolver = new DayTwoPuzzleSolver();

        assertEquals(422, dayTwoPuzzleSolver.solvePuzzleOne("day_two/puzzle_input.txt"));
    }
}
