package za.co.wayne.j.robert.advent.of.code.puzzle.day.thirteen;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PuzzleSolverTest {

    @Test
    public void testSolvePuzzleOne() {
        PuzzleSolver puzzleSolver = new PuzzleSolver();

        assertEquals(4808, puzzleSolver.solvePuzzleOne("day_thirteen/puzzle_input.txt"));
    }

    @Test
    public void testSolvePuzzleTwo() {
        PuzzleSolver puzzleSolver = new PuzzleSolver();

        assertEquals(1202161486L, puzzleSolver.solvePuzzleTwo("day_thirteen/puzzle_input.txt"));
    }
}
