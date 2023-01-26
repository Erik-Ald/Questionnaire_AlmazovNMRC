package com.hemacton.patientquestioner.services;

import com.hemacton.patientquestioner.models.Questionnaires;
import com.hemacton.patientquestioner.repositories.QuestionnairesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class QuestionnairesService {

    private final QuestionnairesRepository questionnairesRepository;

    public Questionnaires getQuestioner(String name) {
        return questionnairesRepository.findByQuestionerName(name).orElseThrow();
    }
}
