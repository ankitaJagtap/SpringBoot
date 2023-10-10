package com.firstProjecct.QuizApp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import javax.annotation.processing.Generated;
@Data
@Entity
public class Questions {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    private String category;
    private String difficultyLevel;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
    private String questions;
    private String answers;

}
