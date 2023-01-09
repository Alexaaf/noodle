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
public class Grade {
    @Id
    @SequenceGenerator(name = "grade_sequence",
            sequenceName = "grade_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "grade_sequence")
    private Long id;
    @Column(name = "course", nullable = false )
    private String course;

    @Column(name = "date", nullable = false)
    private String date;

    @Column(name = "grade", nullable = false)
    private String grade;

    @Column(name = "studentID", nullable = false)
    private String studentID;
}
