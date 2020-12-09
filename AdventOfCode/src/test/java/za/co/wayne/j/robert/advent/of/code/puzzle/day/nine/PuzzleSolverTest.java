package za.co.wayne.j.robert.advent.of.code.puzzle.day.nine;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PuzzleSolverTest {

    @Test
    public void testSolvePuzzleOne() {
        PuzzleSolver puzzleSolver = new PuzzleSolver();

        assertEquals(507622668, puzzleSolver.solvePuzzleOne("day_nine/puzzle_input.txt", 25));
    }

    @Test
    public void testSolvePuzzleTwo() {
        PuzzleSolver puzzleSolver = new PuzzleSolver();

        assertEquals(76688505, puzzleSolver.solvePuzzleTwo("day_nine/puzzle_input.txt", 507622668));
    }
}
