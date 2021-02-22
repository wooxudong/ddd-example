package org.xudong.student;

import org.xudong.ddd.ValueObject;
import org.xudong.student.modulepolicy.ModulePolicy;

import java.util.*;

public class ModuleHistory implements ValueObject {
    private final Map<String, List<Module>> moduleHistories;

    public ModuleHistory() {
        this.moduleHistories = new HashMap<>();
    }

    private List<Module> getModules() {
        List<Module> allModules = new ArrayList<>();
        moduleHistories.values().forEach(allModules::addAll);
        return allModules;
    }

    public boolean satisfyPolicy(ModulePolicy policy){
        return policy.isSatisfiedBy(getModules());
    }
}
