package com.hemacton.patientquestioner.services;

import com.hemacton.patientquestioner.models.Questionnaires;
import com.hemacton.patientquestioner.models.Question;
import com.hemacton.patientquestioner.repositories.QuestionsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class QuestionsService {

    private final QuestionnairesService questionnairesService;

    private final QuestionsRepository questionsRepository;

    public List<Question> getQuestions(String questionnaireName, short pageNum){
        Questionnaires questionnaire = questionnairesService.getQuestioner(questionnaireName);
        return questionsRepository.getQuestionsByQuestionnaireAndPageNumOrderByQuestionNum(questionnaire,pageNum);
    }
}
