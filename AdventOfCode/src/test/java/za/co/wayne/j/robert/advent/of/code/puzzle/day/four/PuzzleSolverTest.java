package za.co.wayne.j.robert.advent.of.code.puzzle.day.four;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PuzzleSolverTest {

    @Test
    public void testSolvePuzzleOne() {
        PuzzleSolver puzzleSolver = new PuzzleSolver();

        assertEquals(260, puzzleSolver.solvePuzzleOne("day_four/puzzle_input.txt"));
    }

    @Test
    public void testSolvePuzzleTwo() {
        PuzzleSolver puzzleSolver = new PuzzleSolver();

        assertEquals(153, puzzleSolver.solvePuzzleTwo("day_four/puzzle_input.txt"));
    }
}
