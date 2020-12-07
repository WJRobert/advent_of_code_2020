package za.co.wayne.j.robert.advent.of.code.puzzle.day.seven;

public class ContainedLuggage {

    private Integer count;
    private String type;

    public ContainedLuggage() {
    }

    public ContainedLuggage(Integer count, String type) {
        this.count = count;
        this.type = type;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
