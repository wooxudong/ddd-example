package org.xudong.graduation;

import org.xudong.student.Student;
import org.xudong.student.StudentId;
import org.xudong.student.StudentRepository;
import org.xudong.student.criteria.ByMajor;
import org.xudong.student.criteria.ByYear;

import java.util.List;

public class GraduationService {

    public List<Student> graduatingStudentByMajor(String major) {
        StudentRepository studentRepository = new StudentRepository();
        String year = "final_year";
        return studentRepository.satisfiedBy(ByMajor.of(major), ByYear.of(year));
    }

    public void graduateStudents(List<StudentId> studentIds){
        StudentRepository studentRepository = new StudentRepository();
        studentRepository.archive(studentIds);
    }
}
