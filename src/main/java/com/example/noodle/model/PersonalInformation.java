package com.example.noodle.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PersonalInformation {
    @Id

    @SequenceGenerator(name = "info_sequence",
            sequenceName = "info_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "info_sequence")
    private Long id;

    @Column(name = "FirstName", nullable = false)
    private String firstName;

    @Column(name = "LastName", nullable = false)
    private String lastName;

    @Column(name = "PhoneNumber", nullable = false)
    private String phoneNumber;

    @Column(name = "BirthDate", nullable = true)
    private String birthDate;

    @Column(name = "Address", nullable = true)
    private String address;

    @Column(name = "City", nullable = true)
    private String city;

    @Column(name = "County", nullable = true)
    private String county;

    @Column(name = "University", nullable = false)
    private String university;

    @Column(name = "Faculty", nullable = false)
    private String faculty;

    @Column(name = "YearOfStudy", nullable = false)
    private String yearOfStudy;

    @Column(name = "StudentId", nullable = false)
    private Long studentId;
}
