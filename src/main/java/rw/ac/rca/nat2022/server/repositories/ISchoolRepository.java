package rw.ac.rca.nat2022.server.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import rw.ac.rca.nat2022.server.models.School;

public interface ISchoolRepository extends JpaRepository<School, Long> {

}
