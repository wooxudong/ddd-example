package org.xudong.student.modulepolicy;

import org.xudong.student.Module;

import java.util.List;

public class MaximumModulePerDegree implements ModulePolicy {
    private final int maxModulesPerDegree;

    private MaximumModulePerDegree(int maxModulesPerDegree) {
        this.maxModulesPerDegree = maxModulesPerDegree;
    }

    public static MaximumModulePerDegree ofNewPolicy(int maxModulesPerDegree) {
        return new MaximumModulePerDegree(maxModulesPerDegree);
    }

    @Override
    public boolean isSatisfiedBy(List<Module> modules) {
        return modules.size() < maxModulesPerDegree;
    }
}
