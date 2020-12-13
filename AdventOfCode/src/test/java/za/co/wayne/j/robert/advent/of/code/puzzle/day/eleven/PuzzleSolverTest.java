package za.co.wayne.j.robert.advent.of.code.puzzle.day.eleven;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PuzzleSolverTest {

    @Test
    public void testSolvePuzzleOne() {
        PuzzleSolver puzzleSolver = new PuzzleSolver();

        assertEquals(2483, puzzleSolver.solvePuzzleOne("day_eleven/puzzle_input.txt"));
    }

    @Test
    public void testSolvePuzzleTwo() {
        PuzzleSolver puzzleSolver = new PuzzleSolver();

        assertEquals(26, puzzleSolver.solvePuzzleTwo("day_eleven/puzzle_input.txt"));
    }

}
