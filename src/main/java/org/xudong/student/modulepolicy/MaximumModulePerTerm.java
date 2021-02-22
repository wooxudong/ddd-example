package org.xudong.student.modulepolicy;

import org.xudong.student.Module;

import java.util.List;

public class MaximumModulePerTerm implements ModulePolicy {

    private final int maxModulesPerTerm;

    private MaximumModulePerTerm(int maxModulesPerTerm) {
        this.maxModulesPerTerm = maxModulesPerTerm;
    }

    public static MaximumModulePerTerm ofNewPolicy(int maxModulesPerTerm) {
        return new MaximumModulePerTerm(maxModulesPerTerm);
    }

    @Override
    public boolean isSatisfiedBy(List<Module> modules) {
        return modules.size() < maxModulesPerTerm;
    }
}
