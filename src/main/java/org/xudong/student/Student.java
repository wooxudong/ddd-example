package org.xudong.student;

import org.xudong.ddd.AggregateRoot;
import org.xudong.student.modulepolicy.ModulePolicy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Student extends AggregateRoot<StudentId> {
    private final String name;
    private final ModuleHistory moduleHistory;
    private final ActiveModules activeModules;
    private final Major major;
    private final List<ModulePolicy> termPolicies;
    private final List<ModulePolicy> degreePolicies;

    public Student(String name, Major major) {
        super(new StudentId());
        this.moduleHistory = new ModuleHistory();
        this.activeModules = new ActiveModules();
        this.major = major;
        this.name = name;
        this.termPolicies = new ArrayList<>();
        this.degreePolicies = new ArrayList<>();
    }

    public void addTermPolicies(ModulePolicy... newPolicies) {
        termPolicies.addAll(Arrays.asList(newPolicies));
    }

    public void addDegreePolicies(ModulePolicy... newPolicies) {
        degreePolicies.addAll(Arrays.asList(newPolicies));
    }

    public StudentId getStudentId() {
        return getId();
    }

    public void register(Module newModule) {

        boolean isOkForCurrentTerm = termPolicies.stream().allMatch(activeModules::satisfyPolicy);
        if (!isOkForCurrentTerm)
            throw new UnsupportedOperationException("Registered Modules have exceeded the maximum number(40) in total");

        boolean isOkForDegree = degreePolicies.stream().allMatch(moduleHistory::satisfyPolicy);
        if (!isOkForDegree)
            throw new UnsupportedOperationException("Registered Modules have exceeded the maximum number(6) for current semester");

        activeModules.register(newModule);
    }
}
