package rw.ac.rca.nat2022.server.dtos;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;

@Getter
@Setter
public class StudentDto {
    private String fullNames;
    private String gender;
    private String email;
    private String department;
    private String address;
}
