package org.xudong.student.modulepolicy;

import org.xudong.student.Module;

import java.util.List;

public class MajorQualifiedByCoreModules implements ModulePolicy {

    private final List<Module> coreModules;

    private MajorQualifiedByCoreModules(List<Module> coreModules) {
        this.coreModules = coreModules;
    }

    public static MajorQualifiedByCoreModules ofNewPolicy(List<Module> coreModules){
        return new MajorQualifiedByCoreModules(coreModules);
    }
    @Override
    public boolean isSatisfiedBy(List<Module> taken) {
        return taken.containsAll(coreModules);
    }
}
