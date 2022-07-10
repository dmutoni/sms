package rw.ac.rca.nat2022.server.models;
import lombok.Getter;
import lombok.Setter;
import rw.ac.rca.nat2022.server.dtos.SchoolDto;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "student")
public class School {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String name;
    private String address;
    @ManyToMany(mappedBy = "schools")
    private Set<Student> students = new HashSet<>();

    public School(SchoolDto school) {
        this.name = school.getName();
        this.address = school.getAddress();
    }
}
