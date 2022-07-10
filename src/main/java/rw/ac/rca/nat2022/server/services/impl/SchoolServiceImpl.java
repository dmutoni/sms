package rw.ac.rca.nat2022.server.services.impl;

import org.springframework.stereotype.Service;
import rw.ac.rca.nat2022.server.dtos.SchoolDto;
import rw.ac.rca.nat2022.server.models.School;
import rw.ac.rca.nat2022.server.models.Student;
import rw.ac.rca.nat2022.server.repositories.ISchoolRepository;
import rw.ac.rca.nat2022.server.services.ISchoolService;

import java.util.List;

@Service
public class SchoolServiceImpl implements ISchoolService {

    private final ISchoolRepository schoolRepository;

    public SchoolServiceImpl(ISchoolRepository schoolRepository) {
        this.schoolRepository = schoolRepository;
    }

    /**
     * @param school 
     * @return
     */
    @Override
    public School createSchool(SchoolDto school) {
        return schoolRepository.save(new School(school));
    }

    /**
     * @param school 
     * @return
     */
    @Override
    public School updateSchool(Long id, SchoolDto school) {
        getSchool(id);
        School schoolToUpdate = new School(school);
        schoolToUpdate.setId(id);
        schoolToUpdate.setName(school.getName());
        schoolToUpdate.setAddress(school.getAddress());
        return schoolRepository.save(schoolToUpdate);
    }

    /**
     * @param id 
     * @return
     */
    @Override
    public School getSchool(Long id) {
        return schoolRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("School not found")
        );
    }

    /**
     * @param id 
     * @return
     */
    @Override
    public void deleteSchool(Long id) {
        schoolRepository.deleteById(id);
    }

    /**
     * @return 
     */
    @Override
    public List<School> getAllSchools() {
        return schoolRepository.findAll();
    }
}
