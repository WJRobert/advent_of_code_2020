package za.co.wayne.j.robert.advent.of.code.puzzle.day.six;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PuzzleSolverTest {

    @Test
    public void testSolvePuzzleOne() {
        PuzzleSolver puzzleSolver = new PuzzleSolver();

        assertEquals(6437, puzzleSolver.solvePuzzleOne("day_six/puzzle_input.txt"));
    }

    @Test
    public void testSolvePuzzleTwo() {
        PuzzleSolver puzzleSolver = new PuzzleSolver();

        assertEquals(3229, puzzleSolver.solvePuzzleTwo("day_six/puzzle_input.txt"));
    }
}
