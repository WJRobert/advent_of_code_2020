package za.co.wayne.j.robert.advent.of.code.puzzle.day.twelve;

public enum Direction {
    FORWARD("F"),
    LEFT("L"),
    RIGHT("R"),
    NORTH("N"),
    SOUTH("S"),
    EAST("E"),
    WEST("W");

    Direction(String direction) {
        this.direction = direction;
    }

    private String direction;

    public String getDirection() {
        return direction;
    }
}
