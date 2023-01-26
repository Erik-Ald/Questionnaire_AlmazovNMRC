package com.hemacton.patientquestioner.services;

import com.hemacton.patientquestioner.models.Answer;
import com.hemacton.patientquestioner.repositories.AnswerRepository;
import com.hemacton.patientquestioner.repositories.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AnswerService {

    private final AnswerRepository answerRepository;
    private final PatientRepository patientRepository;

    public void addAnswer(Answer answer, Long patientId){

        Answer newAnswer = answer.builder()
                .answer(answer.getAnswer())
                .question(answer.getQuestion())
                .patient(patientRepository.getReferenceById(patientId))
                .build();

        answerRepository.save(newAnswer);
    }
}
