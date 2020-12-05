package za.co.wayne.j.robert.advent.of.code.puzzle.day.five;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PuzzleSolverTest {

    @Test
    public void testSolvePuzzleOne() {
        PuzzleSolver puzzleSolver = new PuzzleSolver();

        assertEquals(978, puzzleSolver.solvePuzzleOne("day_five/puzzle_input.txt"));
    }

    @Test
    public void testSolvePuzzleTwo() {
        PuzzleSolver puzzleSolver = new PuzzleSolver();

        assertEquals(727, puzzleSolver.solvePuzzleTwo(978, "day_five/puzzle_input.txt"));
    }
}
