package za.co.wayne.j.robert.advent.of.code.puzzle.day.three;

import org.junit.Test;
import za.co.wayne.j.robert.advent.of.code.puzzle.day.three.PuzzleSolver;

import static org.junit.Assert.assertEquals;

public class PuzzleSolverTest {

    @Test
    public void testSolvePuzzleOne() {
        PuzzleSolver puzzleSolver = new PuzzleSolver();

        assertEquals(250, puzzleSolver.solvePuzzleOne("day_three/puzzle_input.txt"));
    }

    @Test
    public void testSolvePuzzleTwo() {
        PuzzleSolver puzzleSolver = new PuzzleSolver();

        assertEquals(1592662500, puzzleSolver.solvePuzzleTwo("day_three/puzzle_input.txt"));
    }
}
