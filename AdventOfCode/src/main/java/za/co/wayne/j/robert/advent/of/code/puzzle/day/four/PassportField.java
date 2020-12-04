package za.co.wayne.j.robert.advent.of.code.puzzle.day.four;

public enum PassportField {
    BIRTH_YEAR("byr"),
    ISSUE_YEAR("iyr"),
    EXPIRE_YEAR("eyr"),
    HEIGHT("hgt"),
    HAIR_COLOUR("hcl"),
    EYE_COLOUR("ecl"),
    PASSPORT_ID("pid");

    private String fieldName;

    PassportField(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getFieldName() {
        return fieldName;
    }
}
