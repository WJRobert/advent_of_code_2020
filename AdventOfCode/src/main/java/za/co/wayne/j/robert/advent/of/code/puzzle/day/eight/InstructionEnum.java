package za.co.wayne.j.robert.advent.of.code.puzzle.day.eight;

public enum InstructionEnum {
    NO_OPERATION("nop"),
    ACCUMULATE("acc"),
    JUMP_TO("jmp");

    private String instruction;

    InstructionEnum(String instruction) {
        this.instruction = instruction;
    }

    public String getInstruction() {
        return instruction;
    }
}
