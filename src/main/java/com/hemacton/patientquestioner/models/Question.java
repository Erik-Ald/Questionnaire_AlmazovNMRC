package com.hemacton.patientquestioner.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition="TEXT")
    private String question;

    @Column
    private short pageNum;

    @Column
    private short questionNum;

    @Column
    private String answerType;

    @ManyToOne(fetch = FetchType.LAZY)
    private Questionnaires questionnaire;
}
