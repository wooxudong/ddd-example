package org.xudong.teacher;

public class Office {
    private final String faculty;
    private final String roomNumber;

    public Office(String faculty, String roomNumber) {
        this.faculty = faculty;
        this.roomNumber = roomNumber;
    }


    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (o == null || o.getClass() != getClass()) {
            return false;
        }
        return faculty.equals(((Office) o).faculty) && roomNumber.equals(((Office) o).roomNumber);
    }
}
