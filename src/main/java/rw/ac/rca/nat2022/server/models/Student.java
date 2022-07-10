package rw.ac.rca.nat2022.server.models;

import lombok.Getter;
import lombok.Setter;
import rw.ac.rca.nat2022.server.dtos.StudentDto;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "full_name", unique = false)
    private String fullNames;
    @Column(name = "gender", unique = false)
    private String gender;
    @Column(unique = true)
    private String email;
    private String department;
    private String address;
    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "Student_school",
            joinColumns = { @JoinColumn(name = "student_id") },
            inverseJoinColumns = { @JoinColumn(name = "school_id") }
    )
    Set<School> schools = new HashSet<>();

    public Student(StudentDto studentDto) {
        this.setFullNames(studentDto.getFullNames());
        this.setGender(studentDto.getGender());
        this.setEmail(studentDto.getEmail());
        this.setDepartment(studentDto.getDepartment());
        this.setAddress(studentDto.getAddress());
    }

    public Student() {

    }
}
