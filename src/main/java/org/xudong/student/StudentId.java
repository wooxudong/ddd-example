package org.xudong.student;

import org.xudong.ddd.Identifier;

import java.util.UUID;

public class StudentId implements  Identifier {
    private final String id;

    public StudentId() {
        id = UUID.randomUUID().toString();
    }

    @Override
    public String toString() {
        return "StudentId{" +
                "id='" + id + '\'' +
                '}';
    }
}
