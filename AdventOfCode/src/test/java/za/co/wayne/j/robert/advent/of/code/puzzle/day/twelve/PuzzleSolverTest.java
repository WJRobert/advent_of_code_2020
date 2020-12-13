package za.co.wayne.j.robert.advent.of.code.puzzle.day.twelve;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PuzzleSolverTest {

    @Test
    public void testSolvePuzzleOne() {
        PuzzleSolver puzzleSolver = new PuzzleSolver();

        assertEquals(2228, puzzleSolver.solvePuzzleOne("day_twelve/puzzle_input.txt"));
    }

    @Test
    public void testSolvePuzzleTwo() {
        PuzzleSolver puzzleSolver = new PuzzleSolver();

        assertEquals(286, puzzleSolver.solvePuzzleTwo("day_twelve/puzzle_input.txt"));
    }

}
