package rw.ac.rca.nat2022.server.services.impl;

import org.springframework.stereotype.Service;
import rw.ac.rca.nat2022.server.dtos.StudentDto;
import rw.ac.rca.nat2022.server.models.Student;
import rw.ac.rca.nat2022.server.repositories.IStudentRepository;
import rw.ac.rca.nat2022.server.services.IStudentService;

import java.util.List;

@Service
public class StudentServiceImpl implements IStudentService {
    private final IStudentRepository studentRepository;

    public StudentServiceImpl(IStudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Student createStudent(StudentDto studentDTO) {
        return studentRepository.save(new Student(studentDTO));
    }

    @Override
    public Student updateStudent(Long id, StudentDto student) {
        getStudent(id);
        Student studentToUpdate = new Student(student);
        studentToUpdate.setId(id);
        studentToUpdate.setFullNames(student.getFullNames());
        studentToUpdate.setAddress(student.getAddress());
        studentToUpdate.setDepartment(student.getDepartment());
        studentToUpdate.setEmail(student.getEmail());
        studentToUpdate.setGender(student.getGender());
        return studentRepository.save(studentToUpdate);
    }

    @Override
    public Student getStudent(Long id) {
       return studentRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("Student not found")
         );
    }

    @Override
    public void deleteStudent(Long id) {
        getStudent(id);
        studentRepository.deleteById(id);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }
}
