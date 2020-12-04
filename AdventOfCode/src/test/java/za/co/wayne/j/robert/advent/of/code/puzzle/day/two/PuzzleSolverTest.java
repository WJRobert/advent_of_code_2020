package za.co.wayne.j.robert.advent.of.code.puzzle.day.two;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PuzzleSolverTest {

    @Test
    public void testSolvePuzzleOne() {
        PuzzleSolver puzzleSolver = new PuzzleSolver();

        assertEquals(422, puzzleSolver.solvePuzzleOne("day_two/puzzle_input.txt"));
    }

    @Test
    public void testSolvePuzzleTwo() {
        PuzzleSolver puzzleSolver = new PuzzleSolver();

        assertEquals(451, puzzleSolver.solvePuzzleTwo("day_two/puzzle_input.txt"));
    }
}
