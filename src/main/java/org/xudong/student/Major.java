package org.xudong.student;

import org.xudong.ddd.ValueObject;

import java.util.List;

public class Major implements ValueObject {
    private List<Module> coreModules;
    private final String name;

    public Major(List<Module> coreModules, String name) {
        this.coreModules = coreModules;
        this.name = name;
    }

    public Major(String name) {
        this.name = name;
    }

    public void addCoreModules(List<Module> emptyList) {
        coreModules.addAll(emptyList);
    }
}
