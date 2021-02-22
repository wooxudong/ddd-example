package org.xudong.student.criteria;

import org.jooq.Condition;

import static org.jooq.impl.DSL.field;

public abstract class Equal implements ICriteria {

    private final String fieldName;
    private final String value;

    Equal(String fieldName, String value) {
        this.fieldName = fieldName;
        this.value = value;
    }

    @Override
    public Condition getCriteria() {
        return field(fieldName).eq(value);
    }
}
