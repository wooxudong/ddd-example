package org.xudong.student;

import org.xudong.ddd.ValueObject;

public class Module implements ValueObject {
    private final String moduleName;
    private final String grade;

    public Module(String moduleName, String grade) {
        this.moduleName = moduleName;
        this.grade = grade;
    }
}
