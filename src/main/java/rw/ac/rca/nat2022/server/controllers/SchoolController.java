package rw.ac.rca.nat2022.server.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import rw.ac.rca.nat2022.server.dtos.SchoolDto;
import rw.ac.rca.nat2022.server.dtos.StudentDto;
import rw.ac.rca.nat2022.server.services.ISchoolService;
import rw.ac.rca.nat2022.server.utils.ApiResponse;

public class SchoolController {
    public final ISchoolService schoolService;
    public SchoolController(ISchoolService schoolService) {
        this.schoolService = schoolService;
    }
    @GetMapping("/all")
    public ApiResponse getAllSchools() {
        return new ApiResponse(HttpStatus.OK, true, "School fetched", schoolService.getAllSchools());
    }
    @GetMapping("/{id}")
    public ApiResponse getSchool(@PathVariable() Long id) {
        return new ApiResponse(HttpStatus.OK, true, "School fetched", schoolService.getSchool(id));
    }
    @PostMapping("/create")
    public ApiResponse createSchool(@RequestBody() SchoolDto schoolDto) {
        return new ApiResponse(HttpStatus.OK, true, "School fetched", schoolService.createSchool(schoolDto));
    }
    @PutMapping("/update/{id}")
    public ApiResponse updateSchool(@PathVariable() Long id, @RequestBody SchoolDto schoolDto) {
        return new ApiResponse(HttpStatus.OK, true, "School fetched", schoolService.updateSchool(id, schoolDto));
    }
    @DeleteMapping("/delete/{id}")
    public ApiResponse deleteSchool(@PathVariable() Long id){
        schoolService.deleteSchool(id);
        return new ApiResponse(HttpStatus.OK, true, "School fetched", null);
    }
}
