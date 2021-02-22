package org.xudong.student.criteria;

public class ByYear extends Equal {
    private final static String filedName = "YEAR";

    private ByYear (String year){
        super(filedName, year);
    }

    public static ByYear of(String year){
        return new ByYear(year);
    }
}
