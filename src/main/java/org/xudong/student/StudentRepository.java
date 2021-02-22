package org.xudong.student;

import org.jooq.Condition;
import org.jooq.Select;
import org.jooq.impl.DSL;
import org.xudong.student.criteria.ICriteria;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.jooq.impl.DSL.field;
import static org.jooq.impl.DSL.table;

public class StudentRepository {

    public List<Student> satisfiedBy(ICriteria... criterias) {
        Optional<Condition> combined = Arrays.stream(criterias)
                .map(ICriteria::getCriteria)
                .reduce(Condition::and);
        if (!combined.isPresent()) {
            throw new UnsupportedOperationException("One criteria is needed to fetch the students.");
        }
        Select<?> selectStatements = DSL.select()
                .from(table("STUDENT"))
                .where(combined.get());
        return selectStatements.fetch().into(Student.class);
    }

    public void archive(List<StudentId> studentIds) {
        studentIds.stream()
                .map(studentId -> field("ID").eq(studentId))
                .forEach(condition -> DSL.deleteFrom(table("STUDENT")).where(condition));
    }
}
