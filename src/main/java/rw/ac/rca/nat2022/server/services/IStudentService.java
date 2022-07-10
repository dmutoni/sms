package rw.ac.rca.nat2022.server.services;

import rw.ac.rca.nat2022.server.dtos.StudentDto;
import rw.ac.rca.nat2022.server.models.Student;

import java.util.List;

public interface IStudentService {
    Student createStudent(StudentDto student);
    Student updateStudent(Long id, StudentDto student);
    Student getStudent(Long id);
    void deleteStudent(Long id);
    List<Student> getAllStudents();
}
