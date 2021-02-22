package org.xudong.teacher;

import org.xudong.ddd.Identifier;

public class StaffId implements Identifier {
    private final String StaffId;

    public StaffId(String staffId) {
        StaffId = staffId;
    }
}
