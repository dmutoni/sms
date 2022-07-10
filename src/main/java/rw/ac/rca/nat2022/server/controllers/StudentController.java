package rw.ac.rca.nat2022.server.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import rw.ac.rca.nat2022.server.dtos.StudentDto;
import rw.ac.rca.nat2022.server.services.IStudentService;
import rw.ac.rca.nat2022.server.utils.ApiResponse;

@RestController
@RequestMapping("/api/schools")
public class StudentController {
    public final IStudentService studentService;

    public StudentController(IStudentService studentService) {
        this.studentService = studentService;
    }
    @GetMapping("/all")
    public ApiResponse getAllStudents() {
        return new ApiResponse(HttpStatus.OK, true, "Student fetched", studentService.getAllStudents());
    }
    @GetMapping("/{id}")
    public ApiResponse getStudent(@PathVariable() Long id) {
        return new ApiResponse(HttpStatus.OK, true, "Student fetched", studentService.getStudent(id));
    }
    @PostMapping("/create")
    public ApiResponse createStudent(@RequestBody() StudentDto student) {
        return new ApiResponse(HttpStatus.OK, true, "Student fetched", studentService.createStudent(student));
    }
    @PutMapping("/update/{id}")
    public ApiResponse updateStudent(@PathVariable() Long id, @RequestBody StudentDto student) {
        return new ApiResponse(HttpStatus.OK, true, "Student fetched", studentService.updateStudent(id, student));
    }
    @DeleteMapping("/delete/{id}")
    public ApiResponse deleteStudent(@PathVariable() Long id) {
        studentService.deleteStudent(id);
        return new ApiResponse(HttpStatus.OK, true, "Student fetched", null);
    }
}
