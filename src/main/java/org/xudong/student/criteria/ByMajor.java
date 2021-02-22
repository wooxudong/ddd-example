package org.xudong.student.criteria;

public class ByMajor extends Equal {
    private final static String fieldName = "MAJOR";

    private ByMajor(String major) {
        super(fieldName, major);
    }

    public static ByMajor of(String major) {
        return new ByMajor(major);
    }

}
