package za.co.wayne.j.robert.advent.of.code.puzzle.day.one;

import org.junit.Test;
import za.co.wayne.j.robert.advent.of.code.puzzle.day.one.PuzzleSolver;

import static org.junit.Assert.assertEquals;

public class PuzzleSolverTest {

    @Test
    public void testSolvePuzzleOne() {
        PuzzleSolver puzzleSolver = new PuzzleSolver();

        assertEquals(918339, puzzleSolver.solvePuzzleOne("day_one/puzzle_input_one.txt"));
    }

    @Test
    public void testSolvePuzzleTwo() {
        PuzzleSolver puzzleSolver = new PuzzleSolver();

        assertEquals(23869440, puzzleSolver.solvePuzzleTwo("day_one/puzzle_input_one.txt"));
    }
}
