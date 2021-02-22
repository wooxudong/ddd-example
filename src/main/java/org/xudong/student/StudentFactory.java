package org.xudong.student;

import org.xudong.student.modulepolicy.MajorQualifiedByCoreModules;
import org.xudong.student.modulepolicy.MaximumModulePerDegree;
import org.xudong.student.modulepolicy.MaximumModulePerTerm;

import java.util.Collections;
import java.util.List;

public class StudentFactory {

    private final static int DEFAULT_MAX_PER_TERM = 6;
    private final static int DEFAULT_MAX_PER_DEGREE = 40;

    public static Student create(String name, String majorName) {
        Major major = new Major(majorName);
        List<Module> coreModules = Collections.emptyList();
        major.addCoreModules(coreModules);

        Student student = new Student(name, major);
        student.addTermPolicies(MaximumModulePerTerm.ofNewPolicy(DEFAULT_MAX_PER_TERM));
        student.addDegreePolicies(MaximumModulePerDegree.ofNewPolicy(DEFAULT_MAX_PER_DEGREE));
        student.addDegreePolicies(MajorQualifiedByCoreModules.ofNewPolicy(coreModules));
        return student;
    }
}
