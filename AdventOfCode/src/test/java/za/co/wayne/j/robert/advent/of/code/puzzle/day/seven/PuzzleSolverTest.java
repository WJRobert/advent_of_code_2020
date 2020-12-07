package za.co.wayne.j.robert.advent.of.code.puzzle.day.seven;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PuzzleSolverTest {

    @Test
    public void testSolvePuzzleOne() {
        PuzzleSolver puzzleSolver = new PuzzleSolver();

        assertEquals(326, puzzleSolver.solvePuzzleOne("day_seven/puzzle_input.txt"));
    }

    @Test
    public void testSolvePuzzleTwo() {
        PuzzleSolver puzzleSolver = new PuzzleSolver();

        assertEquals(5635, puzzleSolver.solvePuzzleTwo("day_seven/puzzle_input.txt"));
    }
}
