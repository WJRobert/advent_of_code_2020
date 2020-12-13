package za.co.wayne.j.robert.advent.of.code.puzzle.day.twelve;

import za.co.wayne.j.robert.advent.of.code.util.FileReader;

import java.util.List;

public class PuzzleSolver {

    private FileReader fileReader;

    private final Direction[] POS_DIRECTIONS = new Direction[] {Direction.EAST, Direction.NORTH};
    private final Direction[] NEG_DIRECTIONS = new Direction[] {Direction.WEST, Direction.SOUTH};

    public PuzzleSolver() {
        fileReader = new FileReader();
    }

    public int solvePuzzleOne(String inputFilePath) {
        List<String> inputs = fileReader.readInput(inputFilePath);
        int east = 0;
        int north = 0;
        int currentDegrees = 90;
        Direction currentDirection = Direction.EAST;
        for (String instruction: inputs) {
            if (instruction.contains(Direction.EAST.getDirection())) {
                east += Integer.parseInt(instruction.substring(1));
            } else if (instruction.contains(Direction.WEST.getDirection())) {
                east -= Integer.parseInt(instruction.substring(1));
            } else if (instruction.contains(Direction.NORTH.getDirection())) {
                north += Integer.parseInt(instruction.substring(1));
            } else if (instruction.contains(Direction.SOUTH.getDirection())) {
                north -= Integer.parseInt(instruction.substring(1));
            } else if (instruction.contains(Direction.FORWARD.getDirection())) {
                if (currentDirection == Direction.NORTH) {
                    north += Integer.parseInt(instruction.substring(1));
                } else if (currentDirection == Direction.SOUTH) {
                    north -= Integer.parseInt(instruction.substring(1));
                } else if (currentDirection == Direction.EAST) {
                    east += Integer.parseInt(instruction.substring(1));
                } else if (currentDirection == Direction.WEST) {
                    east -= Integer.parseInt(instruction.substring(1));
                }
            } else if (instruction.contains(Direction.LEFT.getDirection())) {
                currentDegrees -= Integer.parseInt(instruction.substring(1));
                if (currentDegrees >= 360) {
                    currentDegrees -= 360;
                } else if (currentDegrees < 0) {
                    currentDegrees = 360 - Math.abs(currentDegrees);
                }
                currentDirection = calculateDirection(currentDegrees);
            } else if (instruction.contains(Direction.RIGHT.getDirection())) {
                currentDegrees += Integer.parseInt(instruction.substring(1));
                if (currentDegrees >= 360) {
                    currentDegrees -= 360;
                } else if (currentDegrees < 0) {
                    currentDegrees = 360 - Math.abs(currentDegrees);
                }
                currentDirection = calculateDirection(currentDegrees);
            }
        }
        return Math.abs(east) + Math.abs(north);
    }

    private Direction calculateDirection(int currentDegrees) {
        switch (currentDegrees) {
            case 0:
                return Direction.NORTH;
            case 90:
                return Direction.EAST;
            case 180:
                return Direction.SOUTH;
            default:
                return Direction.WEST;
        }
    }

    public int solvePuzzleTwo(String inputFilePath) {
        List<String> inputs = fileReader.readInput(inputFilePath);
        int shipEast = 0;
        int shipNorth = 0;
        int waypointEast = 10;
        int waypointNorth = 1;
        for (String instruction: inputs) {
            if (instruction.contains(Direction.EAST.getDirection())) {
                waypointEast += Integer.parseInt(instruction.substring(1));
            } else if (instruction.contains(Direction.WEST.getDirection())) {
                waypointEast -= Integer.parseInt(instruction.substring(1));
            } else if (instruction.contains(Direction.NORTH.getDirection())) {
                waypointNorth += Integer.parseInt(instruction.substring(1));
            } else if (instruction.contains(Direction.SOUTH.getDirection())) {
                waypointNorth -= Integer.parseInt(instruction.substring(1));
            } else if (instruction.contains(Direction.FORWARD.getDirection())) {
                int times = Integer.parseInt(instruction.substring(1));
                for (int i=0; i<times; i++) {
                    shipEast += waypointEast;
                    shipNorth += waypointNorth;
                }
            } else if (instruction.contains(Direction.LEFT.getDirection())) {
                int quarters = Integer.parseInt(instruction.substring(1))/90;
                int originalEast = waypointEast;
                int originalNorth = waypointNorth;
                Direction firstDirection = originalEast < 0 ? Direction.WEST : Direction.EAST;
                Direction secondDirection = originalNorth < 0 ? Direction.SOUTH : Direction.NORTH;
                for (int i=1; i<=quarters; i++) {
                    firstDirection = getNewLeftDirection(firstDirection);
                    secondDirection = getNewLeftDirection(secondDirection);
                }
                if (firstDirection == Direction.EAST || firstDirection == Direction.WEST) {
                    waypointEast = getNewUnits(originalEast, firstDirection);
                    waypointNorth = getNewUnits(originalNorth, secondDirection);
                } else {
                    waypointEast = getNewUnits(originalNorth, secondDirection);
                    waypointNorth = getNewUnits(originalEast, firstDirection);
                }
            } else if (instruction.contains(Direction.RIGHT.getDirection())) {
                int quarters = Integer.parseInt(instruction.substring(1))/90;
                int originalEast = waypointEast;
                int originalNorth = waypointNorth;
                Direction firstDirection = originalEast < 0 ? Direction.WEST : Direction.EAST;
                Direction secondDirection = originalNorth < 0 ? Direction.SOUTH : Direction.NORTH;
                for (int i=1; i<=quarters; i++) {
                    firstDirection = getNewRightDirection(firstDirection);
                    secondDirection = getNewRightDirection(secondDirection);
                }
                if (firstDirection == Direction.EAST || firstDirection == Direction.WEST) {
                    waypointEast = getNewUnits(originalEast, firstDirection);
                    waypointNorth = getNewUnits(originalNorth, secondDirection);
                } else {
                    waypointEast = getNewUnits(originalNorth, secondDirection);
                    waypointNorth = getNewUnits(originalEast, firstDirection);
                }
            }
        }
        return Math.abs(shipEast) + Math.abs(shipNorth);
    }

    private Direction getNewRightDirection(Direction currentDirection) {
        Direction newDirection = Direction.EAST;
        switch (currentDirection) {
            case EAST:
                newDirection = Direction.SOUTH;
                break;
            case SOUTH:
                newDirection = Direction.WEST;
                break;
            case WEST:
                newDirection = Direction.NORTH;
                break;
            case NORTH:
                newDirection = Direction.EAST;
                break;
        }
        return newDirection;
    }

    private Direction getNewLeftDirection(Direction currentDirection) {
        Direction newDirection = Direction.EAST;
        switch (currentDirection) {
            case EAST:
                newDirection = Direction.NORTH;
                break;
            case SOUTH:
                newDirection = Direction.EAST;
                break;
            case WEST:
                newDirection = Direction.SOUTH;
                break;
            case NORTH:
                newDirection = Direction.WEST;
                break;
        }
        return newDirection;
    }

    private int getNewUnits(int currentUnits, Direction currentDirection) {
        currentUnits = Math.abs(currentUnits);
        if (currentDirection == Direction.SOUTH) {
            currentUnits *= -1;
        } else if (currentDirection == Direction.WEST) {
            currentUnits *= -1;
        }
        return currentUnits;
    }
}
