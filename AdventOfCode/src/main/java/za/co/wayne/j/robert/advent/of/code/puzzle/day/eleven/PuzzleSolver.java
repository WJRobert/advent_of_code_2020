package za.co.wayne.j.robert.advent.of.code.puzzle.day.eleven;

import za.co.wayne.j.robert.advent.of.code.util.FileReader;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PuzzleSolver {

    private FileReader fileReader;

    public PuzzleSolver() {
        fileReader = new FileReader();
    }

    public int solvePuzzleOne(String inputFilePath) {
        List<String> inputs = fileReader.readInput(inputFilePath);
        int columns = inputs.get(0).length();
        int rows = inputs.size();
        char[][] seats = new char[rows][columns];
        for (int i = 0; i < rows; i++) {
            String row = inputs.get(i);
            for (int j = 0; j < columns; j++) {
                seats[i][j] = row.charAt(j);
            }
        }
        int previousOccupiedSeats = countOccupiedSeats(seats, rows, columns);
        int occupiedSeats = -1;
        while (previousOccupiedSeats != occupiedSeats) {
            previousOccupiedSeats = occupiedSeats;
            seats = shiftSeats(seats, rows, columns);
            occupiedSeats = countOccupiedSeats(seats, rows, columns);
        }
        return occupiedSeats;
    }

    private char[][] makeACopy(char[][] seats, int rows, int cols) {
        char[][] copy = new char[rows][cols];
        for (int i=0; i<rows; i++) {
            for (int j=0; j<cols; j++) {
                copy[i][j] = seats[i][j];
            }
        }
        return copy;
    }

    private char[][] shiftSeats(char[][] seats, int rows, int cols) {
        char[][] newSeats = makeACopy(seats, rows, cols);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (seats[i][j] == 'L') {
                    List<int[]> adjacentSeats = findAdjacentSeat(i,j,rows,cols);
                    if (findOccupiedCount(adjacentSeats,seats) == 0) {
                        newSeats[i][j] = '#';
                    }
                } else if (seats[i][j] == '#') {
                    List<int[]> adjacentSeats = findAdjacentSeat(i,j,rows,cols);
                    if (findOccupiedCount(adjacentSeats,seats) >= 4) {
                        newSeats[i][j] = 'L';
                    }
                }
            }
        }
        return newSeats;
    }

    private List<int[]> findAdjacentSeat(int seatRow, int seatCol, int rows, int cols) {
        List<int[]> adjacentSeats = new ArrayList<>();
        for (int row = seatRow - 1; row <= seatRow + 1; row++) {
            if (row < rows && row >= 0) {
                for (int col = seatCol - 1; col <= seatCol + 1; col++) {
                    if (col < cols && col >= 0) {
                        if (row != seatRow || col != seatCol) {
                            adjacentSeats.add(new int[]{row, col});
                        }
                    }
                }
            }
        }
        return adjacentSeats;
    }

    private int findOccupiedCount(List<int[]> seatsToCheck, char[][] seats) {
        int occupiedCount = 0;
        for (int[] seat: seatsToCheck) {
            if (seats[seat[0]][seat[1]] == '#') {
                occupiedCount++;
            }
        }
        return occupiedCount;
    }

    private int countOccupiedSeats(char[][] seats, int rows, int cols) {
        int occupiedSeats = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (seats[i][j] == '#') {
                    occupiedSeats++;
                }
            }
        }
        return occupiedSeats;
    }

    public int solvePuzzleTwo(String inputFilePath) {
        List<String> inputs = fileReader.readInput(inputFilePath);
        int columns = inputs.get(0).length();
        int rows = inputs.size();
        char[][] seats = new char[rows][columns];
        for (int i = 0; i < rows; i++) {
            String row = inputs.get(i);
            for (int j = 0; j < columns; j++) {
                seats[i][j] = row.charAt(j);
            }
        }
        int previousOccupiedSeats = countOccupiedSeats(seats, rows, columns);
        int occupiedSeats = -1;
        while (previousOccupiedSeats != occupiedSeats) {
            previousOccupiedSeats = occupiedSeats;
            seats = shiftSeatsSeeing(seats, rows, columns);
            occupiedSeats = countOccupiedSeats(seats, rows, columns);
        }
        return occupiedSeats;
    }

    private char[][] shiftSeatsSeeing(char[][] seats, int rows, int cols) {
        char[][] newSeats = makeACopy(seats, rows, cols);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (seats[i][j] == 'L') {
                    List<int[]> adjacentSeats = findVisibleSeats(seats, i,j,rows,cols);
                    if (findOccupiedCount(adjacentSeats,seats) == 0) {
                        newSeats[i][j] = '#';
                    }
                } else if (seats[i][j] == '#') {
                    List<int[]> adjacentSeats = findVisibleSeats(seats, i,j,rows,cols);
                    if (findOccupiedCount(adjacentSeats,seats) >= 5) {
                        newSeats[i][j] = 'L';
                    }
                }
            }
        }
        return newSeats;
    }

    private List<int[]> findVisibleSeats(char[][] seats, int seatRow, int seatCol, int rows, int cols) {
        List<int[]> adjacentSeats = new ArrayList<>();
        //Check up
        for (int row = seatRow - 1; row >= 0; row--) {
            if (seats[row][seatCol] != '.') {
                adjacentSeats.add(new int[]{row, seatCol});
                break;
            }
        }
        //Check down
        for (int row = seatRow + 1; row < rows; row++) {
            if (seats[row][seatCol] != '.') {
                adjacentSeats.add(new int[]{row, seatCol});
                break;
            }
        }
        //Check left
        for (int col = seatCol - 1; col >= 0; col--) {
            if (seats[seatRow][col] != '.') {
                adjacentSeats.add(new int[]{seatRow, col});
                break;
            }
        }
        //Check right
        for (int col = seatCol + 1; col < cols; col++) {
            if (seats[seatRow][col] != '.') {
                adjacentSeats.add(new int[]{seatRow, col});
                break;
            }
        }
        //Check left-up
        int count = 0;
        for (int row = seatRow - 1; row >= 0; row--) {
            count++;
            int col = seatCol - count;
            if (col < 0) {
                break;
            }
            if (seats[row][col] != '.') {
                adjacentSeats.add(new int[]{row, col});
                break;
            }
        }
        //Check right-up
        count = 0;
        for (int row = seatRow - 1; row >= 0; row--) {
            count++;
            int col = seatCol + count;
            if (col >= cols) {
                break;
            }
            if (seats[row][col] != '.') {
                adjacentSeats.add(new int[]{row, col});
                break;
            }
        }
        //Check left-down
        count = 0;
        for (int row = seatRow + 1; row < rows; row++) {
            count++;
            int col = seatCol - count;
            if (col < 0) {
                break;
            }
            if (seats[row][col] != '.') {
                adjacentSeats.add(new int[]{row, col});
                break;
            }
        }
        //Check right-down
        count = 0;
        for (int row = seatRow + 1; row < rows; row++) {
            count++;
            int col = seatCol + count;
            if (col >= cols) {
                break;
            }
            if (seats[row][col] != '.') {
                adjacentSeats.add(new int[]{row, col});
                break;
            }
        }
        return adjacentSeats;
    }

}
