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
    public class Quiz {
        @Id

        @SequenceGenerator(name = "quiz_sequence",
                sequenceName = "quiz_sequence", allocationSize = 1)
        @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "quiz_sequence")
        private Long id;

        @Column(name = "Question1", nullable = false)
        private String question1;

        @Column(name = "Question2", nullable = false)
        private String question2;

        @Column(name = "Question3", nullable = false)
        private String question3;

        @Column(name = "Question4", nullable = true)
        private String question4;

        @Column(name = "Question5", nullable = true)
        private String question5;

        @Column(name = "Question6", nullable = true)
        private String question6;

        @Column(name = "Question7", nullable = true)
        private String question7;

        @Column(name = "Question8", nullable = true)
        private String question8;

        @Column(name = "Question9", nullable = true)
        private String question9;

        @Column(name = "Question10", nullable = true)
        private String question10;

        @Column(name = "Course", nullable = true)
        private String course;
    }
