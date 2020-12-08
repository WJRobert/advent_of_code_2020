package za.co.wayne.j.robert.advent.of.code.puzzle.day.eight;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PuzzleSolverTest {

    @Test
    public void testSolvePuzzleOne() {
        PuzzleSolver puzzleSolver = new PuzzleSolver();

        assertEquals(1723, puzzleSolver.solvePuzzleOne("day_eight/puzzle_input.txt"));
    }

    @Test
    public void testSolvePuzzleTwo() {
        PuzzleSolver puzzleSolver = new PuzzleSolver();

        assertEquals(846, puzzleSolver.solvePuzzleTwo("day_eight/puzzle_input.txt"));
    }
}
