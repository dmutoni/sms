package rw.ac.rca.nat2022.server.services;

import rw.ac.rca.nat2022.server.dtos.SchoolDto;
import rw.ac.rca.nat2022.server.models.School;

import java.util.List;

public interface ISchoolService {
    School createSchool(SchoolDto school);
    School updateSchool(Long id, SchoolDto school);
    School getSchool(Long id);
    void deleteSchool(Long id);
    List<School> getAllSchools();
}
