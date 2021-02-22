package org.xudong.student.modulepolicy;

import org.xudong.student.Module;

import java.util.List;

public interface ModulePolicy {
    public boolean isSatisfiedBy(List<Module> modules);
}
