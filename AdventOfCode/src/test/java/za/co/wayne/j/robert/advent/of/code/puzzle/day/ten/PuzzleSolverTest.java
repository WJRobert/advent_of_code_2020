package za.co.wayne.j.robert.advent.of.code.puzzle.day.ten;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PuzzleSolverTest {

    @Test
    public void testSolvePuzzleOne() {
        PuzzleSolver puzzleSolver = new PuzzleSolver();

        assertEquals(2046, puzzleSolver.solvePuzzleOne("day_ten/puzzle_input.txt"));
    }

    @Test
    public void testSolvePuzzleTwo() {
        PuzzleSolver puzzleSolver = new PuzzleSolver();

        assertEquals(1157018619904L, puzzleSolver.solvePuzzleTwo("day_ten/puzzle_input.txt"));
    }
}
