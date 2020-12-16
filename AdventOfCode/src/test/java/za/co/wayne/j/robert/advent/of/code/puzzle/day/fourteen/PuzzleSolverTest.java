package za.co.wayne.j.robert.advent.of.code.puzzle.day.fourteen;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PuzzleSolverTest {

    @Test
    public void testSolvePuzzleOne() {
        PuzzleSolver puzzleSolver = new PuzzleSolver();

        assertEquals(10035335144067L, puzzleSolver.solvePuzzleOne("day_fourteen/puzzle_input.txt"));
    }

    @Test
    public void testSolvePuzzleTwo() {
        PuzzleSolver puzzleSolver = new PuzzleSolver();

        assertEquals(0, puzzleSolver.solvePuzzleTwo("day_fourteen/puzzle_input.txt"));
    }
}
