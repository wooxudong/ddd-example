package org.xudong.student;

import org.xudong.ddd.ValueObject;
import org.xudong.student.modulepolicy.ModulePolicy;

import java.util.ArrayList;
import java.util.List;

public class ActiveModules implements ValueObject {
    private final List<Module> modules;

    public ActiveModules() {
        modules = new ArrayList<>();
    }

    public List<Module> getModules() {
        return modules;
    }

    public void register(Module newModule) {
        modules.add(newModule);
    }

    public boolean satisfyPolicy(ModulePolicy policy){
        return policy.isSatisfiedBy(modules);
    }
}
