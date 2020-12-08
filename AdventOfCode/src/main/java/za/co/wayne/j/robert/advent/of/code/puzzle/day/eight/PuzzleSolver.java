package za.co.wayne.j.robert.advent.of.code.puzzle.day.eight;

import za.co.wayne.j.robert.advent.of.code.util.FileReader;

import java.util.List;

public class PuzzleSolver {

    private FileReader fileReader;

    public PuzzleSolver() {
        fileReader = new FileReader();
    }

    public int solvePuzzleOne(String inputFilePath) {
        List<String> inputs = fileReader.readInput(inputFilePath);
        int accumulator = 0;
        boolean[] operationsRan = new boolean[inputs.size()];
        int index = 0;
        while (index < operationsRan.length) {
            if (operationsRan[index]) {
                return accumulator;
            }
            String operation = inputs.get(index).trim();
            String[] operationAndValue = operation.split(" ");
            operationsRan[index] = true;
            if (InstructionEnum.ACCUMULATE.getInstruction().equals(operationAndValue[0])) {
                accumulator += Integer.parseInt(operationAndValue[1]);
                index++;
            } else if (InstructionEnum.JUMP_TO.getInstruction().equals(operationAndValue[0])) {
                index += Integer.parseInt(operationAndValue[1]);
            } else {
                index++;
            }
        }
        return accumulator;
    }

    public int solvePuzzleTwo(String inputFilePath) {
        List<String> inputs = fileReader.readInput(inputFilePath);
        int accumulator = 0;
        boolean[] operationsRan = new boolean[inputs.size()];
        int index = 0;
        int countOfShouldChange = 1;
        int countOfJmpOrNops = 0;
        while (index < operationsRan.length) {
            if (operationsRan[index]) {
                countOfJmpOrNops = 0;
                countOfShouldChange++;
                index = 0;
                operationsRan = new boolean[inputs.size()];
                accumulator = 0;
            }
            String operation = inputs.get(index).trim();
            String[] operationAndValue = operation.split(" ");
            operationsRan[index] = true;
            if (InstructionEnum.ACCUMULATE.getInstruction().equals(operationAndValue[0])) {
                accumulator += Integer.parseInt(operationAndValue[1]);
                index++;
            } else if (InstructionEnum.JUMP_TO.getInstruction().equals(operationAndValue[0])) {
                countOfJmpOrNops++;
                if (countOfJmpOrNops == countOfShouldChange) {
                    //Change to nop
                    index++;
                } else {
                    index += Integer.parseInt(operationAndValue[1]);
                    ;
                }
            } else {
                countOfJmpOrNops++;
                if (countOfJmpOrNops == countOfShouldChange) {
                    //Change to jump
                    index += Integer.parseInt(operationAndValue[1]);
                } else {
                    index++;
                }
            }
        }
        return accumulator;
    }
}
